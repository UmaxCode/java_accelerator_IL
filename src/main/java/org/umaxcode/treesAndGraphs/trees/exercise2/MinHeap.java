package org.umaxcode.treesAndGraphs.trees.exercise2;

import java.util.ArrayList;

public class MinHeap {

    private final ArrayList<Task> heap;
    private int size;

    public MinHeap() {
        this.heap = new ArrayList<>();
        this.heap.add(null);
        this.size = 0;
    }

    public void add(Task task) {
        this.heap.add(task);
        this.size++;
        bubbleUp();
    }

    private void bubbleUp() {
        int current = this.size;

        while (current > 1 && this.heap.get(current).compareTo(this.heap.get(this.getParentIndex(current))) < 0) {
            swap(this.getParentIndex(current), current);
            current = this.getParentIndex(current);
        }
    }

    public Task popMin() {
        int current = 1;
        Task min = this.heap.get(current);
        this.swap(current, this.size);
        this.heap.remove(this.size);
        this.size--;
        this.heapify();
        return min;
    }

    private void heapify() {
        int current = 1;
        int leftChild = this.getLeftChildIndex(current);
        int rightChild = this.getRightChildIndex(current);
        while (canSwap(current, leftChild, rightChild)) {
            if (exists(leftChild) && exists(rightChild)) {
                if (this.heap.get(leftChild).compareTo(this.heap.get(rightChild)) < 0) {
                    swap(current, leftChild);
                    current = leftChild;
                } else {
                    swap(current, rightChild);
                    current = rightChild;
                }
            } else {
                swap(current, leftChild);
                current = leftChild;
            }

            leftChild = this.getLeftChildIndex(current);
            rightChild = this.getRightChildIndex(current);
        }
    }

    private boolean canSwap(int currentIndex, int leftChildIndex, int rightChildIndex) {

        return exists(leftChildIndex) && this.heap.get(currentIndex).compareTo(this.heap.get(leftChildIndex)) > 0
                || exists(rightChildIndex) && this.heap.get(currentIndex).compareTo(this.heap.get(rightChildIndex)) > 0;
    }

    private boolean exists(int index) {
        return index <= this.size;
    }


    private void swap(int i, int j) {
        Task temp = this.heap.get(i);
        this.heap.set(i, this.heap.get(j));
        this.heap.set(j, temp);
    }


    public int getParentIndex(int currentIndex) {
        return currentIndex / 2;
    }

    public int getLeftChildIndex(int currentIndex) {
        return currentIndex * 2;
    }

    public int getRightChildIndex(int currentIndex) {
        return (currentIndex * 2) + 1;
    }

    public void displayHeap() {
        System.out.println(this.heap);
    }

}
