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
        if (nbrChildren < 2 || candies.length != nbrChildren) return TRICK_OR_TREAT;

        Optional<String[]> bombPacket = Arrays.stream(candies)
                .filter(packet -> Arrays.stream(packet).anyMatch(element -> element.equals(BOMB)))
                .findFirst();
        if (bombPacket.isPresent()) return TRICK_OR_TREAT;

        List<Long> nbrCandies = Arrays.stream(candies)
                .map(packet -> Arrays.stream(packet).filter(element -> element.equals(CANDY)).count())
                .collect(Collectors.toList());

        Optional<Long> childHasDifferentAmount = nbrCandies.stream()
                .filter(nbrCandiesOPacket -> nbrCandiesOPacket < 2 || nbrCandiesOPacket != nbrCandies.get(0))
                .findFirst();
        if (childHasDifferentAmount.isPresent()) return TRICK_OR_TREAT;
        return THANK_YOU_STRANGE_UNCLE;

    }

}
