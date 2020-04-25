package com.mlaku.dev.kata.halloweencandies;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Halloween {

    public static final String TRICK_OR_TREAT = "Trick or treat!";
    public static final String THANK_YOU_STRANGE_UNCLE = "Thank you, strange uncle!";

    public static String trickOrTreat(int nbrChildren, String[][] candies) {
        if (nbrChildren < 2 || candies.length != nbrChildren) return TRICK_OR_TREAT;

        Optional<String[]> bombPacket = Arrays.stream(candies)
                .filter(packet -> Arrays.stream(packet).filter(element -> element.equals("bomb")).findFirst().isPresent())
                .findFirst();
        if (bombPacket.isPresent()) return TRICK_OR_TREAT;

        List<Long> nbrC = Arrays.stream(candies)
                .map(packet -> Arrays.stream(packet).filter(element -> element.equals("candy")).count())
                .collect(Collectors.toList());
        Long candiesFirstPacket = nbrC.get(0);
        Optional<Long> childHasDifferentAmount = nbrC.stream().filter(nbrCandiesOPacket -> hasDifferentAmountCandies(nbrCandiesOPacket < 2, nbrCandiesOPacket != candiesFirstPacket)).findFirst();
        if (childHasDifferentAmount.isPresent()) return TRICK_OR_TREAT;
        return THANK_YOU_STRANGE_UNCLE;

    }

    private static boolean hasDifferentAmountCandies(boolean b, boolean b2) {
        return b || b2;
    }

}
