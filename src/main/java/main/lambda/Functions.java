package main.lambda;

import java.util.List;

public class Functions {
    public static List<String> upCase(List<String> strings) {
        strings.replaceAll(String::toUpperCase);
        return strings;
    }

    public static List<String> upCaseFirst(List<String> strings) {
        strings.replaceAll(str -> {
            final char[] chars = str.toCharArray();
            chars[0] = Character.toUpperCase(chars[0]);
            return String.valueOf(chars);
        });
        return strings;
    }

    public static int sumSqrt(List<Integer> list) {
        return list.stream().mapToInt(value -> value * value).sum();
    }
}
