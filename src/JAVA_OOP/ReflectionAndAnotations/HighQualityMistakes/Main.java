package JAVA_OOP.ReflectionAndAnotations.HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        Class<Reflection> reflectionClass = Reflection.class;

        Arrays.stream(reflectionClass.getDeclaredFields())
                .sorted(Comparator.comparing(Field::getName))
                .forEach(field -> {
            int fieldModifiers = field.getModifiers();
            if (!Modifier.isPrivate(fieldModifiers)) {
                System.out.println(field.getName() + " must be private!");
            }
        });

        Arrays.stream(reflectionClass.getDeclaredMethods())
                .filter(method -> method.getName().startsWith("get") && method.getParameterCount() == 0)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> {
                    int getterModifiers = method.getModifiers();
                    if (!Modifier.isPublic(getterModifiers)) {
                        System.out.println(method.getName() + " must be public!");
                    }
                });

        Arrays.stream(reflectionClass.getDeclaredMethods())
                .filter(method -> method.getName().startsWith("set") && method.getParameterCount() == 1)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> {
                    int setterModifiers = method.getModifiers();
                    if (!Modifier.isPrivate(setterModifiers)) {
                        System.out.println(method.getName() + " must be private!");
                    }
                });
    }

}
