import java.util.Scanner;
import java.util.ArrayList;

public class QuestionF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                long[] A = new long[n];
                long[] B = new long[n];
                long[] C = new long[n];

                for (int i = 0; i < n; i++) {
                    A[i] = sc.nextLong();
                    B[i] = sc.nextLong();
                    C[i] = sc.nextLong();
                }

                int[] dp_in = new int[n];
                int[] dp_out = new int[n];

                ArrayList<Integer>[] adj = new ArrayList[n];
                ArrayList<Integer>[] rev_adj = new ArrayList[n];
                for (int i = 0; i < n; i++) {
                    adj[i] = new ArrayList<>();
                    rev_adj[i] = new ArrayList<>();
                }

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (i == j)
                            continue;
                        if (isAbove(A[i], B[i], C[i], A[j], B[j], C[j])) {
                            adj[i].add(j);
                            rev_adj[j].add(i);
                        }
                    }
                }

                int[] memo_in = new int[n];
                int[] memo_out = new int[n];

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    int in = solveIn(i, rev_adj, memo_in);
                    int out = solveOut(i, adj, memo_out);
                    sb.append(in + out - 1).append(i == n - 1 ? "" : " ");
                }
                System.out.println(sb);
            }
        }
        sc.close();
    }

    private static boolean isAbove(long a1, long b1, long c1, long a2, long b2, long c2) {
        long A = a1 - a2;
        long B = b1 - b2;
        long C = c1 - c2;

        if (A > 0) {
            return B * B - 4 * A * C < 0;
        } else if (A == 0) {
            return B == 0 && C > 0;
        } else {
            return false;
        }
    }

    private static int solveIn(int u, ArrayList<Integer>[] rev_adj, int[] memo) {
        if (memo[u] != 0)
            return memo[u];
        int max = 0;
        for (int prev : rev_adj[u]) {
            max = Math.max(max, solveIn(prev, rev_adj, memo));
        }
        return memo[u] = 1 + max;
    }

    private static int solveOut(int u, ArrayList<Integer>[] adj, int[] memo) {
        if (memo[u] != 0)
            return memo[u];
        int max = 0;
        for (int next : adj[u]) {
            max = Math.max(max, solveOut(next, adj, memo));
        }
        return memo[u] = 1 + max;
    }
}
