package main.lambda;

import java.util.List;

public class Functions {
    public static List<String> upCase(List<String> strings) {
        strings.replaceAll(String::toUpperCase);
        return strings;
    }

    public static int sumSqrt(List<Integer> list) {
        return list.stream().mapToInt(value -> value * value).sum();
    }
}
