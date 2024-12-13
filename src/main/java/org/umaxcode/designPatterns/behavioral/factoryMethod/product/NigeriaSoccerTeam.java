package org.umaxcode.designPatterns.behavioral.factoryMethod.product;

public class NigeriaSoccerTeam implements SoccerTeam {

    private final String name;

    public NigeriaSoccerTeam(String name) {
        this.name = name;
    }

    @Override
    public void makeFormation() {
        System.out.println(name + " has made the formation");
    }

    @Override
    public void processToPlay() {
        System.out.println(name + " has processed to play");
    }
}
