package JAVA_OOP.WorkingWithAbstractionLab.HotelReservation;

public class PriceCalculator {

    private double pricePerDay;
    private int numberOfDays;
    private int multiplier;
    private double discount;

    public PriceCalculator(double pricePerDay, int numberOfDays, String season, String discountType) {
        setPricePerDay(pricePerDay);
        setMultiplier(season);
        setNumberOfDays(numberOfDays);
        setDiscount(discountType);
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    private int getMultiplier() {
        return multiplier;
    }

    private void setMultiplier(String season) {
        switch (season) {
            case "Spring":
                this.multiplier = SeasonEnum.SPRING.getValue();
                break;
            case "Summer":
                this.multiplier = SeasonEnum.SUMMER.getValue();
                break;
            case "Autumn":
                this.multiplier = SeasonEnum.AUTUMN.getValue();
                break;
            case "Winter":
                this.multiplier = SeasonEnum.WINTER.getValue();
                break;
        }
    }

    private double getDiscount() {
        return discount;
    }

    private void setDiscount(String discountType) {
        switch (discountType) {
            case "VIP":
                this.discount = DiscountTypeEnum.VIP.getValue();
                break;
            case "SecondVisit":
                this.discount = DiscountTypeEnum.SECONDVISIT.getValue();
                break;
            case "None":
                this.discount = DiscountTypeEnum.NONE.getValue();
                break;
        }
    }

    public double calculate() {
        return getPricePerDay() * getMultiplier() * getNumberOfDays() * getDiscount();
    }

}
