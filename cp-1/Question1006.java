import java.util.*;

public class Question1006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        if (k == 1) {
            int maxVal = 0;
            for (int x : a)
                maxVal = Math.max(maxVal, x);
            System.out.println(maxVal);
            System.out.println(n);
            sc.close();
            return;
        }

        int[] maxSuffix = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            maxSuffix[i] = Math.max(a[i], maxSuffix[i + 1]);
        }

        long bestProfit = Long.MIN_VALUE;
        int bestJ = k - 2;

        for (int j = k - 2; j <= n - 2; j++) {
            // Sum of top (k-1) values in a[0..j]
            int[] sub = Arrays.copyOfRange(a, 0, j + 1);
            Arrays.sort(sub);
            long topSum = 0;
            for (int i = j; i > j - (k - 1); i--) {
                topSum += sub[i];
            }
            long total = topSum + maxSuffix[j + 1];
            if (total > bestProfit) {
                bestProfit = total;
                bestJ = j;
            }
        }

        System.out.println(bestProfit);

        // Reconstruct: pick top (k-1) indices from a[0..bestJ] sorted by value desc
        Integer[] idxArr = new Integer[bestJ + 1];
        for (int i = 0; i <= bestJ; i++)
            idxArr[i] = i;
        Arrays.sort(idxArr, (x, y) -> a[y] - a[x]); // descending by value

        List<Integer> splitEnds = new ArrayList<>();
        for (int i = 0; i < k - 1; i++) {
            splitEnds.add(idxArr[i]);
        }
        Collections.sort(splitEnds); // sort indices in ascending order
        splitEnds.add(n - 1); // last day always ends at n-1

        StringBuilder sb = new StringBuilder();
        int prev = -1;
        for (int end : splitEnds) {
            if (sb.length() > 0)
                sb.append(" ");
            sb.append(end - prev);
            prev = end;
        }
        System.out.println(sb);

        sc.close();
    }
}
