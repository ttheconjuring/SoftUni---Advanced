package JAVA_OOP.InheritanceLab.RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {

    public T removeRandomElement() {
        T randomElementToBeRemoved = getRandomElement();
        this.remove(randomElementToBeRemoved);
        return randomElementToBeRemoved;
    }

    private T getRandomElement() {
        Random random = new Random();
        return this.get(random.nextInt(this.size()));
    }

}
