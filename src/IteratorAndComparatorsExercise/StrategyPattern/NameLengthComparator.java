package IteratorAndComparatorsExercise.StrategyPattern;

import java.util.Comparator;

public class NameLengthComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        int result = Integer.compare(o1.getName().length(), o2.getName().length());
        if (result == 0) {
            result = String.valueOf(o1.getName().toLowerCase().charAt(0)).compareTo(String.valueOf(o2.getName().toLowerCase().charAt(0)));
        }
        return result;
    }
}
