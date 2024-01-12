package mu.dl661.cst3130.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
    // Method to match a string against a regex pattern and return the first group
    public static String matchFirstGroup(String input, String regexPattern) {
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    // Method to check if a string matches a regex pattern
    public static boolean matches(String input, String regexPattern) {
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}
