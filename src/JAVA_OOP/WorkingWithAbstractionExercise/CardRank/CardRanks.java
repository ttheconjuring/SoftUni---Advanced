package JAVA_OOP.WotkingWithAbstractionExercise.CardRank;

public enum CardRanks {

    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING;

    public void print() {
        System.out.printf("Ordinal value: %d; Name value: %s%n", this.ordinal(), this.name());
    }

}
