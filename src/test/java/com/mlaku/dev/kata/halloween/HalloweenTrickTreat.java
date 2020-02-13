package com.mlaku.dev.kata.halloween;

import org.junit.Assert;
import org.junit.Test;

public class HalloweenTrickTreat {

    @Test
    public void should_return_trickOrTreat_when_bomb_isFound(){
        String message = Halloween.trickOrTreat(3,new String[][] {{"candy","apple","candy"},{"candy","candy"},{"candy","bomb","candy"}});
        Assert.assertEquals("Trick or treat!",message);
    }

    @Test
    public void should_have_at_least_two_candies(){
        String message = Halloween.trickOrTreat(3,new String[][] {{"candy","apple","candy"},{"candy","apple"},{"candy","bomb","candy"}});
        Assert.assertEquals("Trick or treat!",message);
    }

    @Test
    public void nominal_scenario_two_candies_forEvery_Child(){
        String message = Halloween.trickOrTreat(3,new String[][] {{"candy","apple","candy"},{"candy","candy","apple"},{"candy","apple","candy"}});
        Assert.assertEquals("Thank you, strange uncle!",message);
    }
    @Test
    public void should_have_same_amount_ofCandies(){
        String message = Halloween.trickOrTreat(3,new String[][] {{"candy","apple","candy"},{"candy","candy","apple"},{"candy","candy","candy"}});
        Assert.assertEquals("Trick or treat!",message);
    }
}
