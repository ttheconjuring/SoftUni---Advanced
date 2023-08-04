package football;

import org.junit.Assert;
import org.junit.Test;

public class FootballTeamTest {

    // new FootballTeam(String, int) + .setName(StringO + .setVacantPositions(int) + .getName() + .getVacantPositions() + .getCount()

    @Test
    public void constructorShouldSuccessfullyCreateAnObject() {
        FootballTeam footballTeam = new FootballTeam("PeshoSofia", 6);
        Assert.assertNotNull(footballTeam);
        Assert.assertEquals("PeshoSofia", footballTeam.getName());
        Assert.assertEquals(6, footballTeam.getVacantPositions());
        Assert.assertEquals(0, footballTeam.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void constructorShouldThrowAnExceptionWhenTheStringProvidedIsNull() {
        new FootballTeam(null, 5);
    }

    @Test(expected = NullPointerException.class)
    public void constructorShouldThrowAnExceptionWhenTheStringProvidedIsBlank() {
        new FootballTeam(" ", 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorShouldThrowAnExceptionWhenTheIntProvidedIsBelowZero() {
        new FootballTeam("PeshoSofia", -1);
    }

    // .addFootballer(Footballer)
    @Test
    public void addFootballerShouldSuccessfullyAddAnObjectToTheCollection() {
        FootballTeam footballTeam = new FootballTeam("PeshoSofia", 6);
        Footballer footballer = new Footballer("Pesho");
        footballTeam.addFootballer(footballer);
        Assert.assertEquals(1, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addFootballerShouldThrowAnExceptionWhenTheVacantPositionsAreReached() {
        FootballTeam footballTeam = new FootballTeam("PeshoSofia", 3);
        Footballer footballer = new Footballer("Pesho");
        footballTeam.addFootballer(footballer);
        footballTeam.addFootballer(footballer);
        footballTeam.addFootballer(footballer);
        footballTeam.addFootballer(footballer);
    }

    // .removeFootballer(String)
    @Test
    public void removeFootballerShouldSuccessfullyReturnAnExistingFootballer() {
        FootballTeam footballTeam = new FootballTeam("PeshoSofia", 6);
        Footballer footballer = new Footballer("Pesho");
        footballTeam.addFootballer(footballer);
        footballTeam.removeFootballer(footballer.getName());
        Assert.assertEquals(0, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeFootballerShouldThrowAnExceptionWhenTheFootballerNameProvidedDoesNotExist() {
        FootballTeam footballTeam = new FootballTeam("PeshoSofia", 6);
        Footballer footballer = new Footballer("Pesho");
        footballTeam.addFootballer(footballer);
        footballTeam.removeFootballer("Ivan");
    }

    // .footballerForSale(String)
    @Test
    public void footballerForSaleShouldSuccessfullyFindAndSellAFootballer() {
        FootballTeam footballTeam = new FootballTeam("PeshoSofia", 6);
        Footballer footballer = new Footballer("Pesho");
        footballTeam.addFootballer(footballer);
        Assert.assertTrue(footballer.isActive());
        Footballer forSale = footballTeam.footballerForSale(footballer.getName());
        Assert.assertNotNull(forSale);
        Assert.assertEquals("Pesho", forSale.getName());
        Assert.assertFalse(forSale.isActive());
    }

    @Test(expected = IllegalArgumentException.class)
    public void footballerForSaleShouldThrowAnExceptionWhenTheFootballerNameProvidedIsNotFound() {
        FootballTeam footballTeam = new FootballTeam("PeshoSofia", 6);
        Footballer footballer = new Footballer("Pesho");
        footballTeam.addFootballer(footballer);
        footballTeam.footballerForSale("Ivan");
    }

    // .getStatistics()
    @Test
    public void getStatisticsShouldSuccessfullyReturnACorrectStatistics() {
        FootballTeam footballTeam = new FootballTeam("PeshoSofia", 6);
        Footballer footballerOne = new Footballer("Pesho");
        Footballer footballerTwo = new Footballer("Ivan");
        footballTeam.addFootballer(footballerOne);
        footballTeam.addFootballer(footballerTwo);
        Assert.assertEquals("The footballer Pesho, Ivan is in the team PeshoSofia.", footballTeam.getStatistics());
    }


}
