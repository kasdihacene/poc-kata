package com.mlaku.dev.kata.streams.functional;

import com.mlaku.dev.kata.streams.Person;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.function.Function;

import static com.mlaku.dev.kata.streams.Profession.SOFTWARE_ENGINEER;

public class OperationInterfaceTest {

    @Test
    public void functionalInterfaceCalculateAdditionTest() {
        OperationInterface addition = (op1, op2) -> op1 + op2;
        System.out.println(addition.calculate(5, 5));
    }

    @Test
    public void sampleUsingFunctionClassTest(){
        Function<Person,Boolean> isSoftwareEngineer = a -> a.isSameProfession(SOFTWARE_ENGINEER);
        Person person = new Person("Hacene",26,SOFTWARE_ENGINEER);
        System.out.println(isSoftwareEngineer.apply(person));
    }

    @Test
    public void tryQueueStructureFunction(){
        Stack<Integer> queue = new Stack<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(queue.size());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.size());
    }
}