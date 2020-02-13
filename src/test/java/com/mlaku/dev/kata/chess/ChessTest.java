package com.mlaku.dev.kata.chess;

import org.junit.Assert;
import org.junit.Test;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class ChessTest {

    @Test
    public void shouldGetPairFromString() {
        AbstractMap.SimpleEntry<Integer,Integer> pair = Chess.parsePositionKnight("d1");
        Assert.assertTrue(4==pair.getKey());
        Assert.assertTrue(1==pair.getValue());
    }

    @Test
    public void shouldReturn4movesToUp() {
        AbstractMap.SimpleEntry<Integer,Integer> pair = Chess.parsePositionKnight("d1");
        Set<AbstractMap.SimpleEntry<Integer,Integer>> pairs = Chess.getPossibleUpMoves(pair);
        Assert.assertTrue(pairs.size()==4);
    }

    @Test
    public void shouldReturn2movesToUpWhenCorner() {
        AbstractMap.SimpleEntry<Integer,Integer> pair = Chess.parsePositionKnight("h1");
        Set<AbstractMap.SimpleEntry<Integer,Integer>> pairs = Chess.getPossibleUpMoves(pair);
        Assert.assertTrue(pairs.size()==2);
    }

    @Test
    public void shouldReturnZeroMovesToUpWhenCornerUp() {
        AbstractMap.SimpleEntry<Integer,Integer> pair = Chess.parsePositionKnight("h8");
        Set<AbstractMap.SimpleEntry<Integer,Integer>> pairs = Chess.getPossibleUpMoves(pair);
        Assert.assertTrue(pairs.size()==0);
    }

    @Test
    public void shouldReturn8Moves() {
        AbstractMap.SimpleEntry<Integer,Integer> pair = Chess.parsePositionKnight("e3");
        Set<AbstractMap.SimpleEntry<Integer,Integer>> pairs = Chess.getPossibleMoves(pair);
        System.out.println(pairs);
        Assert.assertTrue(pairs.size()==8);
    }

    @Test
    public void shouldReturn2DownMoves() {
        AbstractMap.SimpleEntry<Integer,Integer> pair = Chess.parsePositionKnight("h8");
        Set<AbstractMap.SimpleEntry<Integer,Integer>> pairs = Chess.getPossibleDownMoves(pair);
        System.out.println(pairs);
        Assert.assertTrue(pairs.size()==2);
    }

    @Test
    public void shouldMergeSetsMoves() {
        AbstractMap.SimpleEntry<Integer,Integer> pair1 = Chess.parsePositionKnight("h8");
        AbstractMap.SimpleEntry<Integer,Integer> pair2 = Chess.parsePositionKnight("a1");

        Set<AbstractMap.SimpleEntry<Integer,Integer>> pairs = new HashSet<>();
        pairs.add(pair1);
        pairs.add(pair2);

        Set<AbstractMap.SimpleEntry<Integer,Integer>> mergedMoves = Chess.getPossibleMovesList(pairs);
        System.out.println(mergedMoves);
        Assert.assertTrue(mergedMoves.size()==4);
    }

    @Test
    public void shouldLaunchRecursiveSearch() {
        AbstractMap.SimpleEntry<Integer,Integer> pair1 = Chess.parsePositionKnight("c1");
        AbstractMap.SimpleEntry<Integer,Integer> pair2 = Chess.parsePositionKnight("f8");

        Set<AbstractMap.SimpleEntry<Integer,Integer>> pairs1 = new HashSet<>();
        Set<AbstractMap.SimpleEntry<Integer,Integer>> pairs2 = new HashSet<>();
        pairs1.add(pair1);
        pairs2.add(pair2);

        int movesNbr = Chess.recursiveMoves(pairs1,pairs2);
        Assert.assertTrue(movesNbr == 4);
    }

    @Test
    public void shouldReturnOneMove() {
        int moves = Chess.knight("d1","e3");
        System.out.println(moves);
    }

    @Test
    public void shouldReturnOneMoveCorner() {
        int moves = Chess.knight("h8","g6");
        System.out.println(moves);
    }

    @Test
    public void shouldReturnMax5MovesWhenDiagonal() {
        int moves = Chess.knight("h8","b1");
        System.out.println(moves);
    }

    @Test
    public void sampleTests() {
        assertEquals("Test for (a1, f1)", 3, Chess.knight("a1", "f1"));
        assertEquals("Test for (a1, c1)", 2, Chess.knight("a1", "c1"));
        assertEquals("Test for (a1, f3)", 3, Chess.knight("a1", "f3"));
        assertEquals("Test for (a1, f4)", 4, Chess.knight("a1", "f4"));
        assertEquals("Test for (a1, f7)", 5, Chess.knight("a1", "f7"));
    }

    @Test
    public void sampleTests2() {
        assertEquals("Test for (a1, f1)", 3, Chess.knight("a1", "f1"));
        assertEquals("Test for (a1, c1)", 2, Chess.knight("a1", "c1"));
        assertEquals("Test for (a1, f3)", 3, Chess.knight("a1", "f3"));
        assertEquals("Test for (a1, f4)", 4, Chess.knight("a1", "f4"));
        assertEquals("Test for (a1, f7)", 5, Chess.knight("a1", "f7"));
    }
}