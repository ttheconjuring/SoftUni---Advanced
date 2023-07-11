package JAVA_OOP.ReflectionAndAnotations.GettersAndSetters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        Class<Reflection> reflectionClass = Reflection.class;

        Arrays.stream(reflectionClass.getDeclaredMethods())
                .filter(method ->
                        (method.getName().startsWith("get") && method.getParameterCount() == 0)
                                || (method.getName().startsWith("set") && method.getParameterCount() == 1))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> {
                    if (method.getName().startsWith("get")) {
                        System.out.printf("%s will return class %s%n", method.getName(), method.getReturnType().getName());
                    } else {
                        System.out.printf("%s and will set field of class %s%n", method.getName(), method.getReturnType().getName());
                    }
                });

    }

}
