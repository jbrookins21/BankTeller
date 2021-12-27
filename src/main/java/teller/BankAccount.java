package teller;

public class BankAccount {
    private String accountNumber;
    private String type;
    private int balance;

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getType(){
        return type;
    }

    public int getBalance() {
        return balance;
    }

    public void withdrawal(int amountToWithdraw) {
        balance -=amountToWithdraw;
    }

    public void deposit(int amountToDeposit) {
        balance +=amountToDeposit;
    }

    public BankAccount(String accountNumber, String type, int balance) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.balance = balance;
    }

}
