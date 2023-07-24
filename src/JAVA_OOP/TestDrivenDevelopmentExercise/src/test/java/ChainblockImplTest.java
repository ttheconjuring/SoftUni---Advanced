import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChainblockImplTest {

    private ChainblockImpl database;

    private List<Transaction> transactions;

    @Before
    public void initializer() {
        this.database = new ChainblockImpl();
        this.transactions = new ArrayList<>();
    }

    private void createTransactions() {
        Transaction transaction1 = new TransactionImpl(0, TransactionStatus.FAILED, "Ivan", "Petar", 452.1);
        Transaction transaction2 = new TransactionImpl(1, TransactionStatus.ABORTED, "Misho", "Maria", 12.5);
        Transaction transaction3 = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Radi", "Irena", 952.2);
        Transaction transaction4 = new TransactionImpl(3, TransactionStatus.UNAUTHORIZED, "Atanas", "Borislava", 42.76);
        Transaction transaction5 = new TransactionImpl(4, TransactionStatus.FAILED, "Ioan", "Iovka", 4452.50);
        this.transactions = Arrays.asList(transaction1, transaction2, transaction3, transaction4, transaction5);
    }

    private void fillDatabase() {
        this.transactions.forEach(transaction -> this.database.add(transaction));
    }

    // -----> .getCount() <-----

    @Test
    public void testGetCountShouldReturnMoreThenZeroWhenThereAreExistingTransactions() {
        createTransactions();
        fillDatabase();
        Assert.assertEquals(5, this.database.getCount());
    }

    @Test
    public void testGetCountShouldReturnZeroWhenThereAreNotAnyAddedTransactions() {
        Assert.assertEquals(0, this.database.getCount());
    }

    // -----> .contains(Transaction) + .add() <-----

    @Test
    public void testContainsTransactionShouldReturnTrueWhenANonExistingTransactionIsProvided() {
        createTransactions();
        Transaction existingTransaction = this.transactions.get(0);
        this.database.add(existingTransaction);
        Assert.assertTrue(this.database.contains(existingTransaction));
    }

    @Test
    public void testContainsTransactionShouldReturnFalseWhenAnExistingTransactionIsProvided() {
        createTransactions();
        // In this case the database is empty
        Assert.assertFalse(this.database.contains(this.transactions.get(0)));
        Transaction transaction = this.transactions.get(0);
        this.database.add(transaction);
        // In this case there is already 1 element
        Assert.assertFalse(this.database.contains(this.transactions.get(1)));
    }

    @Test
    public void testAddShouldAddWhenANonExistingTransactionIsProvided() {
        createTransactions();
        Transaction transaction = this.transactions.get(0);
        this.database.add(transaction);
        Assert.assertTrue(this.database.contains(transaction));
    }

    @Test
    public void testAddShouldNotAddWhenAnAlreadyExistingTransactionIsProvided() {
        createTransactions();
        Transaction transaction = this.transactions.get(0);
        this.database.add(transaction);
        this.database.add(transaction);
        Assert.assertEquals(1, this.database.getCount());
    }

    // -----> .contains(id) <-----

    @Test
    public void testContainsIdShouldReturnTrueWhenANonExistingTransactionIsProvided() {
        createTransactions();
        Transaction existingTransaction = this.transactions.get(0);
        this.database.add(existingTransaction);
        Assert.assertTrue(this.database.contains(existingTransaction.getId()));
    }

    @Test
    public void testContainsIdShouldReturnFalseWhenAnnExistingTransactionIsProvided() {
        createTransactions();
        // In this case the database is empty
        Assert.assertFalse(this.database.contains(this.transactions.get(0).getId()));
        Transaction transaction = this.transactions.get(0);
        this.database.add(transaction);
        // In this case there is already 1 element
        Assert.assertFalse(this.database.contains(this.transactions.get(1).getId()));
    }

    // -----> .getById() <-----

    @Test
    public void testGetByIdShouldReturnTransactionWhenAnExistingTransactionIdIsProvided() {
        createTransactions();
        fillDatabase();
        Assert.assertEquals(4, this.database.getById(4).getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByIdShouldThrowAnExceptionWhenANonExistingTransactionIdIsProvided() {
        this.database.getById(5);
    }

    // -----> .changeTransactionStatus() <-----

    @Test
    public void testChangeTransactionStatusShouldWorkSuccessfullyWhenAnExistingTransactionIdIsProvided() {
        createTransactions();
        fillDatabase();
        this.database.changeTransactionStatus(3, TransactionStatus.UNAUTHORIZED);
        Assert.assertEquals(TransactionStatus.UNAUTHORIZED, this.database.getById(3).getTransactionStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeTransactionStatusShouldThrowAnExceptionWhenANonExistingTransactionIdIsProvided() {
        this.database.changeTransactionStatus(6, TransactionStatus.SUCCESSFUL);
    }

    // -----> .removeTransactionById() <-----

    @Test
    public void testRemoveTransactionByIdShouldSuccessfullyRemoveATransactionWhenAnExistingTransactionIdIsProvided() {
        createTransactions();
        fillDatabase();
        this.database.removeTransactionById(2);
        Assert.assertEquals(4, this.database.getCount());
        Assert.assertFalse(this.database.contains(2));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTransactionByIdShouldThrowAnExceptionWhenANonExistingTransactionIdIsProvided() {
        this.database.removeTransactionById(5);
    }

    // -----> .getByTransactionStatus() <-----

    @Test
    public void testGetByTransactionStatusShouldReturnANonEmptyListOfTransactionsWhenThereAreExistingTransactionsWithTheTransactionStatusProvided() {
        createTransactions();
        fillDatabase();
        Iterable<Transaction> transactionFound = this.database.getByTransactionStatus(TransactionStatus.FAILED);
        Assert.assertTrue(transactionFound.iterator().hasNext());
        transactionFound.forEach(transaction -> Assert.assertEquals(TransactionStatus.FAILED, transaction.getTransactionStatus()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactionStatusShouldThrowAnExceptionWhenThereAreNoFoundTransactionsWithTheTransactionStatusProvided() {
        createTransactions();
        fillDatabase();
        this.database.removeTransactionById(1);
        this.database.getByTransactionStatus(TransactionStatus.ABORTED);
    }


}
