
public class Account {

    private long id;
    private long accountNumber;
    private Customer customer;
    public enum AccountTypes{
        SAVING,
        CHEQUE,
        CERTIFICATE_OF_DEPOSIT,
        INTEREST
    };
    private AccountTypes accountType;
    private double credit;

    public Account(long id, long accountNumber, Customer customer, AccountTypes accountType) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.accountType = accountType;
        this.credit = 0.0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public AccountTypes getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountTypes accountType) {
        this.accountType = accountType;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = this.credit + credit;
        System.out.println("You deposited: "+ credit+" Your Credit amount is: "+ this.credit);
    }
    public void withdraw(double credit){
        if (this.credit> credit){
            this.credit = this.credit -credit;
            System.out.println("You withdrew: "+credit+" Your Credit amount is: "+ this.credit );
        }else{
            System.out.println("Operation cancelled ..  Insufficient credit \n" +
                    "Your credit amount is: "+ this.credit);
        }

    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNumber=" + accountNumber +
                ", customer=" + customer +
                ", accountType=" + accountType +
                ", credit=" + credit +
                '}';
    }
}
