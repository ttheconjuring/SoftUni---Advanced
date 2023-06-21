package JAVA_OOP.WorkingWithAbstractionLab.HotelReservation;

public enum SeasonEnum {

    AUTUMN(1), SPRING(2), WINTER(3), SUMMER(4);

    private int value;

    SeasonEnum(int value) {
        setValue(value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
