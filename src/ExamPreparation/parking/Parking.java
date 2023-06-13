package ExamPreparation.parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {

    private String type;
    private int capacity;
    private List<Car> data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Car> getData() {
        return data;
    }

    public void setData(List<Car> data) {
        this.data = data;
    }

    public Parking(String type, int capacity) {
        setType(type);
        setCapacity(capacity);
        setData(new ArrayList<>());
    }

    public void add(Car car) {
        if (getCount() < getCapacity()) {
            getData().add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        for (Car car : getData()) {
            if (car.getManufacturer().equals(manufacturer)) {
                if (car.getModel().equals(model)) {
                    return getData().remove(car);
                }
            }
        }
        return false;
    }

    public Car getLatestCar() {
        if (!getData().isEmpty()) {
            Car latestCar = getData().get(0);
            for (Car car : getData()) {
                if (car.getYear() > latestCar.getYear()) {
                    latestCar = car;
                }
            }
            return latestCar;
        }
        return null;
    }

    public Car getCar(String manufacturer, String model) {
        if (!getData().isEmpty()) {
            for (Car car : getData()) {
                if (car.getManufacturer().equals(manufacturer)) {
                    if (car.getModel().equals(model)) {
                        return car;
                    }
                }
            }
        }
        return null;
    }

    public int getCount() {
        return getData().size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The cars are parked in %s:%n", getType()));
        getData().forEach(car -> sb.append(String.format("%s%n", car)));
        return sb.toString();
    }

}
