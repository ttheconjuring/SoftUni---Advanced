package toyStore;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ToyStoreTest {

    // new ToyStore() + .getToyShelf()
    @Test
    public void constructorShouldSuccessfullyCreateAnObject() {
        Map<String, Toy> expectedMap = new LinkedHashMap<>();
        expectedMap.put("A", null);
        expectedMap.put("B", null);
        expectedMap.put("C", null);
        expectedMap.put("D", null);
        expectedMap.put("E", null);
        expectedMap.put("F", null);
        expectedMap.put("G", null);
        ToyStore toyStore = new ToyStore();
        Assert.assertEquals(expectedMap, toyStore.getToyShelf());
    }

    // .getToyShelf()
    @Test(expected = UnsupportedOperationException.class)
    public void getToyShelfShouldThrowAnExceptionWhenTheCollectionIsTriedToBeModified() {
        new ToyStore().getToyShelf().put("A", new Toy("Me", "45"));
    }

    // .addToy(String, Toy)
    @Test(expected = IllegalArgumentException.class)
    public void addToyShouldThrowAnExceptionWhenTheShelfProvidedDoesNotExist() throws OperationNotSupportedException {
        new ToyStore().addToy("H", new Toy("Me", "56"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addToyShouldThrowAnExceptionWhenWeTryToPutAToyOnAnAlreadyTakenShelf() throws OperationNotSupportedException {
        ToyStore toyStore = new ToyStore();
        toyStore.addToy("A", new Toy("Me", "54"));
        toyStore.addToy("A", new Toy("wtf", "32"));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addToyShouldThrowAnExceptionWhenAnAlreadyExistingToyIsTriedToBeAddedAgain() throws OperationNotSupportedException {
        ToyStore toyStore = new ToyStore();
        Toy toy = new Toy("Me", "41");
        toyStore.addToy("A", toy);
        toyStore.addToy("B", toy);
    }

    @Test
    public void addToyShouldSuccessfullyAddAnObjectToTheCollection() throws OperationNotSupportedException {
        ToyStore toyStore = new ToyStore();
        Toy toyOne = new Toy("Me", "13");
        Assert.assertEquals("Toy:13 placed successfully!", toyStore.addToy("A", toyOne));
        Assert.assertNotNull(toyStore.getToyShelf().get("A"));
        Toy toyTow = new Toy("ME", "14");
        Assert.assertEquals("Toy:14 placed successfully!", toyStore.addToy("B", toyTow));
        Assert.assertNotNull(toyStore.getToyShelf().get("B"));
    }

    // removeToy(String, Toy)
    @Test(expected = IllegalArgumentException.class)
    public void removeToyShouldThrowAnExceptionWhenTheShelfProvidedDoesNotExist() {
        new ToyStore().removeToy("H", new Toy("wtf", "13"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeToyShouldThrowAnExceptionWhenItIsCalledOnAShelfWithoutToy() {
        new ToyStore().removeToy("A", new Toy("wtf", "13"));
    }

    @Test
    public void removeToyShouldSuccessfullyRemoveAToyFromAShelf() throws OperationNotSupportedException {
        ToyStore toyStore = new ToyStore();
        Toy toy = new Toy("Me", "13");
        toyStore.addToy("A", toy);
        Assert.assertEquals("Remove toy:13 successfully!", toyStore.removeToy("A", toy));
        Assert.assertNull(toyStore.getToyShelf().get("A"));
    }
}

