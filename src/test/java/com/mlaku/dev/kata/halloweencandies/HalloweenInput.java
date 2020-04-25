package com.mlaku.dev.kata.halloweencandies;

public class HalloweenInput {

    private final int nbrChildren;
    private final String[][] candies;
    private final String expectedMessage;

    private HalloweenInput(int nbrChildren, String[][] candies, String expectedMessage) {

        this.nbrChildren = nbrChildren;
        this.candies = candies;
        this.expectedMessage = expectedMessage;
    }

    public static HalloweenInput instance(int i, String[][] strings, String thankYouStrangeUncle) {
        return new HalloweenInput(i,strings,thankYouStrangeUncle);
    }

    public int getNbrChildren() {
        return nbrChildren;
    }

    public String[][] getCandies() {
        return candies;
    }

    public String getExpectedMessage() {
        return expectedMessage;
    }
}
