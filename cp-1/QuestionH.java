import java.util.Scanner;
import java.util.ArrayList;

public class QuestionH {
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    static class Triangle {
        Point p1, p2, p3;

        Triangle(Point p1, Point p2, Point p3) {
            this.p1 = p1;
            this.p2 = p2;
            this.p3 = p3;
        }

        @Override
        public String toString() {
            return p1 + " " + p2 + " " + p3;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();

                ArrayList<Triangle> triangles = new ArrayList<>();
                boolean[][] filled = new boolean[n][n];

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n - 1; j += 2) {
                        add3x6(triangles, i, j);
                        filled[i][j] = true;
                        filled[i][j + 1] = true;
                    }
                }

                if (n % 2 != 0) {
                    int j = n - 1;
                    for (int i = 0; i < n - 1; i += 2) {
                        add6x3(triangles, i, j);
                        filled[i][j] = true;
                        filled[i + 1][j] = true;
                    }
                    add3x3(triangles, n - 1, n - 1);
                    filled[n - 1][n - 1] = true;
                }

                System.out.println(triangles.size());
                for (Triangle tri : triangles) {
                    System.out.println(tri);
                }
            }
        }
        sc.close();
    }

    static void add3x6(ArrayList<Triangle> list, int rowBlock, int colBlock) {
        int baseRow = 3 * rowBlock + 1;
        int baseCol = 3 * colBlock + 1;
        for (int k = 0; k < 3; k++) {
            int c = baseCol + 2 * k;
            int r = baseRow;
            addRect3x2(list, r, c);
        }
    }

    static void add6x3(ArrayList<Triangle> list, int rowBlock, int colBlock) {
        int baseRow = 3 * rowBlock + 1;
        int baseCol = 3 * colBlock + 1;
        for (int k = 0; k < 3; k++) {
            int r = baseRow + 2 * k;
            int c = baseCol;
            addRect2x3(list, r, c);
        }
    }

    static void add3x3(ArrayList<Triangle> list, int rowBlock, int colBlock) {
        int baseRow = 3 * rowBlock + 1;
        int baseCol = 3 * colBlock + 1;
        addRect3x2(list, baseRow, baseCol);
    }

    static void addRect3x2(ArrayList<Triangle> list, int r, int c) {
        list.add(new Triangle(new Point(r, c), new Point(r, c + 1), new Point(r + 1, c + 1)));
        list.add(new Triangle(new Point(r + 1, c), new Point(r + 2, c), new Point(r + 2, c + 1)));
    }

    static void addRect2x3(ArrayList<Triangle> list, int r, int c) {
        list.add(new Triangle(new Point(r, c), new Point(r + 1, c), new Point(r + 1, c + 1)));
        list.add(new Triangle(new Point(r, c + 1), new Point(r, c + 2), new Point(r + 1, c + 2)));
    }
}
