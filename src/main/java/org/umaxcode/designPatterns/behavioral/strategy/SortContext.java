package org.umaxcode.designPatterns.behavioral.strategy;

public class SortContext {

    private SortingStrategy strategy;

    public SortContext() {}

    public SortContext(final SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void execute(int[] array) {

        if (strategy == null) {
            throw new IllegalStateException("SortStrategy not set.");
        }
        strategy.sort(array);
    }
}
