package teller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BankTest {

    Bank underTest;
    BankAccount account1;
    BankAccount account2;

    @BeforeEach
    public void setUp(){
    underTest = new Bank();
    account1 = new BankAccount("1", "Checking", 100);
    account2 = new BankAccount("2", "Savings", 100);
    }

    @Test
    public void shouldBeAbleToAddAccount(){
        underTest.add(account1);
        BankAccount retrievedAccount = underTest.findAccount("1");
        assertEquals(retrievedAccount, account1);
    }

    @Test
    public  void shouldBeAbleToAddTwoAccounts(){
        underTest.add(account1);
        underTest.add(account2);
        Collection<BankAccount> allAccounts = underTest.getAllAccounts();
       // assertEquals(2, allAccounts.size());
        assertThat(allAccounts, containsInAnyOrder(account1,account2));
    }

    @Test
    public void shouldBeAbleToRemoveAnAccount(){
        underTest.add(account1);
        underTest.close(account1);
        BankAccount retrievedAccount = underTest.findAccount("1");
        assertNull(retrievedAccount);
    }

    @Test
    public void shouldWithdrawFromAccount(){
        underTest.add(account1);
        underTest.withdrawal(account1.getAccountNumber(), 50);
        assertEquals(account1.getBalance(), 50);
    }

    @Test
    public void shouldDepositToAccount(){
        underTest.add(account2);
        underTest.deposit(account2.getAccountNumber(),50);
        assertEquals(account2.getBalance(), 150);
    }


}
