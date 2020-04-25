package com.mlaku.dev.kata.halloweencandies;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HalloweenCandiesTest {

    @Test
    public void init() {
        assertThat(true).isTrue();
    }

    // management rules :

    /**
     * - must have 2 or more children in the args
     * - if children have what they want return "Thank you, strange uncle!"
     * - else return "Trick or treat!"
     * <p>
     * 1 - Each child has at least two candies;
     * 2 - Each child gets the same amount of candy.
     * 3 - No children get the "bomb" ;-)
     * 4 - Packets cannot be divided, each child gets a full packet
     */

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

}
