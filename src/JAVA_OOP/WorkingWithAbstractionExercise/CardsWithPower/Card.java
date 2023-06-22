package JAVA_OOP.WotkingWithAbstractionExercise.CardsWithPower;

public class Card {

    private SuitPowers cardSuit;
    private RankPowers cardRank;
    private int power;

    public Card(SuitPowers cardSuit, RankPowers cardRank) {
        setCardSuit(cardSuit);
        setCardRank(cardRank);
        setPower();
    }

    private SuitPowers getCardSuit() {
        return cardSuit;
    }

    private void setCardSuit(SuitPowers cardSuit) {
        this.cardSuit = cardSuit;
    }

    private RankPowers getCardRank() {
        return cardRank;
    }

    private void setCardRank(RankPowers cardRank) {
        this.cardRank = cardRank;
    }

    private int getPower() {
        return power;
    }

    private void setPower() {
        this.power = getCardRank().getPower() + getCardSuit().getPower();
    }

    public void printCardPower() {
        System.out.printf("Card name: %s of %s; Card power: %d%n", getCardRank(), getCardSuit(), getPower());
    }
}
