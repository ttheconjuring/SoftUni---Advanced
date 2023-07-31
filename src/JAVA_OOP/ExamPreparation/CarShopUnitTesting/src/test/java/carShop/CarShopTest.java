package carShop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CarShopTest {

    private CarShop carShop;

    @Before
    public void setUp() {
        this.carShop = new CarShop();
    }

    // new CarShop()
    @Test
    public void constructorShouldSuccessfullyCreateAnObject() {
        Assert.assertNotEquals(null, new CarShop());
    }

    // .getCount()
    @Test
    public void getCountShouldReturnZeroWhenThListIsEmpty() {
        Assert.assertEquals(0, this.carShop.getCount());
    }

    // .add(Car)
    @Test(expected = NullPointerException.class)
    public void addShouldThrowAnExceptionWhenANullIsProvided() {
        this.carShop.add(null);
    }

    @Test
    public void addShouldSuccessfullyAddACarToTheList() {
        Car car1 = new Car("A3", 300, 2584);
        Car car2 = new Car("A4", 250, 2119);
        this.carShop.add(car1);
        this.carShop.add(car2);
        Assert.assertEquals(2, carShop.getCount());
        Assert.assertEquals(car1, this.carShop.getCars().get(0));
        Assert.assertEquals(car2, this.carShop.getCars().get(1));
    }

    // .remove()
    @Test
    public void removeShouldSuccessfullyRemoveAnExistingCar() {
        Car car1 = new Car("A3", 150, 2875);
        Car car2 = new Car("A4", 80, 1235);
        this.carShop.add(car1);
        this.carShop.add(car2);
        Assert.assertTrue(this.carShop.remove(car1));
        Assert.assertEquals(1, this.carShop.getCount());
    }

    // .getCars()
    @Test
    public void getCarsShouldReturnAnEmptyListWhenThereAreNoAnyObjectsAdded() {
        Assert.assertTrue(this.carShop.getCars().isEmpty());
    }

    @Test
    public void getCarsShouldReturnANonEmptyListWhenThereAreObjectsAdded() {
        List<Car> testList = new ArrayList<>();
        Car car1 = new Car("A3", 150, 2875);
        Car car2 = new Car("A4", 80, 1235);
        testList.add(car1);
        testList.add(car2);
        this.carShop.add(car1);
        this.carShop.add(car2);
        Assert.assertEquals(testList, this.carShop.getCars());
    }

    // .findAllCarsWithMaxHorsePower(int)
    @Test
    public void findAllCarsWithMaxHorsePowerShouldReturnAnEmptyListWhenTheHorsePowerProvidedIsTooHigh() {
        Car car1 = new Car("A3", 150, 2875);
        Car car2 = new Car("A4", 80, 1235);
        this.carShop.add(car1);
        this.carShop.add(car2);
        Assert.assertTrue(this.carShop.findAllCarsWithMaxHorsePower(200).isEmpty());
    }

    @Test
    public void findAllCarsWithMaxHorsePowerShouldReturnANonEmptyListWhenThereAreCarsWithMoreHorsePowerThanTheProvidedOnes() {
        Car car1 = new Car("A3", 150, 2875);
        Car car2 = new Car("A4", 80, 1235);
        this.carShop.add(car1);
        this.carShop.add(car2);
        Assert.assertEquals(2, this.carShop.findAllCarsWithMaxHorsePower(70).size());
    }

    // .getTheMostLuxuryCar()
    @Test
    public void getTheMostLuxuryCarShouldReturnNullWhenTheListIsEmpty() {
        Assert.assertNull(this.carShop.getTheMostLuxuryCar());
    }

    @Test
    public void getTheMostLuxuryCarShouldReturnAnObjectWhenTheListIsNotEmpty() {
        Car car1 = new Car("A3", 150, 2875);
        Car car2 = new Car("A4", 80, 1235);
        this.carShop.add(car1);
        this.carShop.add(car2);
        Car theMostLuxuryCar = this.carShop.getTheMostLuxuryCar();
        Assert.assertNotNull(theMostLuxuryCar);
        Assert.assertEquals(car1, theMostLuxuryCar);
    }

    // .findAllCarByModel(String)
    @Test
    public void findAllCarByModelShouldReturnAnEmptyListWhenThereAreNotAnyCarsAddedOrTheModelProvidedIsMissingAmongTheExistingCars() {
        Assert.assertTrue(this.carShop.findAllCarByModel("A3").isEmpty());
    }

    @Test
    public void findAllCarByModelShouldReturnANonEmptyListWhenThereAreCarsWithTheModelProvided() {
        Car car1 = new Car("A3", 150, 2875);
        Car car2 = new Car("A4", 80, 1235);
        this.carShop.add(car1);
        this.carShop.add(car2);
        List<Car> a3 = this.carShop.findAllCarByModel("A3");
        Assert.assertFalse(a3.isEmpty());
        Assert.assertEquals(car1.getModel(), a3.get(0).getModel());
    }

}
