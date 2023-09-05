import java.util.ArrayList;

public class Bank {

    private ArrayList<Account> accounts;

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public Bank() {
        this.accounts = new ArrayList<Account>();
    }

    public void addAccount(long id,
                           long accountNumber,
                           Customer customer,
                           Account.AccountTypes accountType){
        Account account = new Account(id,accountNumber,customer,accountType);
        accounts.add(account);
        customer.addAccount(account);
    }

    public void removeAccount(long accountNumber){
        accounts.removeIf(account -> account.getAccountNumber() == accountNumber);
    }

    public void deposit(long accountNumber, double credit){
        for(Account account:accounts){
            if (account.getAccountNumber() == accountNumber){
                account.setCredit(credit);
            }
        }
    }

    public void withdraw(long accountNumber, double credit){
        for(Account account:accounts){
            if (account.getAccountNumber() == accountNumber){
                account.withdraw(credit);
            }
        }
    }

    public double getCredit(long accountNumber){
        for(Account account:accounts){
            if (account.getAccountNumber() == accountNumber){
                return account.getCredit();
            }
        }
            throw new RuntimeException();

    }
}
