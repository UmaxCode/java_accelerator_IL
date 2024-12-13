package org.umaxcode.designPatterns.behavioral.factoryMethod;

import org.umaxcode.designPatterns.behavioral.factoryMethod.factory.GhanaTeamManager;
import org.umaxcode.designPatterns.behavioral.factoryMethod.factory.NigeriaTeamManager;
import org.umaxcode.designPatterns.behavioral.factoryMethod.factory.TeamManager;

public class FactoryMethodDemo {


    public static void main(String[] args) {

        // Team maker application .....

        // Determine which team is preparing

        //Ghana
        TeamManager ghanaTeamManager = new GhanaTeamManager();
        ghanaTeamManager.beginTraining();

        //Nigeria
        TeamManager nigeriaTeamManager = new NigeriaTeamManager();
        nigeriaTeamManager.beginTraining();

    }
}
