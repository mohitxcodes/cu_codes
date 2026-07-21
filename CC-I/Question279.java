import java.util.Scanner;

public class Question279 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long t = sc.nextLong();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int maxBooks = 0;
        long currentSum = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            currentSum += a[right];

            while (currentSum > t) {
                currentSum -= a[left];
                left++;
            }
            Math.max(maxBooks, right - left + 1);
        }

        System.out.println(maxBooks);
        sc.close();
    }
}
