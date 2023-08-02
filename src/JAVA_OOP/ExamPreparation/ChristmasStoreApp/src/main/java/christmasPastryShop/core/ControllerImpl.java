package christmasPastryShop.core;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.common.OutputMessages;
import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.interfaces.OpenBooth;
import christmasPastryShop.entities.booths.interfaces.PrivateBooth;
import christmasPastryShop.entities.cocktails.interfaces.Hibernation;
import christmasPastryShop.entities.cocktails.interfaces.MulledWine;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.delicacies.interfaces.Gingerbread;
import christmasPastryShop.entities.delicacies.interfaces.Stolen;
import christmasPastryShop.repositories.interfaces.*;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private final DelicacyRepository<Delicacy> delicacyRepository;
    private final CocktailRepository<Cocktail> cocktailRepository;
    private final BoothRepository<Booth> boothRepository;
    private double income;

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
        this.delicacyRepository = delicacyRepository;
        this.cocktailRepository = cocktailRepository;
        this.boothRepository = boothRepository;
        this.income = 0;
    }


    @Override
    public String addDelicacy(String type, String name, double price) {
        Delicacy delicacy = this.delicacyRepository.getByName(name);
        if (delicacy != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, delicacy.getClass().getSimpleName(), delicacy.getName()));
        }
        if (type.equals("Gingerbread")) {
            delicacy = new Gingerbread(name, price);
        } else {
            delicacy = new Stolen(name, price);
        }
        this.delicacyRepository.add(delicacy);
        return String.format(OutputMessages.DELICACY_ADDED, name, type);
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        Cocktail cocktail = this.cocktailRepository.getByName(name);
        if (cocktail != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, cocktail.getClass().getSimpleName(), cocktail.getName()));
        }
        if (type.equals("MulledWine")) {
            cocktail = new MulledWine(name, size, brand);
        } else {
            cocktail = new Hibernation(name, size, brand);
        }
        this.cocktailRepository.add(cocktail);
        return String.format(OutputMessages.COCKTAIL_ADDED, name, brand);
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
        Booth booth = this.boothRepository.getByNumber(boothNumber);
        if (booth != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.BOOTH_EXIST, booth.getBoothNumber() ));
        }
        if (type.equals("OpenBooth")) {
            booth = new OpenBooth(boothNumber, capacity);
        } else {
            booth = new PrivateBooth(boothNumber, capacity);
        }
        this.boothRepository.add(booth);
        return String.format(OutputMessages.BOOTH_ADDED, boothNumber);
    }

    @Override
    public String reserveBooth(int numberOfPeople) {
        List<Booth> freeBooths = this.boothRepository.getAll().stream().filter(booth -> !booth.isReserved()).collect(Collectors.toList());
        if (freeBooths.isEmpty()) {
            return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }
        List<Booth> freeBoothsWithEnoughCapacity = freeBooths.stream().filter(booth -> booth.getCapacity() >= numberOfPeople).collect(Collectors.toList());
        if (freeBoothsWithEnoughCapacity.isEmpty()) {
            return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }
        freeBoothsWithEnoughCapacity.get(0).reserve(numberOfPeople);
        return String.format(OutputMessages.BOOTH_RESERVED, freeBoothsWithEnoughCapacity.get(0).getBoothNumber(), numberOfPeople);
    }

    @Override
    public String leaveBooth(int boothNumber) {
        double income = this.boothRepository.getByNumber(boothNumber).getBill() + this.boothRepository.getByNumber(boothNumber).getPrice();
        this.income += income;
        this.boothRepository.getByNumber(boothNumber).clear();
        return String.format(OutputMessages.BILL, boothNumber, income);
    }

    @Override
    public String getIncome() {
        return String.format(OutputMessages.TOTAL_INCOME, this.income);
    }
}
