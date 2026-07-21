import java.util.Arrays;
import java.util.Scanner;

public class FindBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] binary = new int[100];
        int i = 0;

        while (n > 0) {
            int rem = n % 2;
            binary[i] = rem;
            i++;
            n = n / 2;
        }

        for (int j = i - 1; j >= 0; j--) {
            System.out.print(binary[j]);
        }
    }

}
