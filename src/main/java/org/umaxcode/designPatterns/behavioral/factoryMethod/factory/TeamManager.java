package org.umaxcode.designPatterns.behavioral.factoryMethod.factory;

import org.umaxcode.designPatterns.behavioral.factoryMethod.product.SoccerTeam;

public abstract class TeamManager {

    public void beginTraining() {
        SoccerTeam team = scoutAndMakeATeam();
        team.makeFormation();
        team.processToPlay();
        System.out.println();
    }

    abstract SoccerTeam scoutAndMakeATeam();
}
