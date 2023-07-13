package JAVA_OOP.ReflectionAndAnnotationsExercise.HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

		Class<RichSoilLand> richSoilLandClass = RichSoilLand.class;
		Field[] declaredFields = richSoilLandClass.getDeclaredFields();

		Consumer<Field> fieldConsumer = field -> System.out.printf("%s %s %s\n", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName());

		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = bufferedReader.readLine();
            while (!input.equals("HARVEST")) {
                switch (input) {
                    case "private":
						Arrays.stream(declaredFields).filter(field -> Modifier.isPrivate(field.getModifiers())).forEach(fieldConsumer);
                        break;
                    case "protected":
						Arrays.stream(declaredFields).filter(field -> Modifier.isProtected(field.getModifiers())).forEach(fieldConsumer);
                        break;
                    case "public":
						Arrays.stream(declaredFields).filter(field -> Modifier.isPublic(field.getModifiers())).forEach(fieldConsumer);
                        break;
                    case "all":
						Arrays.stream(declaredFields).forEach(fieldConsumer);
                        break;
                }
                input = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
