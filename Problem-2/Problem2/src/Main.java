
public class Main {
    public static void main(String[] args) {

      boolean result =  game(52);
        System.out.println(result);
        if (result) {
            System.out.println("You have reached the goal!");
        } else {
            System.out.println("You Lost");
        }
    }


    public static boolean game(int number){

        if (number < 42) {
            return false;
        }else if (number == 42){
            return true;
        }else if (number % 5 == 0 && game(number - 42) ) {
            return true;

        }  else if (number % 2 == 0 && game(number/2)){
            return true ;
        }

        else if (number % 4 == 0 && game(number - number % 10 * (number%100)/10)) {

         return true;

        }
      else {
            return false;
        }


    }
}