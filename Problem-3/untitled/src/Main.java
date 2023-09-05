

public class Main {
    public static int COUNTER = 1;

    public static void main(String[] args) {

        Pattern(2, true);
    }


    public static void Pattern(int num, boolean direction) {
        if (direction) {
            if (COUNTER == 10) {

                System.out.println(Math.round(Math.pow(num, COUNTER)));
                Pattern(num,false);
            } else {

                System.out.println(Math.round(Math.pow(num, COUNTER)));
                COUNTER++;
                Pattern(num, true);
            }

        } else {
            if (COUNTER == 1) {

                System.out.println(Math.round(Math.pow(num, COUNTER)));

            } else {

                System.out.println(Math.round(Math.pow(num, COUNTER)));
                COUNTER--;
                Pattern(num, false);
            }
        }
    }

}