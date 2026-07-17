public class InversionCount {

    public static int countInversions(int[] arr) {
        if (arr == null || arr.length <= 1)
            return 0;
        
        int n = arr.length;
        int count = 0;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        System.out.println(countInversions(arr));
    }

    