package JAVA_OOP.InheritanceLab.RandomArrayList;

public class Main {

    public static void main(String[] args) {

        RandomArrayList<Integer> wtf = new RandomArrayList<>();

        wtf.add(5);
        wtf.add(2);
        wtf.add(4);
        wtf.add(1);
        wtf.add(3);

        System.out.println(wtf.removeRandomElement());
        System.out.println(wtf.removeRandomElement());


    }

}
