package rpg_lab;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroTest {

    /* @Test
    public void attackGainsExperienceIfTargetIsDead() {
        Target fakeTarget = new Target() {
            @Override
            public void takeAttack(int attackPoints) {

            }

            @Override
            public int getHealth() {
                return 0;
            }

            @Override
            public int giveExperience() {
                return 0;
            }

            @Override
            public boolean isDead() {
                return true;
            }
        };

        Weapon fakeWeapon = new Weapon() {
            @Override
            public void attack(Target target) {

            }

            @Override
            public int getAttackPoints() {
                return 10;
            }

            @Override
            public int getDurabilityPoints() {
                return 0;
            }
        };

        Hero hero = new Hero("PESHO", fakeWeapon);
        hero.attack(fakeTarget);
        Assert.assertEquals("Wrong experience", 0, hero.getExperience());

    } */

    /* @Test
    public void attackGainsExperienceIfTargetIsDead() {
        Weapon weaponMock = Mockito.mock(Weapon.class);
        Target targetMock = Mockito.mock(Target.class);
        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(TARGET_XP);

        Hero hero = new Hero(HERO_NAME, weaponMock);

        hero.attack(targetMock);

        Assert.assertEquals("Wrong experience", TARGET_XP, hero.getExperience());
    } */

}
