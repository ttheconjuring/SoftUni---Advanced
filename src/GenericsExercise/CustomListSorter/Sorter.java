package GenericsExercise.CustomListSorter;


public class Sorter {

    public static <T extends Comparable<T>> void sort(CustomList<T> arrayList) {
        for (int i = 0; i < arrayList.getSize(); i++) {
            T currentElement = arrayList.get(i);
            for (int j = i + 1; j < arrayList.getSize(); j++) {
                if(currentElement.compareTo(arrayList.get(j)) > 0) {
                    arrayList.swap(i, j);
                }
            }
        }
    }

}
