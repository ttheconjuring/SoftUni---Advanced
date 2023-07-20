package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private static final Person[] DEFAULT_ARRAY = {new Person(1, "Pesho"),
            new Person(2, "Adi"),
            new Person(3, "Vesi")};

    private Database database;

    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        this.database = new Database(DEFAULT_ARRAY);
    }

    @Test
    public void testConstructorHasCreatedCorrectObject() throws OperationNotSupportedException {
        Person[] databaseElements = this.database.getElements();
        Assert.assertArrayEquals("Arrays are not identical!", DEFAULT_ARRAY, databaseElements);
        Assert.assertEquals("The lengths of the arrays are different!", DEFAULT_ARRAY.length, databaseElements.length);
        Assert.assertEquals(DEFAULT_ARRAY.length - 1, this.database.getIndex());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowAnExceptionWhenItIsProvidedWithMoreThanSixteenElements() throws OperationNotSupportedException {
        new Database(new Person[17]);
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
    public void testAddShouldCorrectlyAddOnePerson() throws OperationNotSupportedException {
        Person[] databaseBefore = this.database.getElements();
        this.database.add(new Person(4, "Andrei"));
        Person[] databaseAfter = this.database.getElements();
        Assert.assertEquals(databaseBefore.length + 1, databaseAfter.length);
        Assert.assertEquals(4, databaseAfter[databaseAfter.length - 1].getId());
        Assert.assertEquals("Andrei", databaseAfter[databaseAfter.length - 1].getUsername());
    }

    @Test
    public void testRemoveShouldSuccessfullyRemoveAnElement() throws OperationNotSupportedException {
        Person[] databaseBefore = this.database.getElements();
        database.remove();
        Person[] databaseAfter = this.database.getElements();
        Assert.assertEquals(databaseBefore.length - 1, databaseAfter.length);
        Assert.assertEquals(2, databaseAfter[databaseAfter.length - 1].getId());
        Assert.assertEquals("Adi", databaseAfter[databaseAfter.length - 1].getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowAnExceptionWhenDatabaseIsEmpty() throws OperationNotSupportedException {
        while (this.database.getElements().length != 0) {
            this.database.remove();
        }
        database.remove();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameShouldThrowAnExceptionWhenItIsCalledWithNullAsArgument() throws OperationNotSupportedException {
        this.database.findByUsername(null);
    }

    @Test
    public void testFindByUsernameShouldWorkCorrectlyInTypicalCircumstancesWithFoundOnlyOneObject() throws OperationNotSupportedException {
        Person person = this.database.findByUsername("Pesho");
        Assert.assertEquals("Invalid id filed!", 1, person.getId());
        Assert.assertEquals("Invalid name field!", "Pesho", person.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameShouldThrowAnExceptionWhenThereAreMoreThanOneObjectWithCommonUsername() throws OperationNotSupportedException {
        this.database.add(new Person(4, "Adi"));
        this.database.findByUsername("Adi");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameShouldThrowAnExceptionWhenCalledWithANonExistingUsername() throws OperationNotSupportedException {
        this.database.findByUsername("Ivan");
    }

    @Test
    public void testFindByIdShouldWorkCorrectlyInTypicalCircumstancesWithFoundOnlyOneObject() throws OperationNotSupportedException {
        Person person = this.database.findById(1);
        Assert.assertEquals("Invalid id filed!", 1, person.getId());
        Assert.assertEquals("Invalid name field!", "Pesho", person.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdShouldThrowAnExceptionWhenThereAreMoreThanOneObjectWithCommonId() throws OperationNotSupportedException {
        this.database.add(new Person(3, "Adi"));
        this.database.findById(4);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIDShouldThrowAnExceptionWhenCalledWithANonExistingId() throws OperationNotSupportedException {
        this.database.findById(6);
    }


}
