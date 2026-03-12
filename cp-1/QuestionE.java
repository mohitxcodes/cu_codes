import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class QuestionE {
    static int n;
    static int[] left;
    static int[] right;
    static int[] parent;
    static long[] t_escape;
    static long[] ans;
    static final long MOD = 1000000007;

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

            left = new int[n + 1];
            right = new int[n + 1];
            parent = new int[n + 1];
            t_escape = new long[n + 1];
            ans = new long[n + 1];

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

            ans[1] = t_escape[1];
            dfsAns(1, 0);

            for (int i = 1; i <= n; i++) {
                sb.append(ans[i]).append(i == n ? "" : " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void dfsEscape(int u) {
        if (left[u] == 0 && right[u] == 0) { // Leaf
            t_escape[u] = 1;
            return;
        }
        int l = left[u];
        int r = right[u];

        dfsEscape(l);
        dfsEscape(r);

        long val = (t_escape[l] + t_escape[r] + 3) % MOD;
        t_escape[u] = val;
    }

    static void dfsAns(int u, long upVal) {
        ans[u] = (t_escape[u] + upVal) % MOD;

        if (left[u] != 0) {
            int l = left[u];
            int r = right[u];

            long upForLeft = ans[u];
            dfsAns(l, upForLeft);

            long upForRight = ans[u];
            dfsAns(r, upForRight);
        }
    }
}
