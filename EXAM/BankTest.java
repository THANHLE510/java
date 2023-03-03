package EXAM;

public class BankTest {
    public static void main(String[] args) {
        Bank bank = new Bank(1000,10);
        double Interest = bank.calculateInterest();
        System.out.println("The interest for balance of $1000 and a rate of 10% is:$" + Interest);
    }
}
