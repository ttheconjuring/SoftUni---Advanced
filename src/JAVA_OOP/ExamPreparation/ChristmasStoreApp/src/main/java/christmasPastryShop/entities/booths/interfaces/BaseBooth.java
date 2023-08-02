package christmasPastryShop.entities.booths.interfaces;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseBooth implements Booth {

    private final Collection<Delicacy> delicacyOrders;
    private final Collection<Cocktail> cocktailOrders;
    private final int boothNumber;
    private int capacity;
    private int numberOfPeople;
    private final double pricePerPerson;
    private boolean isReserved;
    private double price;

    protected BaseBooth(int boothNumber, int capacity, double pricePerPerson) {
        this.boothNumber = boothNumber;
        this.setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        this.delicacyOrders = new ArrayList<>();
        this.cocktailOrders = new ArrayList<>();
    }

    @Override
    public int getBoothNumber() {
        return this.boothNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    private void setCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    public int getNumberOfPeople() {
        return this.numberOfPeople;
    }

    private void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public boolean isReserved() {
        return this.isReserved;
    }

    private void setReserved(boolean state) {
        this.isReserved = state;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        this.setNumberOfPeople(numberOfPeople);
        this.setReserved(true);
        this.price = numberOfPeople * this.pricePerPerson;
    }

    @Override
    public double getBill() {
        return this.delicacyOrders.stream().mapToDouble(Delicacy::getPrice).sum() + this.cocktailOrders.stream().mapToDouble(Cocktail::getPrice).sum();
    }

    @Override
    public void clear() {
        this.delicacyOrders.clear();
        this.cocktailOrders.clear();
        this.setReserved(false);
        this.numberOfPeople = 0;
        this.setPrice(0);
    }
}
