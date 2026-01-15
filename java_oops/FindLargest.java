public class FindLargest {

    int largest(int arr[]) {
        int largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 12, 3, 4, 5 };
        FindLargest findLargest = new FindLargest();
        System.out.println(findLargest.largest(arr));
    }

}
