

public class Main {
    public static void main(String[] args) {

        Rectangle rectangle1 = new Rectangle(10,15);
        Rectangle rectangle2 = new Rectangle(10,17);

        int result = rectangle1.compareTo(rectangle2);
        System.out.println(result);
    }
}