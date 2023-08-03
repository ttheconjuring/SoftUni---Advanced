package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Test;

public class ExcavationTest {

    // new Excavation(String, int) + .setName(String) + .setCapacity(int) + .getName() + .getCapacity() + .getCount()
    @Test
    public void constructorShouldSuccessfullyCreateAnObject() {
        Excavation excavationOne = new Excavation("idk", 0);
        Assert.assertNotNull(excavationOne);
        Assert.assertEquals("idk", excavationOne.getName());
        Assert.assertEquals(0, excavationOne.getCapacity());
        Assert.assertEquals(0, excavationOne.getCount());
        Excavation excavationTwo = new Excavation("wtf", 1);
        Assert.assertNotNull(excavationTwo);
        Assert.assertEquals("wtf", excavationTwo.getName());
        Assert.assertEquals(1, excavationTwo.getCapacity());
        Assert.assertEquals(0, excavationTwo.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void constructorShouldThrowAnExceptionWhenTheNameProvidedIsNull() {
        new Excavation(null, 5);
    }

    @Test(expected = NullPointerException.class)
    public void constructorShouldThrowAnExceptionWhenTheNameProvidedIsBlank() {
        new Excavation(" ", 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorShouldThrowAnExceptionWhenTheCapacityProvidedIsBelowZero() {
        new Excavation("idk", -1);
    }

    // .addArchaeologist(Archaeologist)

    @Test(expected = IllegalArgumentException.class)
    public void addArchaeologistShouldThrowAnExceptionWhenTheCapacityIsReached() {
        Excavation excavation = new Excavation("idk", 3);
        excavation.addArchaeologist(new Archaeologist("Ivan", 50));
        excavation.addArchaeologist(new Archaeologist("Petar", 40));
        excavation.addArchaeologist(new Archaeologist("Dimitar", 30));
        excavation.addArchaeologist(new Archaeologist("George", 20));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addArchaeologistShouldThrowAnExceptionWhenTheArchaeologistAlreadyExists() {
        Excavation excavation = new Excavation("idk", 3);
        Archaeologist archaeologist = new Archaeologist("Ivan", 35);
        excavation.addArchaeologist(archaeologist);
        excavation.addArchaeologist(archaeologist);
    }

    @Test
    public void addArchaeologistShouldSuccessfullyAddAnObjectToTheCollection() {
        Excavation excavation = new Excavation("idk", 3);
        Archaeologist archaeologist = new Archaeologist("Ivan", 35);
        excavation.addArchaeologist(archaeologist);
        Assert.assertEquals(1, excavation.getCount());
    }

    // .removeArchaeologist(String)
    @Test
    public void removeArchaeologistShouldSuccessfullyRemoveAnObject() {
        Excavation excavation = new Excavation("idk", 3);
        Archaeologist archaeologistOne = new Archaeologist("Ivan", 5);
        Archaeologist archaeologistTwo = new Archaeologist("George", 10);
        excavation.addArchaeologist(archaeologistOne);
        excavation.addArchaeologist(archaeologistTwo);
        Assert.assertTrue(excavation.removeArchaeologist(archaeologistOne.getName()));
        Assert.assertEquals(1, excavation.getCount());
        Assert.assertTrue(excavation.removeArchaeologist(archaeologistTwo.getName()));
        Assert.assertEquals(0, excavation.getCount());
    }

    @Test
    public void removeArchaeologistShouldNotThrowAnExceptionWhenTheNameProvidedIsNoFound() {
        Excavation excavation = new Excavation("idk", 3);
        Assert.assertFalse(excavation.removeArchaeologist("ivan"));
    }

}
