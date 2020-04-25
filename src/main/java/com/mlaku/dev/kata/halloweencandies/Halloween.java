package com.mlaku.dev.kata.halloweencandies;

public class Halloween {
    public static String trickOrTreat(int nbrChldren, String[][] candies) {
        if (candies.length == 0) return "Trick or treat!";
        if (nbrChldren == 0) return "Trick or treat!";
        return "Thank you, strange uncle!";
    }
}
