package org.umaxcode.advancedJavaFeatures.exercise4;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class GenericStackArrayList<T> {

    private final ArrayList<T> elements;

    //Constructor to initialize the stack
    public GenericStackArrayList() {
        this.elements = new ArrayList<>();
        Stack<String> stack = new Stack<>();
    }

    public static void main(String[] args) {
        GenericStackArrayList<Integer> integerStack = new GenericStackArrayList<>();
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        System.out.println("Top of integer stack: " + integerStack.peek());  // 3
        System.out.println("Popped from integer stack: " + integerStack.pop());  // 3


        // Creating a stack for strings
        GenericStack<String> stringStack = new GenericStack<>();
        stringStack.push("Java");
        stringStack.push("Generics");
        System.out.println("Top of string stack: " + stringStack.peek());  // Generics
        System.out.println("Popped from string stack: " + stringStack.pop());
    }

    // Push an element onto the stack
    public void push(T value) {
        elements.add(value);
    }

    // Pop an element from the top of the stack
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.removeLast();
    }

    boolean isEmpty() {
        return elements.isEmpty();
    }

    // Peek at the top element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.getLast();
    }

    // Get the current size of the stack
    public int size() {
        return elements.size();
    }
}
