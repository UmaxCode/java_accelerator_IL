package org.umaxcode.designPatterns.behavioral.factoryMethod.factory;

import org.umaxcode.designPatterns.behavioral.factoryMethod.product.NigeriaSoccerTeam;
import org.umaxcode.designPatterns.behavioral.factoryMethod.product.SoccerTeam;

public class NigeriaTeamManager extends TeamManager {

    @Override
    SoccerTeam scoutAndMakeATeam() {
        System.out.println("Scouting done in Nigeria");
        return new NigeriaSoccerTeam("Nigeria");
    }
}
