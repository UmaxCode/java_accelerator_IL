package org.umaxcode.designPatterns.behavioral.observer.publisher.impl;

import org.umaxcode.designPatterns.behavioral.observer.observer.Display;
import org.umaxcode.designPatterns.behavioral.observer.publisher.EventPublisher;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements EventPublisher {

    private final List<Display> displays;

    public WeatherStation() {
        displays = new ArrayList<>();
    }

    @Override
    public void subscribe(Display display) {
        displays.add(display);
    }

    @Override
    public void unsubscribe(Display display) {
        displays.remove(display);
    }

    @Override
    public void notifySubscribers() {
        for (Display display : displays) {
            display.update();
        }
    }
}
