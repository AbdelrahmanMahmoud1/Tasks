import java.util.ArrayList;
import java.util.Date;

public class Customer {

    private long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String SSN;
    private Date birthdate;
    private String email;
    private ArrayList<Account> accounts;


    public void addAccount(Account account){
        this.accounts.add(account);
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public Customer(long id,String firstName, String lastName, String phoneNumber, String SSN, Date birthdate, String email, ArrayList<Account> accounts) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.SSN = SSN;
        this.birthdate = birthdate;
        this.email = email;
        this.accounts = accounts;
    }

    public Customer(long id,String firstName, String lastName, String phoneNumber, String SSN, Date birthdate, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.SSN = SSN;
        this.birthdate = birthdate;
        this.email = email;
        this.accounts = new ArrayList<Account>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", SSN='" + SSN + '\'' +
                ", birthdate=" + birthdate +
                ", email='" + email + '\'' +
                '}';
    }
}
