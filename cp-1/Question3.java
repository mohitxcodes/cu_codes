import java.util.Scanner;
import java.util.Arrays;

public class Question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] a = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = sc.nextInt();
                }

                int[] dp = new int[7];
                for (int v = 1; v <= 6; v++) {
                    dp[v] = (a[0] == v) ? 0 : 1;
                }

                for (int i = 1; i < n; i++) {
                    int[] next_dp = new int[7];
                    Arrays.fill(next_dp, Integer.MAX_VALUE);

                    for (int v = 1; v <= 6; v++) {
                        int cost = (a[i] == v) ? 0 : 1;
                        for (int u = 1; u <= 6; u++) {
                            if (isAdjacent(u, v)) {
                                if (dp[u] != Integer.MAX_VALUE) {
                                    next_dp[v] = Math.min(next_dp[v], dp[u] + cost);
                                }
                            }
                        }
                    }
                    dp = next_dp;
                }

                int ans = Integer.MAX_VALUE;
                for (int v = 1; v <= 6; v++) {
                    ans = Math.min(ans, dp[v]);
                }
                System.out.println(ans);
            }
        }
        sc.close();
    }

    private static boolean isAdjacent(int u, int v) {
        return u != v && u + v != 7;
    }
}
