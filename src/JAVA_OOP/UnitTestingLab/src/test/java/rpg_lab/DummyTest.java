package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTest {

    private static final int DEFAULT_WEAPON_ATTACK = 10;
    private static final int DEFAULT_WEAPON_DURABILITY = 10;
    private static final int DEFAULT_TARGET_HEALTH = 10;
    private static final int DEFAULT_TARGET_EXPERIENCE = 10;

    private Weapon weapon;
    private Target target;

    @Before
    public void initializer() {
        this.weapon = new Axe(DEFAULT_WEAPON_ATTACK, DEFAULT_WEAPON_DURABILITY);
        this.target = new Dummy(DEFAULT_TARGET_HEALTH, DEFAULT_TARGET_EXPERIENCE);
    }

    @Test
    public void dummyShouldLoseHealthWhenAttacked() {
        this.weapon.attack(this.target);
        Assert.assertEquals(10, this.target.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyShouldThrowExceptionWhenAttacked() {
        this.weapon.attack(this.target);
        this.weapon.attack(this.target);
    }

    @Test
    public void deadDummyShouldGiveXP() {
        this.target = new Dummy(0, 10);
        Assert.assertTrue(target.giveExperience() > 0);
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyShouldNOTGiveXP() {
        this.target = new Dummy(10, 10);
        target.giveExperience();
    }

}
