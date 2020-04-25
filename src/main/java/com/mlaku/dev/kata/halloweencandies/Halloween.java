package com.mlaku.dev.kata.halloweencandies;

public class Halloween {

    public static final String TRICK_OR_TREAT = "Trick or treat!";
    public static final String THANK_YOU_STRANGE_UNCLE = "Thank you, strange uncle!";

    public static String trickOrTreat(int nbrChildren, String[][] candies) {
        if (candies.length == 0 || nbrChildren == 0) return TRICK_OR_TREAT;
        return THANK_YOU_STRANGE_UNCLE;
    }
}
