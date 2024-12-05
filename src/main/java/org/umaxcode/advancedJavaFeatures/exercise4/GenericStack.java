package org.umaxcode.advancedJavaFeatures.exercise4;

public class GenericStack<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public GenericStack() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public static void main(String[] args) {
        GenericStack<Integer> intStack = new GenericStack<>();
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);
        System.out.println("Top of integer stack: " + intStack.peek());  // 3
        System.out.println("Popped from integer stack: " + intStack.pop());  // 3


        // Creating a stack for strings
        GenericStack<String> stringStack = new GenericStack<>();
        stringStack.push("Java");
        stringStack.push("Generics");
        System.out.println("Top of string stack: " + stringStack.peek());  // Generics
        System.out.println("Popped from string stack: " + stringStack.pop());
    }

    public void push(E item) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = item;
    }

    private void resize() {
        int newCapacity = elements.length * 2;
        Object[] newElements = new Object[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }

    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        E item = (E) elements[--size];
        elements[size] = null; // Avoid memory leak
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return (E) elements[size - 1];
    }
}
