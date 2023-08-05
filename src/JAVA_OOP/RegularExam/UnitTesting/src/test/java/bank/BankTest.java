package bank;

import org.junit.Assert;
import org.junit.Test;

public class BankTest {


    // new Bank(String, int) + .setCapacity(int) + .setName(String) + .getCapacity() + .getName() + .getCount()
    @Test
    public void constructorShouldSuccessfullyCreateAnObject() {
        Bank bank = new Bank("DSK", 5);
        Assert.assertNotNull(bank);
        Assert.assertEquals("DSK", bank.getName());
        Assert.assertEquals(5, bank.getCapacity());
        Assert.assertEquals(0, bank.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void constructorShouldThrowAnExceptionWhenTheNameProvidedIsNull() {
        new Bank(null, 5);
    }

    @Test(expected = NullPointerException.class)
    public void constructorShouldThrowAnExceptionWhenTheNameProvidedIsBlank() {
        new Bank(" ", 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorShouldThrowAnExceptionWhenTheCapacityProvidedIsBelowZero() {
        new Bank("DSK", -1);
    }

    // .addClient(Client)
    @Test
    public void addClientShouldSuccessfullyAddAnObjectToTheCollection() {
        Bank bank = new Bank("DSK", 5);
        Client client = new Client("Pesho");
        bank.addClient(client);
        Assert.assertEquals(1, bank.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addClientShouldThrowAnExceptionWhenTheCapacityIsReached() {
        Bank bank = new Bank("DSK", 3);
        Client client = new Client("Pesho");
        bank.addClient(client);
        bank.addClient(client);
        bank.addClient(client);
        bank.addClient(client);
    }

    // .removeClient(String)
    @Test
    public void removeClientShouldSuccessfullyRemoveAnObjectFromTheCollection() {
        Bank bank = new Bank("DSK", 3);
        Client clientOne = new Client("Pesho");
        Client clientTwo = new Client("Ivan");
        bank.addClient(clientOne);
        bank.addClient(clientTwo);
        bank.removeClient(clientTwo.getName());
        Assert.assertEquals(1, bank.getCount());
        bank.removeClient(clientOne.getName());
        Assert.assertEquals(0, bank.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeClientShouldThrowAnExceptionWhenTheNameProvidedDoesNotExist() {
        new Bank("DSK", 5).removeClient("Ivan");
    }

    // .loanWithdrawal(String)
    @Test
    public void loanWithdrawalShouldSuccessfullyWorkWhenCalledWithExistingName() {
        Bank bank = new Bank("DKS", 5);
        Client clientOne = new Client("Pesho");
        bank.addClient(clientOne);
        Assert.assertEquals(1, bank.getCount());
        Client loanWithdrawalClient = bank.loanWithdrawal(clientOne.getName());
        Assert.assertNotNull(loanWithdrawalClient);
        Assert.assertFalse(clientOne.isApprovedForLoan());
    }

    @Test(expected = IllegalArgumentException.class)
    public void loanWithdrawalShouldThrowAnExceptionWhenTheNameProvidedDoesNotExist() {
        new Bank("DSK", 5).loanWithdrawal("Pesho");
    }

    // .statistics()
    @Test
    public void statisticsShouldWorkSuccessfullyWhenTheCollectionIsNotEmpty() {
        Bank bank = new Bank("DSK", 3);
        Client clientOne = new Client("Pesho");
        Client clientTwo = new Client("Ivan");
        bank.addClient(clientOne);
        bank.addClient(clientTwo);
        Assert.assertEquals("The client Pesho, Ivan is at the DSK bank!", bank.statistics());
    }

    @Test
    public void statisticsShouldWorkSuccessfullyWhenTheCollectionIsEmpty() {
        Assert.assertEquals("The client  is at the DSK bank!", new Bank("DSK", 5).statistics());
    }

}
