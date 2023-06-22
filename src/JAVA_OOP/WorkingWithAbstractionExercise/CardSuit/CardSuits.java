package JAVA_OOP.WotkingWithAbstractionExercise.CardSuit;

public enum CardSuits {

    CLUBS, DIAMONDS, HEARTS, SPADES;

    public void print() {
        System.out.printf("Ordinal value: %d; Name value: %s%n", this.ordinal(), this.name());
    }


}
