import java.util.Objects;
public class LineEqualOrNot {

    static class Point {
        private final double x;
        private final double y;
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
        public double getX() {
            return x;
        }
        public double getY() {
            return y;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Point point = (Point) obj;
            return Double.compare(point.x, x) == 0 &&
                    Double.compare(point.y, y) == 0;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    static class Line {
        private final Point point1;
        private final Point point2;
        public Line(Point point1, Point point2) {
            this.point1 = point1;
            this.point2 = point2;
        }
        public  double calculateLength() {
            double x1 = point1.getX();
            double y1 = point1.getY();
            double x2 = point2.getX();
            double y2 = point2.getY();
            return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Line line = (Line) obj;
            return (point1.equals(line.point1) && point2.equals(line.point2)) ||
                    (point1.equals(line.point2) && point2.equals(line.point1));
        }
        @Override
        public int hashCode() {
            return Objects.hash(point1, point2);
        }
    }
    public static class Main {
        public  static void main(String[] args) {
            Point point1 = new Point(1, 2);
            Point point2 = new Point(4, 6);
            Line line1 = new Line(point1, point2);
            Line line2 = new Line(new Point(1, 2), new Point(4, 6));
            if (line1.equals(line2)) {
                System.out.println("The lines are equal.");
            } else {
                System.out.println("The lines are not equal.");
            }
        }
    }
}
