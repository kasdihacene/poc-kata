package com.mlaku.dev.kata.halloweencandies;

import java.util.Arrays;
import java.util.Collection;
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

        List<String> candyCollection = Arrays.stream(candies)
                .map(packet -> Arrays.stream(packet).filter(element -> element.equals("candy")).collect(Collectors.toList()))
                .collect(Collectors.toList()).stream().flatMap(Collection::stream)
                .collect(Collectors.toList());
        // but here the rule was violated : Packets cannot be divided, each child gets a full packet
        boolean eachChildHasCandy = candyCollection.size() % nbrChildren == 0;
        if (!eachChildHasCandy) return TRICK_OR_TREAT;


        return THANK_YOU_STRANGE_UNCLE;
    }
}
