import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                long[] f = new long[n + 1];
                for (int i = 1; i <= n; i++) {
                    f[i] = sc.nextLong();
                }

                long[] a = new long[n + 1];

                if (n == 2) {
                    a[1] = f[2];
                    a[2] = f[1];
                } else {
                    for (int i = 2; i < n; i++) {
                        long diff = f[i + 1] - 2 * f[i] + f[i - 1];
                        a[i] = diff / 2;
                    }

                    long sumForAn = 0;
                    for (int i = 2; i < n; i++) {
                        sumForAn += a[i] * (i - 1);
                    }
                    a[n] = (f[1] - sumForAn) / (n - 1);

                    long sumForA1 = 0;
                    for (int i = 2; i < n; i++) {
                        sumForA1 += a[i] * (n - i);
                    }
                    a[1] = (f[n] - sumForA1) / (n - 1);
                }

                StringBuilder sb = new StringBuilder();
                for (int i = 1; i <= n; i++) {
                    sb.append(a[i]).append(i == n ? "" : " ");
                }
                System.out.println(sb);
            }
        }
        sc.close();
    }
}
