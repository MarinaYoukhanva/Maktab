package org.example;

import org.example.database.Database;
import org.example.entity.Rank;
import org.example.entity.Soldier;
import org.example.serivce.SoldierService;


public class Main {
    public static void main(String[] args) {

        SoldierService soldierService = new SoldierService();
        int corporalCounter = 0;
        int roundCounter = 0;

        soldierService.soldierInit();

        for (int i = 0; i < Database.getAllSoldiers().length; i++) {
            Soldier soldier = Database.getAllSoldiers()[i];
            System.out.println(soldier);
        }
        System.out.println("Soldiers initialized successfully \n");


        do {
            for (int i = 0; i < Database.getAllSoldiers().length; i++) {
                Soldier soldier = Database.getAllSoldiers()[i];
                if (soldierService.isPassed(soldier))
                    soldierService.promoteRank(soldier);
                else
                    soldierService.demoteRank(soldier);

                System.out.println(soldier);
                if (soldier.getRank() == Rank.Corporal)
                    corporalCounter++;

            }
            roundCounter++;
            System.out.println("number of corporals: " + corporalCounter);
            System.out.println("number of rounds: " + roundCounter + "\n");
        } while (corporalCounter > 9);

    }
}