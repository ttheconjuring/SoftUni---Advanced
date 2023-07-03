package JAVA_OOP.InterfacesAndAbstractionExercise.Telephony;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {

    private final List<String> numbers;
    private final List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String call() {
        StringBuilder result = new StringBuilder();
        String validNumberRegex = "\\d+";
        Pattern validNumberPattern = Pattern.compile(validNumberRegex);
        numbers.forEach(number -> {
            Matcher validNumberMatcher = validNumberPattern.matcher(number);
            if (validNumberMatcher.matches()) {
                result.append(String.format("Calling... %s%n", number));
            } else {
                result.append(String.format("Invalid number!%n"));
            }
        });
        return result.toString();
    }

    @Override
    public String browse() {
        StringBuilder result = new StringBuilder();
        String validURLRegex = "\\D+";
        Pattern validURLPattern = Pattern.compile(validURLRegex);
        urls.forEach(url -> {
            Matcher validURLMatcher = validURLPattern.matcher(url);
            if (validURLMatcher.matches()) {
                result.append(String.format("Browsing: %s!%n", url));
            } else {
                result.append(String.format("Invalid URL!%n"));
            }
        });
        return result.toString();
    }


}

