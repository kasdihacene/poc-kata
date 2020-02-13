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
                .collect(Collectors.toList())
                .stream().filter(Halloween::filterGroupedPacketsByBusinessRules).collect(Collectors.toList());

        if (nbrChildren > groupedTypes.size()) return KO_MESSAGE;

        if (!isPacketsCouldSatisfyChildren(nbrChildren, groupedTypes))
            return KO_MESSAGE;

        return OK_MESSAGE;
    }

    private static boolean isPacketsCouldSatisfyChildren(int nbrChildren, List<Map<String, Long>> groupedTypes) {

        List<Map.Entry<String, Long>> listMapPackets = groupedTypes.stream().map(g -> g.entrySet())
                .collect(Collectors.toList()).stream()
                .flatMap(Collection::stream).collect(Collectors.toList());

        Optional<Map.Entry<Long, Long>> pickPossibility = listMapPackets.stream()
                .filter(entry -> entry.getKey().equalsIgnoreCase(PACKET_CANDY)).collect(Collectors.toList()).stream()
                .collect(Collectors.groupingBy(typeNbrEntries -> typeNbrEntries.getValue(), Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() == nbrChildren).findFirst();

        return pickPossibility.isPresent();
    }

    private static boolean filterGroupedPacketsByBusinessRules(Map<String, Long> group) {
        if (group.containsKey(PACKET_BOMB)) return false;
        if (group.containsKey(PACKET_CANDY) && group.get(PACKET_CANDY) < 2) return false;
        return true;
    }
}
