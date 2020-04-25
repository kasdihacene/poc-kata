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
    public static final int MIN_NBR_CHILDREN = 2;
    public static final int MIN_NBR_CANDIES_PER_PACKET = 2;
    public static final int INDEX_FIRST_ELEMENT = 0;

    public static String trickOrTreat(int nbrChildren, String[][] candies) {

        return isChildrenSatisfied(nbrChildren, candies) ? TRICK_OR_TREAT : THANK_YOU_STRANGE_UNCLE;
    }

    private static boolean isChildrenSatisfied(int nbrChildren, String[][] candies) {
        return atLeastTwoChildren(nbrChildren, candies) ||
                hasBombPacket(candies).isPresent() ||
                hasDifferentCandiesAmount(candies).isPresent();
    }

    private static boolean atLeastTwoChildren(int nbrChildren, String[][] candies) {
        return nbrChildren < MIN_NBR_CHILDREN || candies.length != nbrChildren;
    }

    private static Optional<String[]> hasBombPacket(String[][] candies) {
        return Arrays.stream(candies)
                .filter(packet -> Arrays.asList(packet).contains(BOMB))
                .findFirst();
    }

    private static Optional<Long> hasDifferentCandiesAmount(String[][] candies) {
        List<Long> nbrCandies = candiesPerPacket(candies);
        return nbrCandies.stream()
                .filter(nbrCandiesOPacket -> nbrCandiesOPacket < MIN_NBR_CANDIES_PER_PACKET || nbrCandiesOPacket != nbrCandies.get(INDEX_FIRST_ELEMENT))
                .findFirst();
    }

    private static List<Long> candiesPerPacket(String[][] candies) {
        return Arrays.stream(candies)
                .map(packet -> Arrays.stream(packet).filter(element -> element.equals(CANDY)).count())
                .collect(Collectors.toList());
    }

}
