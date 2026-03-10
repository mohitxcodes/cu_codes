package pratice;

import java.util.ArrayList;

public class MultiplyMatrix {

    static ArrayList<ArrayList<Integer>> multiply(int[][] a, int[][] b) {
        int n = a.length;
        ArrayList<ArrayList<Integer>> c = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            c.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    c.get(i).add(a[i][k] * b[k][j]);
                }
            }
        }

        return c;
    };

    public static void main(String[] args) {
        int[][] a = { { 1, 1 }, { 1, 1 } };
        int[][] b = { { 1, 1 }, { 1, 1 } };
        System.out.println(multiply(a, b));
    }
}
