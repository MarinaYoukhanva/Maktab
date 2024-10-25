package org.example.serivce;

import org.example.database.Database;
import org.example.entity.Rank;
import org.example.entity.Soldier;

import java.util.Random;


public class SoldierService {

    Random rand = new Random();
    Database db ;

    public boolean isPassed (Soldier soldier){
        int finalScore = 0;
        for (int i = 0; i < soldier.getShootings().length; i++){
            finalScore += soldier.getShootings()[i];
        }
        return finalScore >= 28;
    }
    public Rank setRandomRank (){
        int randomRank = rand.nextInt(3);
        return Rank.values()[randomRank];
    }
    public void soldierInit(){
        for (int i = 0; i < Database.getAllSoldiers().length; i++){
            Soldier soldier = new Soldier();
            soldier.setRank(setRandomRank());
            soldier.setShootings(soldierShootScores());
            soldier.setId(i + 1);
            Database.getAllSoldiers()[i] = soldier;
        }
    }
    public int[] soldierShootScores (){
        int[] scores = new int[4];
        for (int i = 0 ; i < 4; i++){
            int randomScore = rand.nextInt(10);
            scores[i] = randomScore + 1;
        }
        return scores;
    }
}
