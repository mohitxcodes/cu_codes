import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class QuestionG {
    static int n;
    static int[] left;
    static int[] right;
    static int[] parent;
    static long[] t_escape;

    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    solve();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "solve", 1 << 26).start();
    }

    public static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        if (!st.hasMoreTokens())
            return;
        int t = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            left = new int[n + 1];
            right = new int[n + 1];
            parent = new int[n + 1];
            t_escape = new long[n + 1];

            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                left[i] = l;
                right[i] = r;
                if (l != 0)
                    parent[l] = i;
                if (r != 0)
                    parent[r] = i;
            }
            parent[1] = 0;

            dfsEscape(1);

            for (int j = 0; j < q; j++) {
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                long k = Long.parseLong(st.nextToken());

                int curr = v;
                while (true) {
                    if (k < t_escape[curr]) {
                        int finalNode = findInSubtree(curr, k);
                        sb.append(finalNode).append(j == q - 1 ? "" : " ");
                        break;
                    }

                    k -= t_escape[curr];
                    int p = parent[curr];
                    if (p == 0) {
                        break;
                    }

                    if (curr == left[p]) {
                        if (k < 1) {
                            sb.append(p).append(j == q - 1 ? "" : " ");
                            break;
                        }
                        k -= 1;

                        int r = right[p];

                        if (k < t_escape[r]) {
                            int finalNode = findInSubtree(r, k);
                            sb.append(finalNode).append(j == q - 1 ? "" : " ");
                            break;
                        }
                        k -= t_escape[r];
                        if (k < 1) {
                            sb.append(p).append(j == q - 1 ? "" : " ");
                            break;
                        }
                        k -= 1;
                        curr = p;
                    } else {
                        if (k < 1) {
                            sb.append(p).append(j == q - 1 ? "" : " ");
                            break;
                        }
                        k -= 1;
                        curr = p; // Continue up
                    }
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void dfsEscape(int u) {
        if (left[u] == 0 && right[u] == 0) {
            t_escape[u] = 1;
            return;
        }
        int l = left[u];
        int r = right[u];
        dfsEscape(l);
        dfsEscape(r);
        t_escape[u] = t_escape[l] + t_escape[r] + 3;
    }

    static int findInSubtree(int u, long k) {
        if (k == 0)
            return u;

        if (k < 1)
            return u;
        k -= 1;

        int l = left[u];
        int r = right[u];

        if (k < t_escape[l]) {
            return findInSubtree(l, k);
        }
        k -= t_escape[l];

        if (k < 1)
            return u;
        k -= 1;

        if (k < 1)
            return u;
        k -= 1;

        if (k < t_escape[r]) {
            return findInSubtree(r, k);
        }
        k -= t_escape[r];

        if (k < 1)
            return u;
        k -= 1;

        return u;
    }
}
