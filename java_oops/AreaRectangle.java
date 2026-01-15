public class AreaRectangle {

    int length;
    int width;

    int areaRec() {
        return length * width;
    }

    public static void main(String[] args) {
        AreaRectangle areaRectangle = new AreaRectangle();
        areaRectangle.length = 10;
        areaRectangle.width = 20;
        System.out.println("Area of Rectangle is: " + areaRectangle.areaRec());
    }
}
