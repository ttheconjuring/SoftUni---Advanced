package robots;

import org.junit.Assert;
import org.junit.Test;

public class ServiceTests {

    // new Service() + .setName(String) + .getName() + .setCapacity(int) + .getCapacity()
    @Test
    public void serviceConstructorShouldCreateAnObject() {
        Service service = new Service("new service", 10);
        Assert.assertEquals("new service", service.getName());
        Assert.assertEquals(10, service.getCapacity());
    }

    // .setName(String)
    @Test(expected = NullPointerException.class)
    public void setNameShouldThrowAnExceptionWhenAnEmptyStringIsProvided() {
        new Service(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void setNameShouldThrowAnExceptionWhenABlankStringIsProvided() {
        new Service("   ", 10);
    }

    // .setCapacity(int)
    @Test(expected = IllegalArgumentException.class)
    public void setCapacityShouldThrowAnExceptionWhenAnIntegerBelowZeroIsProvided() {
        new Service("new service", -1);
    }

    // .getCount()
    @Test
    public void getCountShouldReturnZeroWhenTheServiceCollectionIsEmpty() {
        Service service = new Service("new service", 1);
        Assert.assertEquals(0, service.getCount());
    }

    @Test
    public void getCountShouldReturnANumberGreaterThanZeroWhenTheServiceCollectionIsNotEmpty() {
        Service service = new Service("new service", 4);
        service.add(new Robot("RobotOne"));
        service.add(new Robot("RobotTwo"));
        service.add(new Robot("RobotThree"));
        service.add(new Robot("RobotFour"));
        Assert.assertEquals(4, service.getCount());
    }

    // .add(Robot)
    @Test
    public void addRobotShouldSuccessfullyAddARobotToTheServiceCollection() {
        Service service = new Service("new service", 5);
        service.add(new Robot("robotOne"));
        Assert.assertEquals(1, service.getCount());
        Assert.assertNotEquals(null, service.forSale("robotOne"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addRobotShouldThrowAnExceptionWhenTheCapacityIsReach() {
        Service service = new Service("new service", 2);
        service.add(new Robot("RobotOne"));
        service.add(new Robot("RobotTwo"));
        service.add(new Robot("RobotThree"));
    }

    // .remove(String)
    @Test
    public void removeShouldSuccessfullyRemoveARobotFromTheCollection() {
        Service service = new Service("new service", 3);
        service.add(new Robot("RobotOne"));
        service.add(new Robot("RobotTwo"));
        service.add(new Robot("RobotThree"));
        service.remove("RobotOne");
        service.remove("RobotThree");
        Assert.assertEquals(1, service.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeShouldThrowAnExceptionWhenARobotWithTheProvidedNameDoesNotExist() {
        Service service = new Service("new service", 3);
        service.add(new Robot("RobotOne"));
        service.remove("RobotTwo");
    }

    // .forSale(String)
    @Test
    public void forSaleShouldWorkSuccessfully() {
        Service service = new Service("new service", 4);
        service.add(new Robot("RobotOne"));
        Robot robot = service.forSale("RobotOne");
        Assert.assertNotEquals(null, robot);
        Assert.assertFalse(robot.isReadyForSale());
    }

    @Test(expected = IllegalArgumentException.class)
    public void forSaleShouldThrowAnExceptionWhenARobotWithTheNameProvidedDoesNotExist() {
        Service service = new Service("new service", 5);
        service.add(new Robot("RobotOne"));
        service.forSale("RobotTwo");
    }

    // .report()
    @Test
    public void reportShouldSuccessfullyWorkWithAnEmptyCollection() {
        Service service = new Service("new service", 2);
        Assert.assertEquals("The robot  is in the service new service!", service.report());
    }

    @Test
    public void reportShouldSuccessfullyWorkWithANonEmptyCollection() {
        Service service = new Service("new service", 2);
        service.add(new Robot("RobotOne"));
        service.add(new Robot("RobotTwo"));
        Assert.assertEquals("The robot RobotOne, RobotTwo is in the service new service!", service.report());
    }


}
