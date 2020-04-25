package com.mlaku.dev.kata.halloweencandies;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class HalloweenCandiesTest {

    public static final String THANK_YOU_STRANGE_UNCLE = "Thank you, strange uncle!";
    public static final String TRICK_OR_TREAT = "Trick or treat!";

    @ParameterizedTest
    @MethodSource("halloweenGenerator")
    void shouldSatisfyAllChildrenParameterizedTest(HalloweenInput value) {

        String result = Halloween.trickOrTreat(value.getNbrChildren(), value.getCandies());

        assertThat(result).isEqualTo(value.getExpectedMessage());
    }

    private static Stream<Arguments> halloweenGenerator() {

        return Stream.of(
                Arguments.of(HalloweenInput.instance(2, new String[][]{{"candy", "apple", "candy"}, {"candy", "candy"}}, THANK_YOU_STRANGE_UNCLE)),
                Arguments.of(HalloweenInput.instance(0, new String[][]{{"candy", "apple", "candy"}, {"candy", "candy"}}, TRICK_OR_TREAT)),
                Arguments.of(HalloweenInput.instance(2, new String[][]{{"candy", "apple"}, {"apple", "candy"}, {"candy", "apple"}}, TRICK_OR_TREAT)),
                Arguments.of(HalloweenInput.instance(1, new String[][]{{"candy", "apple"}}, TRICK_OR_TREAT)),
                Arguments.of(HalloweenInput.instance(3, new String[][]{{"candy", "candy"}, {"candy", "candy"}, {"candy", "candy"}}, THANK_YOU_STRANGE_UNCLE)),
                Arguments.of(HalloweenInput.instance(3, new String[][]{{"candy", "candy"}, {"candy", "candy"}, {"candy", "apple"}}, TRICK_OR_TREAT)),
                Arguments.of(HalloweenInput.instance(3, new String[][]{{"candy", "candy"}, {"candy", "candy"}, {"candy", "candy", "candy", "apple"}}, TRICK_OR_TREAT)),
                Arguments.of(HalloweenInput.instance(3, new String[][]{{"candy", "apple", "candy"}, {"candy", "candy"}, {"candy", "bomb", "candy"}}, TRICK_OR_TREAT)),
                Arguments.of(HalloweenInput.instance(3, new String[][]{{"candy", "candy"}, {"candy", "candy", "candy", "candy", "candy"}, {"candy", "candy", "apple"}}, TRICK_OR_TREAT)),
                Arguments.of(HalloweenInput.instance(2, new String[][]{}, TRICK_OR_TREAT))
        );
    }

}
