import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long t = sc.nextLong();

        long[] machines = new long[n];

        for (int i = 0; i < n; i++) {
            machines[i] = sc.nextLong();
        }

        long minTime = Long.MAX_VALUE;
        for(long i : machines){
            minTime = Math.min(minTime, i);
        }


        long left = 1;
        long right = minTime * t;
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            long products = 0;

            for (int i = 0; i < n; i++) {
                products += mid / machines[i];

                if (products >= t) break; 
            }

            if (products >= t) {
                answer = mid;
                right = mid - 1; 
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}