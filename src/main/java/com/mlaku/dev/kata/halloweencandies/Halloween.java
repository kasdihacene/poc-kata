package com.mlaku.dev.kata.halloweencandies;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Halloween {

    public static final String TRICK_OR_TREAT = "Trick or treat!";
    public static final String THANK_YOU_STRANGE_UNCLE = "Thank you, strange uncle!";

    public static String trickOrTreat(int nbrChildren, String[][] candies) {
        if (nbrChildren < 2 || candies.length != nbrChildren) return TRICK_OR_TREAT;

        List<Long> nbrCandies = Arrays.stream(candies)
                .map(packet -> Arrays.stream(packet).filter(element -> element.equals("candy")).count())
                .collect(Collectors.toList());

        Long first = nbrCandies.get(0);
        for (int i = 0; i < nbrCandies.size(); i++) {
            if (nbrCandies.get(i) < 1 || nbrCandies.get(i) != first) return TRICK_OR_TREAT;
            first = nbrCandies.get(i);
        }

        return THANK_YOU_STRANGE_UNCLE;
    }
}
