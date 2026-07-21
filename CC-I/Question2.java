import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                boolean possible = true;
                for (int i = 1; i <= n; i++) {
                    if (sc.hasNextInt()) {
                        int val = sc.nextInt();
                        if (getOdd(val) != getOdd(i)) {
                            possible = false;
                        }
                    }
                }
                if (possible) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
        sc.close();
    }

    private static int getOdd(int n) {
        while (n % 2 == 0) {
            n /= 2;
        }
        return n;
    }
}
