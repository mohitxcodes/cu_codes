import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                boolean found67 = false;
                for (int i = 0; i < n; i++) {
                    if (sc.hasNextInt()) {
                        int val = sc.nextInt();
                        if (val == 67) {
                            found67 = true;
                        }
                    }
                }
                if (found67) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
        sc.close();
    }
}
