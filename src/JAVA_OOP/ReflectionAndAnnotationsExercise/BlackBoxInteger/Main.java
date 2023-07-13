package JAVA_OOP.ReflectionAndAnnotationsExercise.BlackBoxInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<BlackBoxInt> blackBoxIntClass = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = blackBoxIntClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();
        Field innerValue = blackBoxIntClass.getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = bufferedReader.readLine();
            while (!input.equals("END")) {
                String[] inputArray = input.split("_");
                String commandName = inputArray[0];
                int value = Integer.parseInt(inputArray[1]);
                Method declaredMethod = blackBoxIntClass.getDeclaredMethod(commandName, int.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(blackBoxInt, value);
                System.out.println(innerValue.get(blackBoxInt));
                input = bufferedReader.readLine();
            }
        } catch (IOException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
