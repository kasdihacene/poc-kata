package com.mlaku.dev.kata.halloweencandies;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HalloweenCandiesTest {

    @Test
    public void returnsThankYouWhenHaving2packetsWith2candiesFor2children() {
        int nbrChildren = 2;
        String[][] candies = {{"candy", "apple", "candy"}, {"candy", "candy"}};
        String expected = "Thank you, strange uncle!";

        String result = Halloween.trickOrTreat(nbrChildren, candies);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void returnsTrickOrTreatWhenHavingNoChildren() {
        int nbrChildren = 0;
        String[][] candies = {{"candy", "apple", "candy"}, {"candy", "candy"}};
        String expected = "Trick or treat!";

        String result = Halloween.trickOrTreat(nbrChildren, candies);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void returnsTrickOrTreatWhenHavingNoPackets() {
        int nbrChildren = 2;
        String[][] candies = {};
        String expected = "Trick or treat!";

        String result = Halloween.trickOrTreat(nbrChildren, candies);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void shouldHaveTheSameNbrPacketsAndNbrChildren() {
        String[][] candies = {{"candy", "apple"}, {"apple", "candy"}, {"candy", "apple"}};
        int nbrChildren = 2;
        String expected = "Trick or treat!";

        String actual = Halloween.trickOrTreat(nbrChildren, candies);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldFailWhenOnlyOneChild() {
        String[][] candies = {{"candy", "apple"}};
        int nbrChildren = 1;
        String expected = "Trick or treat!";

        String actual = Halloween.trickOrTreat(nbrChildren, candies);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void returnsThankYouWhenEachChildHaveAtLeast2Candies() {
        String[][] candies = {{"candy", "candy"}, {"candy", "candy"}, {"candy", "candy"}};
        int nbrChildren = 3;
        String expected = "Thank you, strange uncle!";

        String actual = Halloween.trickOrTreat(nbrChildren, candies);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void returnsTrickOrTreatWhenChildHaveOnlyOneCandy() {
        String[][] candies = {{"candy", "candy"}, {"candy", "candy"}, {"candy", "apple"}};
        int nbrChildren = 3;
        String expected = "Trick or treat!";

        String actual = Halloween.trickOrTreat(nbrChildren, candies);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void returnsTrickOrTreatWhenChildrenHaveDifferentAmountOfCandies() {
        String[][] candies = {{"candy", "candy"}, {"candy", "candy"}, {"candy", "candy", "candy", "apple"}};
        int nbrChildren = 3;
        String actual = Halloween.trickOrTreat(nbrChildren, candies);

        String expected = "Trick or treat!";

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void returnsTrickOrTreatWhenSomeChildGotABomb() {
        String[][] candies = {{"candy", "apple", "candy"}, {"candy", "candy"}, {"candy", "bomb", "candy"}};
        int nbrChildren = 3;
        String expected = "Trick or treat!";

        String actual = Halloween.trickOrTreat(nbrChildren, candies);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void returnsTrickOrTreatWhenChildrenHaveDifferentAmountOfCandiesWithoutDividingPackets() {
        String[][] candies = {{"candy", "candy"}, {"candy", "candy", "candy", "candy", "candy"}, {"candy", "candy", "apple"}};
        int nbrChildren = 3;
        String expected = "Trick or treat!";

        String actual = Halloween.trickOrTreat(nbrChildren, candies);

        assertThat(actual).isEqualTo(expected);
    }

}
