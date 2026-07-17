public class Main {
    public static void main(String[] args) {
        int num1 = 45;
        int num2 = 78;
        int num3 = 12;

        int greatest = Math.max(num1, Math.max(num2, num3));
        System.out.println("The greatest number is: " + greatest);