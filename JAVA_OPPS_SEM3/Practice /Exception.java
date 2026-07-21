public class Exception {

    public static void main(String[] args) {
        try {
            int a = 10;
            int b = 0;
            System.out.println("Try block");
            int c = a / b;
            System.out.println(c);
            System.exit(0);
            System.out.println("After exit");

        } catch (ArithmeticException e) {

            System.exit(0);
            System.out.println("Arithmetic Exception");
            System.out.println("After exit");

        } finally {
            System.out.println("Finally block");
        }
    }

}
