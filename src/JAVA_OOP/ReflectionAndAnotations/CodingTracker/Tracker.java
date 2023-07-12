package JAVA_OOP.ReflectionAndAnotations.CodingTracker;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tracker {

    @Author(name = "ivan")
    public static void main(String[] args) {
        printMethodsByAuthor(Tracker.class);
    }

    @Author(name = "pesho")
    public static void printMethodsByAuthor(Class<?> cl) {
        Map<String, List<String>> methodsByAuthor = new HashMap<>();
        Method[] methods = cl.getDeclaredMethods();
        for (Method method : methods) {
            Author annotation = method.getAnnotation(Author.class);
            if (annotation != null) {
                methodsByAuthor.putIfAbsent(annotation.name(), new ArrayList<>());
                methodsByAuthor.get(annotation.name()).add(method.getName() + "()");
            }
        }
        for (Map.Entry<String, List<String>> stringListEntry : methodsByAuthor.entrySet()) {
            System.out.print(stringListEntry.getKey() + ": ");
            for (String s : stringListEntry.getValue()) {
                System.out.print(s);
            }
            System.out.println();
        }

    }
}


