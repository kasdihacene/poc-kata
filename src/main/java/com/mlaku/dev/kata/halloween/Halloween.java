package com.mlaku.dev.kata.halloween;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Halloween {

    private static String PACKET_BOMB = "bomb";
    private static String PACKET_CANDY = "candy";
    private static String KO_MESSAGE = "Trick or treat!";
    private static String OK_MESSAGE = "Thank you, strange uncle!";

    public static String trickOrTreat(int nbrChildren, String[][] packets) {
        List<Map<String, Long>> groupedTypes = Arrays.stream(packets)
                .map(e -> Arrays.stream(e).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())))
                .collect(Collectors.toList());

        Optional<Map<String, Long>> errorFound = groupedTypes.stream().filter(group -> {
            System.out.println(group);
            if (group.containsKey(PACKET_BOMB)) return true;
            if (group.containsKey(PACKET_CANDY) && group.get(PACKET_CANDY) < 2) return true;
            return false;
        }).findFirst();

        if (!errorFound.isPresent()){
            boolean isMatches = groupedTypes.stream().allMatch(map->map.get(PACKET_CANDY).equals(groupedTypes.get(0).get(PACKET_CANDY)));
            if (!isMatches) return KO_MESSAGE;
        }

            if (errorFound.isPresent())
            return KO_MESSAGE;

        return OK_MESSAGE;
    }
}
