package org.umaxcode.javaConcurrency.exercise1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImageProcessorDemo {

    public static void main(String[] args) {

        String[] images = {
                "image1.jpg", "image2.jpg", "image3.png",
                "image4.bmp", "image5.gif", "image6.tiff"
        };

        // Thread pool with 3 threads
        try (ExecutorService executorService = Executors.newFixedThreadPool(3)) {

            for (String image : images) {
                executorService.submit(new ImageProcessor(image));
            }

            // Prevent new tasks from being submitted
            executorService.shutdown();
        }
    }
}
