package org.umaxcode.designPatterns.behavioral.observer.observer.impl;

import org.umaxcode.designPatterns.behavioral.observer.observer.Display;

public class MobileDisplay implements Display {

    @Override
    public void update() {
        System.out.println("Display weather update on mobile device");
    }
}
