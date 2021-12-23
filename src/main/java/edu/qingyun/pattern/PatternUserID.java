package edu.qingyun.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternUserID {

    private static Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");
    public static Pattern getNumberPattern() {
        return NUMBER_PATTERN;
    }
}
