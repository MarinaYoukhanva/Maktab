package org.example.serivce;

import org.example.database.Database;
import org.example.entity.*;

import java.util.Random;


public class SoldierService {

    Random rand = new Random();
    Database db;

    public boolean isPassed(Soldier soldier) {
        int finalScore = 0;
        for (int i = 0; i < soldier.getShootings().length; i++) {
            finalScore += soldier.getShootings()[i];
            soldier.setFinalScore(finalScore);
        }
        return finalScore >= 28;
    }

    public void promoteRank(Soldier soldier) {
        Rank rank = soldier.getRank();
        if (rank != Rank.Corporal){
            soldier.setRank(Rank.values()[rank.ordinal() + 1]);
        }
    }
    public void demoteRank(Soldier soldier) {
        Rank rank = soldier.getRank();
        if (rank != Rank.Lieutenant){
            soldier.setRank(Rank.values()[rank.ordinal() - 1]);
        }
    }

    public Rank setRandomRank() {
        int randomRank = rand.nextInt(3);
        return Rank.values()[randomRank];
    }

    public void soldierInit() {
        for (int i = 0; i < Database.getAllSoldiers().length; i++) {
            Soldier soldier = new Soldier();
            soldier.setRank(setRandomRank());
            soldier.setShootings(soldierShootScores());
            soldier.setId(i + 1);
            Database.getAllSoldiers()[i] = soldier;
        }
    }

    public int[] soldierShootScores() {
        int[] scores = new int[4];
        for (int i = 0; i < 4; i++) {
            int randomScore = rand.nextInt(11);
            scores[i] = randomScore;
        }
        return scores;
    }

}
