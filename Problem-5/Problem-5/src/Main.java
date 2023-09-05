import java.text.DateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();

        Customer customer1 = new Customer(1,
                "Abdelrahman",
                "Mahmoud",
                "01020801002",
                "30002090900345",
                 new Date(),
                "abdo@gmail.com");

        bank.addAccount(1,123441,customer1,Account.AccountTypes.SAVING);
        bank.getCredit(123441);
        bank.deposit(123441,20000);
        bank.getCredit(123441);
        bank.withdraw(123441,5000);
        bank.getCredit(123441);

        for(Account account: customer1.getAccounts()){
            System.out.println(account);
        }




    }



}