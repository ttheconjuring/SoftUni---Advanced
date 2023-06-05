package GenericsExercise.GenericBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < n; i++) {
                Box<String> box = new Box<>(bufferedReader.readLine());
                System.out.println(box);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
