package JAVA_OOP.WotkingWithAbstractionExercise.CardsWithPower;

public enum SuitPowers {

    CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);

    private int power;

    SuitPowers(int power) {
        setPower(power);
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
