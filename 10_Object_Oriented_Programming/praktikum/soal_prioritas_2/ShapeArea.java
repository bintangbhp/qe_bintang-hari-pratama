public class ShapeArea {
    private static final double PI = 3.14;

    public static int getSquareArea(int side) {
        return side * side;
    }

    public static int getRectangleArea(int length, int width) {
        return length * width;
    }

    public static double getCircleArea(int radius) {
        return PI * radius * radius;
    }

    public static int getTrapezoidArea(int base1, int base2, int height) {
        return (base1 + base2) * height / 2;
    }

    public static void main(String[] args) {
        System.out.println("luas persegi: " + getSquareArea(12));
        System.out.println("luas persegi panjang: " + getRectangleArea(7, 8));
        System.out.println("luas lingkaran: " + getCircleArea(21));
        System.out.println("luas trapesium: " + getTrapezoidArea(5, 6, 2));
    }
}
