package com.mlaku.dev.kata.halloweencandies;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HalloweenCandiesTest {

    @Test
    public void init() {
        assertThat(true).isTrue();
    }

    @Test
    public void returnsThankYouWhenHaving2packetsWith2candiesFor2children() {
        String result = Halloween.trickOrTreat(2, new String[][]{{"candy", "apple", "candy"}, {"candy", "candy"}});
        assertThat(result).isEqualTo("Thank you, strange uncle!");
    }

    @Test
    public void returnsTrickOrTreatWhenHavingNoChildren() {
        String result = Halloween.trickOrTreat(0, new String[][]{{"candy", "apple", "candy"}, {"candy", "candy"}});
        assertThat(result).isEqualTo("Trick or treat!");
    }

    @Test
    public void returnsTrickOrTreatWhenHavingNoPackets() {
        String result = Halloween.trickOrTreat(2, new String[][]{});
        assertThat(result).isEqualTo("Trick or treat!");
    }

    @Test
    public void shouldHaveTheSameNbrPacketsAndNbrChildren() {
        String[][] candies = {{"candy", "apple"}, {"apple", "candy"}, {"candy", "apple"}};
        assertThat(Halloween.trickOrTreat(2, candies)).isEqualTo("Trick or treat!");
    }

    @Test
    public void shouldFailWhenOnlyOneChild() {
        String[][] candies = {{"candy", "apple"}};
        assertThat(Halloween.trickOrTreat(1, candies)).isEqualTo("Trick or treat!");
    }

    @Test
    public void returnsThankYouWhenEachChildHaveAtLeast2Candies() {
        String[][] candies = {{"candy", "candy"}, {"candy", "candy"}, {"candy", "candy"}};
        assertThat(Halloween.trickOrTreat(3, candies)).isEqualTo(Halloween.THANK_YOU_STRANGE_UNCLE);
    }

    @Test
    public void returnsTrickOrTreatWhenChildHaveOnlyOneCandy() {
        String[][] candies = {{"candy", "candy"}, {"candy", "candy"}, {"candy", "apple"}};
        assertThat(Halloween.trickOrTreat(3, candies)).isEqualTo("Trick or treat!");
    }

    @Test
    public void returnsTrickOrTreatWhenChildrenHaveDifferentAmountOfCandies() {
        String[][] candies = {{"candy", "candy"}, {"candy", "candy"}, {"candy", "candy", "candy", "apple"}};
        assertThat(Halloween.trickOrTreat(3, candies)).isEqualTo("Trick or treat!");
    }

    @Test
    public void returnsTrickOrTreatWhenSomeChildGotABomb() {
        String[][] candies = {{"candy", "apple", "candy"}, {"candy", "candy"}, {"candy", "bomb", "candy"}};
        assertThat(Halloween.trickOrTreat(3, candies)).isEqualTo("Trick or treat!");
    }

    @Test
    public void returnsTrickOrTreatWhenChildrenHaveDifferentAmountOfCandiesWithoutDividingPackets() {
        String[][] candies = {{"candy", "candy"}, {"candy", "candy", "candy", "candy", "candy"}, {"candy", "candy", "apple"}};
        assertThat(Halloween.trickOrTreat(3, candies)).isEqualTo("Trick or treat!");
    }

}
