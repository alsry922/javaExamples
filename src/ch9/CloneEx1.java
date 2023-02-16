package ch9;

public class CloneEx1 {
    public static void main(String[] args) {
        Point original = new Point(3, 5);
        Point clone = original.clone();
        System.out.println(original);
        System.out.println(clone);
    }
    static class Point implements Cloneable {

        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point() {
            this(0,0);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public Point clone() {
            Object obj = null;
            try {
                obj = super.clone();
            } catch (CloneNotSupportedException e) {
            }
            return (Point) obj;
        }
    }

}
