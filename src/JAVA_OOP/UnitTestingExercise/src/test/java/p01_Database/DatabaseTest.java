package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private static final Integer[] DEFAULT_ARRAY = {3, 4, 5, 8, 9, 10};
    private Database database;

    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        this.database = new Database(DEFAULT_ARRAY);
    }

    @Test
    public void testConstructorHasCreatedCorrectObject() throws OperationNotSupportedException {
        Integer[] databaseElements = this.database.getElements();
        Assert.assertArrayEquals("Arrays are not identical!", DEFAULT_ARRAY, databaseElements);
        Assert.assertEquals("The lengths of the arrays are different!", DEFAULT_ARRAY.length, databaseElements.length);
        Assert.assertEquals(DEFAULT_ARRAY.length - 1, this.database.getIndex());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowAnExceptionWhenItIsProvidedWithMoreThanSixteenElements() throws OperationNotSupportedException {
        new Database(new Integer[17]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowAnExceptionWhenItIsProvidedWithLessThanOneElement() throws OperationNotSupportedException {
        new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowAnExceptionWhenIsCalledWithNullAsArgument() throws OperationNotSupportedException {
        this.database.add(null);
    }

    @Test
    public void testAddShouldCorrectlyAddOneInteger() throws OperationNotSupportedException {
        Integer[] databaseBefore = this.database.getElements();
        this.database.add(5);
        Integer[] databaseAfter = this.database.getElements();
        Assert.assertEquals(databaseBefore.length + 1, databaseAfter.length);
        Assert.assertEquals(Integer.valueOf(5), databaseAfter[databaseAfter.length - 1]);
    }

    @Test
    public void testRemoveShouldSuccessfullyRemoveAnElement() throws OperationNotSupportedException {
        Integer[] databaseBefore = this.database.getElements();
        database.remove();
        Integer[] databaseAfter = this.database.getElements();
        Assert.assertEquals(databaseBefore.length - 1, databaseAfter.length);
        Assert.assertEquals(databaseAfter[databaseAfter.length - 1], Integer.valueOf(9));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowAnExceptionWhenDatabaseIsEmpty() throws OperationNotSupportedException {
        while (this.database.getElements().length != 0) {
            this.database.remove();
        }
        database.remove();
    }

}
