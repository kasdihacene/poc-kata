package com.mlaku.dev.kata.chess;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Chess {

    public static int knight(String pos1, String pos2) {

        AbstractMap.SimpleEntry<Integer, Integer> pair1 = parsePositionKnight(pos1);
        AbstractMap.SimpleEntry<Integer, Integer> pair2 = parsePositionKnight(pos2);

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

        if (moveStepUp(oldPosition) < 9) {
            if (moveStepRight(oldPosition) + 1 < 9) {
                setMoves.add(new AbstractMap.SimpleEntry<>(moveStepRight(oldPosition) + 1, moveStepUp(oldPosition)));
            }
            if (moveStepLeft(oldPosition) - 1 > 0) {
                setMoves.add(new AbstractMap.SimpleEntry<>(moveStepLeft(oldPosition) - 1, moveStepUp(oldPosition)));
            }
        }

        if (moveStepUp(oldPosition) + 1 < 9) {
            if (moveStepRight(oldPosition) < 9) {
                setMoves.add(new AbstractMap.SimpleEntry<>(moveStepRight(oldPosition), moveStepUp(oldPosition) + 1));
            }
            if (moveStepLeft(oldPosition) > 0) {
                setMoves.add(new AbstractMap.SimpleEntry<>(moveStepLeft(oldPosition), moveStepUp(oldPosition) + 1));
            }
        }

        return setMoves;
    }

    public static Set<AbstractMap.SimpleEntry<Integer, Integer>> getPossibleDownMoves(AbstractMap.SimpleEntry<Integer, Integer> oldPosition) {
        Set<AbstractMap.SimpleEntry<Integer, Integer>> setMoves = new HashSet<>();

        if (moveStepDown(oldPosition) > 0) {
            if (moveStepRight(oldPosition) + 1 < 9) {
                setMoves.add(new AbstractMap.SimpleEntry<>(moveStepRight(oldPosition) + 1, moveStepDown(oldPosition)));
            }
            if (moveStepLeft(oldPosition) - 1 > 0) {
                setMoves.add(new AbstractMap.SimpleEntry<>(moveStepLeft(oldPosition) - 1, moveStepDown(oldPosition)));
            }
        }

        if (moveStepDown(oldPosition) - 1 > 0) {
            if (moveStepRight(oldPosition) < 9) {
                setMoves.add(new AbstractMap.SimpleEntry<>(moveStepRight(oldPosition), moveStepDown(oldPosition) - 1));
            }
            if (moveStepLeft(oldPosition) > 0) {
                setMoves.add(new AbstractMap.SimpleEntry<>(moveStepLeft(oldPosition), moveStepDown(oldPosition) - 1));
            }
        }

        return setMoves;
    }

    private static int moveStepRight(AbstractMap.SimpleEntry<Integer, Integer> oldPosition) {
        return oldPosition.getKey() + 1;
    }

    private static int moveStepUp(AbstractMap.SimpleEntry<Integer, Integer> oldPosition) {
        return oldPosition.getValue() + 1;
    }

    private static int moveStepDown(AbstractMap.SimpleEntry<Integer, Integer> oldPosition) {
        return oldPosition.getValue() - 1;
    }

    private static int moveStepLeft(AbstractMap.SimpleEntry<Integer, Integer> oldPosition) {
        return oldPosition.getKey() - 1;
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
