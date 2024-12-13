package org.umaxcode.designPatterns.behavioral.factoryMethod.factory;

import org.umaxcode.designPatterns.behavioral.factoryMethod.product.GhanaSoccerTeam;
import org.umaxcode.designPatterns.behavioral.factoryMethod.product.SoccerTeam;

public class GhanaTeamManager extends TeamManager {

    @Override
    SoccerTeam scoutAndMakeATeam() {
        System.out.println("Scouting done in Ghana");
        return new GhanaSoccerTeam("Ghana");
    }
}
