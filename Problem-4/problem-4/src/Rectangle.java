public class Rectangle implements Comparable<Rectangle> {

    private double length;
    private double width;
    private double area;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
        this.area = length * width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public int compareTo(Rectangle o) {
        return Double.compare(this.area, o.area);
    }
}
