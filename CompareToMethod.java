class Point {
    private double x;
    private double y;

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

    public int compareTo(Point point2) {
        this.x = getX();
        this.y = getY();
        return 0;
    }
}

class Lines {
    private Point point1;
    private Point point2;
    public Lines(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }
    public double calculateLength() {
        double x1 = point1.getX();
        double y1 = point1.getY();
        double x2 = point2.getX();
        double y2 = point2.getY();
        double length = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return length;
    }
}
public class CompareToMethod {
    public static void main(String[] args) {
        Point point1 = new Point(1, 2);
        Point point2 = new Point(4, 6);
        Line1 line = new Line1(point1, point2);
        double length = line.calculateLength();
        System.out.println("Length of the line: " + length);
    }
}