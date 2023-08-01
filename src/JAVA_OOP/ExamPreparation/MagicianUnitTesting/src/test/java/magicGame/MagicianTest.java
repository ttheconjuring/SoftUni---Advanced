package magicGame;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class MagicianTest {

    // new Magician(String, int) + .getUsername() + .getHealth() + .getMagics()
    @Test
    public void constructorShouldSuccessfullyCreateAnObject() {
        Magician magician = new Magician("PJ", 50);
        Assert.assertEquals("PJ", magician.getUsername());
        Assert.assertEquals(50, magician.getHealth());
        Assert.assertEquals(new ArrayList<>(), magician.getMagics());
    }

    // .setUsername(String)
    @Test(expected = NullPointerException.class)
    public void setUsernameShouldThrowAnExceptionWhenANullIsProvided() {
        new Magician(null, 50);
    }

    @Test(expected = NullPointerException.class)
    public void setUsernameShouldThrowAnExceptionWhenABlankStringIsProvided() {
        new Magician(" ", 50);
    }

    // .setHealth(int)
    @Test(expected = IllegalArgumentException.class)
    public void setHealthShouldThrowAnExceptionWhenANumberBelowZeroIsProvided() {
        new Magician("PJ", -1);
    }

    // .takeDamage(int)
    @Test(expected = IllegalStateException.class)
    public void takeDamageShouldThrowAnExceptionWhenCalledOnAnAlreadyDeadMagician() {
        new Magician("PJ", 0).takeDamage(5);
    }

    @Test
    public void takeDamageShouldSuccessfullyWorkWhenCalledOnAStillAliveMagician() {
        Magician magician = new Magician("PJ", 10);
        magician.takeDamage(5);
        Assert.assertEquals(5, magician.getHealth());
    }

    @Test
    public void takeDamageShouldSetTheMagicianHealthToZeroWhenTheDamageTakenReduceItBelowZero() {
        Magician magician = new Magician("PJ", 10);
        magician.takeDamage(11);
        Assert.assertEquals(0, magician.getHealth());
    }

    // .addMagic(Magic) + .getMagic(String)
    @Test(expected = NullPointerException.class)
    public void addMagicShouldThrowAnExceptionWhenANullIsProvided() {
        new Magician("PJ", 10).addMagic(null);
    }

    @Test
    public void addMagicShouldSuccessfullyAddAMagic() {
        Magician magician = new Magician("PJ", 10);
        magician.addMagic(new Magic("Frost Bolt", 10));
        Assert.assertEquals(1, magician.getMagics().size());
        Assert.assertEquals("Frost Bolt", magician.getMagic("Frost Bolt").getName());
        Assert.assertEquals(10, magician.getMagic("Frost Bolt").getBullets());
    }

    // .removeMagic(Magic)
    @Test
    public void removeShouldReturnTrueWhenAnExistingMagicIsProvided() {
        Magician magician = new Magician("PJ", 10);
        Magic magic = new Magic("Fire", 5);
        magician.addMagic(magic);
        Assert.assertTrue(magician.removeMagic(magic));
        Assert.assertTrue(magician.getMagics().isEmpty());
    }

    @Test
    public void removeShouldReturnFalseWhenANonExistingMagicIsProvided() {
        Assert.assertFalse(new Magician("PJ", 10).removeMagic(new Magic("non-existing", 5)));
    }

    // .getMagic(String)
    @Test
    public void getMagicShouldReturnANullWhenANonExistingStringIsProvided() {
        Assert.assertNull(new Magician("PJ", 10).getMagic("non-existing"));
    }

    // .getMagics()
    @Test(expected = UnsupportedOperationException.class)
    public void getMagicsShouldNotAddAMagic() {
        new Magician("PJ", 10).getMagics().add(new Magic("wtf", 15));
    }

}
