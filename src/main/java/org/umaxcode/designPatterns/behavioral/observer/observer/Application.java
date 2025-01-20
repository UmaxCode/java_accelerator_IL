package org.umaxcode.designPatterns.behavioral.observer.observer;

import org.umaxcode.designPatterns.behavioral.observer.observer.impl.DesktopDisplay;
import org.umaxcode.designPatterns.behavioral.observer.observer.impl.MobileDisplay;
import org.umaxcode.designPatterns.behavioral.observer.observer.impl.WearableDisplay;
import org.umaxcode.designPatterns.behavioral.observer.publisher.EventPublisher;
import org.umaxcode.designPatterns.behavioral.observer.publisher.impl.WeatherStation;

public class Application {

    private final EventPublisher eventPublisher;

    public Application(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public static void main(String[] args) {

        Display desktop = new DesktopDisplay();
        Display mobile = new MobileDisplay();
        Display wearable = new WearableDisplay();

        Application app = new Application(
                new WeatherStation()
        );

        app.getEventPublisher().subscribe(desktop);
        app.getEventPublisher().subscribe(mobile);
        app.getEventPublisher().subscribe(wearable);

        // A change in weather occurred
        app.receiveWeatherChange();
        /*
          You will see that the update will be displayed on
          all the displays
         */

        System.out.println("------- : -------");
        // desktop unsubscribed
        app.getEventPublisher().unsubscribe(desktop);

        // A change in weather occurred again
        app.receiveWeatherChange();
        /*
          You will see that the update will be displayed on all the displays
          except the desktop since it unsubscribed
         */
    }

    public EventPublisher getEventPublisher() {
        return eventPublisher;
    }

    public void receiveWeatherChange() {
        eventPublisher.notifySubscribers();
    }
}
