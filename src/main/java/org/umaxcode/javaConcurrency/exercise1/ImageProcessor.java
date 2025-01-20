package org.umaxcode.javaConcurrency.exercise1;

public class ImageProcessor implements Runnable {

    private final String imageName;

    public ImageProcessor(String imageName) {
        this.imageName = imageName;
    }


    @Override
    public void run() {
        System.out.println("Processing image: " + imageName + " | Thread: " + Thread.currentThread().getName());
        try {
            // Simulate processing time
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Processing interrupted for: " + imageName);
            Thread.currentThread().interrupt();
        }
        System.out.println("Finished processing image: " + imageName + " | Thread: " + Thread.currentThread().getName());
    }
}
