package com.mlaku.dev.kata.streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsPoc {
    public static List<Object> generateDivisorsNumber(List<Integer> inputs, int number) {
        return inputs.stream().filter(num -> num > 0 && number % num == 0).collect(Collectors.toList());
    }

    public static Map<Object,Long> generateMapOccurrences(List<Object> inputs) {
        return inputs.stream().collect(Collectors.groupingBy(Object::toString,Collectors.counting()));
    }

    public static AbstractMap.SimpleEntry<Object, Long> getMaxOccurrences(List<Integer> inputs) {
        Optional<Map.Entry<Integer, Long>> e = inputs.stream().collect(Collectors.groupingBy(Integer::intValue,Collectors.counting()))
                .entrySet().stream().max(Comparator.comparing(Map.Entry::getValue));
        if (e.isPresent()) return new AbstractMap.SimpleEntry(e.get().getKey(),e.get().getValue());
        return null;
    }
}
