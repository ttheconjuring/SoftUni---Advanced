package GenericsLab.JarOfT;

public class Main {

    public static void main(String[] args) {

        Jar<String> wtf = new Jar<>();
        wtf.add("1");
        wtf.add("2");
        wtf.add("3");
        wtf.add("4");
        System.out.println(wtf.remove());
        System.out.println(wtf.remove());
        System.out.println(wtf.remove());
        System.out.println(wtf.remove());

        wtf.remove();

    }

}
