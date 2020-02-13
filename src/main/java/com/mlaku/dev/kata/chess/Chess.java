package com.mlaku.dev.kata.chess;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Chess {

    public static int knight(String pos1, String pos2) {

        AbstractMap.SimpleEntry<Integer, Integer> pair1 = Chess.parsePositionKnight(pos1);
        AbstractMap.SimpleEntry<Integer, Integer> pair2 = Chess.parsePositionKnight(pos2);

        Set<AbstractMap.SimpleEntry<Integer, Integer>> pairs1 = new HashSet<>();
        Set<AbstractMap.SimpleEntry<Integer, Integer>> pairs2 = new HashSet<>();
        pairs1.add(pair1);
        pairs2.add(pair2);

        if (isJustOneMove(pairs1, pairs2)) return 1;
        return recursiveMoves(pairs1, pairs2);
    }

    public static int recursiveMoves(Set<AbstractMap.SimpleEntry<Integer, Integer>> possibleMovesSrc, Set<AbstractMap.SimpleEntry<Integer, Integer>> possibleMovesDest) {

        Set<AbstractMap.SimpleEntry<Integer, Integer>> setSrc = new HashSet<>(possibleMovesSrc);
        setSrc.retainAll(possibleMovesDest);

        if (!setSrc.isEmpty()) return 0;
        else {
            possibleMovesSrc.addAll(getPossibleMovesList(possibleMovesSrc));
            return 1 + recursiveMoves(possibleMovesSrc, possibleMovesDest);
        }
    }

    private static boolean isJustOneMove(Set<AbstractMap.SimpleEntry<Integer, Integer>> pairs1, Set<AbstractMap.SimpleEntry<Integer, Integer>> pairs2) {
        Set<AbstractMap.SimpleEntry<Integer, Integer>> oneMove = getPossibleMovesList(pairs1);
        oneMove.retainAll(pairs2);
        return oneMove.size() == 1;
    }

    public static AbstractMap.SimpleEntry<Integer, Integer> parsePositionKnight(String knightPosition) {
        String[] positionChess = knightPosition.split("");
        return new AbstractMap.SimpleEntry<>(getIndexFromLetter(positionChess[0]), Integer.valueOf(positionChess[1]));
    }

    public static Set<AbstractMap.SimpleEntry<Integer, Integer>> getPossibleMovesList(Set<AbstractMap.SimpleEntry<Integer, Integer>> moves) {
        Set<AbstractMap.SimpleEntry<Integer, Integer>> setMoves = new HashSet<>();
        setMoves.addAll(moves.stream().map(Chess::getPossibleUpMoves).flatMap(Set::stream).collect(Collectors.toSet()));
        setMoves.addAll(moves.stream().map(Chess::getPossibleDownMoves).flatMap(Set::stream).collect(Collectors.toSet()));
        return setMoves;
    }

    public static Set<AbstractMap.SimpleEntry<Integer, Integer>> getPossibleMoves(AbstractMap.SimpleEntry<Integer, Integer> oldPosition) {
        Set<AbstractMap.SimpleEntry<Integer, Integer>> setMoves = new HashSet<>();
        setMoves.addAll(getPossibleUpMoves(oldPosition));
        setMoves.addAll(getPossibleDownMoves(oldPosition));
        return setMoves;
    }

    public static Set<AbstractMap.SimpleEntry<Integer, Integer>> getPossibleUpMoves(AbstractMap.SimpleEntry<Integer, Integer> oldPosition) {
        Set<AbstractMap.SimpleEntry<Integer, Integer>> setMoves = new HashSet<>();

        if (oldPosition.getValue() + 1 < 9) {
            if (oldPosition.getKey() + 2 < 9) {
                setMoves.add(new AbstractMap.SimpleEntry<>(oldPosition.getKey() + 2, oldPosition.getValue() + 1));
            }
            if (oldPosition.getKey() - 2 > 0) {
                setMoves.add(new AbstractMap.SimpleEntry<>(oldPosition.getKey() - 2, oldPosition.getValue() + 1));
            }
        }

        if (oldPosition.getValue() + 2 < 9) {
            if (oldPosition.getKey() + 1 < 9) {
                setMoves.add(new AbstractMap.SimpleEntry<>(oldPosition.getKey() + 1, oldPosition.getValue() + 2));
            }
            if (oldPosition.getKey() - 1 > 0) {
                setMoves.add(new AbstractMap.SimpleEntry<>(oldPosition.getKey() - 1, oldPosition.getValue() + 2));
            }
        }

        return setMoves;
    }

    public static Set<AbstractMap.SimpleEntry<Integer, Integer>> getPossibleDownMoves(AbstractMap.SimpleEntry<Integer, Integer> oldPosition) {
        Set<AbstractMap.SimpleEntry<Integer, Integer>> setMoves = new HashSet<>();

        if (oldPosition.getValue() - 1 > 0) {
            if (oldPosition.getKey() + 2 < 9) {
                setMoves.add(new AbstractMap.SimpleEntry<>(oldPosition.getKey() + 2, oldPosition.getValue() - 1));
            }
            if (oldPosition.getKey() - 2 > 0) {
                setMoves.add(new AbstractMap.SimpleEntry<>(oldPosition.getKey() - 2, oldPosition.getValue() - 1));
            }
        }

        if (oldPosition.getValue() - 2 > 0) {
            if (oldPosition.getKey() + 1 < 9) {
                setMoves.add(new AbstractMap.SimpleEntry<>(oldPosition.getKey() + 1, oldPosition.getValue() - 2));
            }
            if (oldPosition.getKey() - 1 > 0) {
                setMoves.add(new AbstractMap.SimpleEntry<>(oldPosition.getKey() - 1, oldPosition.getValue() - 2));
            }
        }

        return setMoves;
    }


    private static int getIndexFromLetter(String letter) {
        switch (letter.toLowerCase()) {
            case "a":
                return 1;
            case "b":
                return 2;
            case "c":
                return 3;
            case "d":
                return 4;
            case "e":
                return 5;
            case "f":
                return 6;
            case "g":
                return 7;
            case "h":
                return 8;
            default:
                return 0;
        }
    }

}
