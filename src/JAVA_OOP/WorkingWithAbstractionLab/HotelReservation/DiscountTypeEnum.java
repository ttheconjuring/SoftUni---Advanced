package JAVA_OOP.WorkingWithAbstractionLab.HotelReservation;

public enum DiscountTypeEnum {

    VIP(0.8), SECONDVISIT(0.9), NONE(1.0);

    private double value;
    DiscountTypeEnum(double value) {
        setValue(value);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

}
