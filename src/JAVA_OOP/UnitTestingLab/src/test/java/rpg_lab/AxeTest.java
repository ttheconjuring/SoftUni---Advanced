package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeTest {

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
    public void weaponAttacksLosesDurability() {
        this.weapon.attack(this.target);
        Assert.assertEquals(9, this.weapon.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void brokenWeaponCantAttack() {
        this.weapon.attack(this.target);
        this.weapon.attack(this.target);
    }

}
