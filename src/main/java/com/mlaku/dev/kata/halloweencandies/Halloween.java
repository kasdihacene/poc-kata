package com.mlaku.dev.kata.halloweencandies;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Halloween {

    public static final String TRICK_OR_TREAT = "Trick or treat!";
    public static final String THANK_YOU_STRANGE_UNCLE = "Thank you, strange uncle!";
    public static final String BOMB = "bomb";
    public static final String CANDY = "candy";

    public static String trickOrTreat(int nbrChildren, String[][] candies) {

        if (atLeastTwoChildren(nbrChildren, candies)) return TRICK_OR_TREAT;

        if (hasBombPacket(candies).isPresent()) return TRICK_OR_TREAT;

        if (hasDifferentCandiesAmount(candies).isPresent()) return TRICK_OR_TREAT;
        return THANK_YOU_STRANGE_UNCLE;

    }

    private static boolean atLeastTwoChildren(int nbrChildren, String[][] candies) {
        return nbrChildren < 2 || candies.length != nbrChildren;
    }

    private static Optional<String[]> hasBombPacket(String[][] candies) {
        return Arrays.stream(candies)
                .filter(packet -> Arrays.stream(packet).anyMatch(element -> element.equals(BOMB)))
                .findFirst();
    }

    private static Optional<Long> hasDifferentCandiesAmount(String[][] candies) {
        List<Long> nbrCandies = candiesPerPacket(candies);
        return nbrCandies.stream()
                .filter(nbrCandiesOPacket -> nbrCandiesOPacket < 2 || nbrCandiesOPacket != nbrCandies.get(0))
                .findFirst();
    }

    private static List<Long> candiesPerPacket(String[][] candies) {
        return Arrays.stream(candies)
                .map(packet -> Arrays.stream(packet).filter(element -> element.equals(CANDY)).count())
                .collect(Collectors.toList());
    }

}
