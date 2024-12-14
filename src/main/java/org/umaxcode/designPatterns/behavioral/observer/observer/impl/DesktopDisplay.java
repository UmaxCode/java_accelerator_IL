package org.umaxcode.designPatterns.behavioral.observer.observer.impl;

import org.umaxcode.designPatterns.behavioral.observer.observer.Display;

public class DesktopDisplay implements Display {

    @Override
    public void update() {
        System.out.println("Display weather update on desktop device");
    }
}
