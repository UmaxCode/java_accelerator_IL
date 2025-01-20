package org.umaxcode.designPatterns.behavioral.observer.publisher;

import org.umaxcode.designPatterns.behavioral.observer.observer.Display;

public interface EventPublisher {

    void subscribe(Display display);

    void unsubscribe(Display display);

    void notifySubscribers();
}
