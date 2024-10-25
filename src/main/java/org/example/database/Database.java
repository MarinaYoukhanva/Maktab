package org.example.database;

import lombok.Getter;
import lombok.Setter;
import org.example.entity.Rank;
import org.example.entity.Soldier;


public class Database {

    @Getter
    private static Soldier[] allSoldiers = new Soldier[15];
    @Getter
    private static int soldierCounter = 1;

    public static void setAllSoldiers(Soldier[] allSoldiers) {
        Database.allSoldiers = allSoldiers;
    }

    public static void setSoldierCounter(int soldierCounter) {
        Database.soldierCounter = soldierCounter;
    }
}
