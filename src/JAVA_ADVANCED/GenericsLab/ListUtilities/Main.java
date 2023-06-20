package GenericsLab.ListUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> integers = new LinkedList<>();
        Collections.addAll(integers, 1, 2, 18, 2, -1);

        System.out.println(ListUtils.getMax(integers));

        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "a", "b", "c");

        System.out.println(ListUtils.getMin(strings));
    }

}
