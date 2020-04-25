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

    public static HalloweenInput instance(int nbrChildren, String[][] candies, String expectedMessage) {
        return new HalloweenInput(nbrChildren,candies,expectedMessage);
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
