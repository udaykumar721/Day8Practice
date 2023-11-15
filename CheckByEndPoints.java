import java.lang.Math;
import java.util.Objects;
class Point1 implements Comparable<Point> {
    private double x;
    private double y;
    public Point1(double x, double y) {
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
        return Double.compare(point.getX(), x) == 0 &&
                Double.compare(point.getY(), y) == 0;
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
    @Override
    public int compareTo(Point otherPoint) {
        if (this.equals(otherPoint)) {
            return 0;
        } else if (this.x < otherPoint.getX() || (this.x == otherPoint.getX() && this.y < otherPoint.getY())) {
            return -1;
        } else {
            return 1;
        }
    }
}
class Line1 extends CheckByEndPoints<Line1> {
    private Point point1;
    private Point point2;

    public Line1(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }
    public double calculateLength() {
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
        Line1 line = (Line1) obj;
        return (point1.equals(line.point1) && point2.equals(line.point2)) ||
                (point1.equals(line.point2) && point2.equals(line.point1));
    }
    @Override
    public int hashCode() {
        return Objects.hash(point1, point2);
    }
    @Override
    public int compareTo(Line1 otherLine) {
        double lengthDifference = this.calculateLength() - otherLine.calculateLength();
        if (lengthDifference < 0) {
            return -1;
        } else if (lengthDifference > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
public abstract class CheckByEndPoints<line> {
    public static void main(String[] args) {
        Point point1 = new Point(1, 2);
        Point point2 = new Point(4, 6);
        Line1 line1 = new Line1(point1, point2);
        Line1 line2 = new Line1(new Point(1, 2), new Point(5, 8));
        Line1 line3 = new Line1(new Point(1, 2), new Point(3, 4));
        int comparisonResult1 = line1.compareTo(line2);
        int comparisonResult2 = line1.compareTo(line3);
        if (comparisonResult1 < 0) {
            System.out.println("line1 is shorter than line2.");
        } else if (comparisonResult1 > 0) {
            System.out.println("line1 is longer than line2.");
        } else {
            System.out.println("line1 is equal to line2.");
        }
        if (comparisonResult2 < 0) {
            System.out.println("line1 is shorter than line3.");
        } else if (comparisonResult2 > 0) {
            System.out.println("line1 is longer than line3.");
        } else {
            System.out.println("line1 is equal to line3.");
        }
    }
    public abstract int compareTo(Line1 otherLine);
}
