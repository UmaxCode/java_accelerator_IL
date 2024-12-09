package org.umaxcode.treesAndGraphs.exercise2;

public class Task implements Comparable<Task> {

    int priority;
    String description;

    Task(int priority, String description) {
        this.priority = priority;
        this.description = description;
    }

    @Override
    public int compareTo(Task other) {
        return this.priority - other.priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "priority=" + priority +
                ", description='" + description + '\'' +
                '}';
    }
}
