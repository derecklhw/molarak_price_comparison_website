package mu.dl661.cst3130.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The RegexUtil class provides utility methods for working with regular
 * expressions.
 */
public class RegexUtil {
    /**
     * Matches a string against a regex pattern and returns the first group.
     *
     * @param input        the input string to match against
     * @param regexPattern the regex pattern to match
     * @return the first group matched by the pattern, or null if no match is found
     */
    public static String matchFirstGroup(String input, String regexPattern) {
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    /**
     * Checks if a string matches a regex pattern.
     *
     * @param input        the input string to match against
     * @param regexPattern the regex pattern to match
     * @return true if the string matches the pattern, false otherwise
     */
    public static boolean matches(String input, String regexPattern) {
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}
