package org.example;

import org.example.database.Database;
import org.example.entity.Rank;
import org.example.entity.Soldier;
import org.example.serivce.SoldierService;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        SoldierService soldierService = new SoldierService();
        soldierService.soldierInit();

        for (int i = 0; i < Database.getAllSoldiers().length; i++){
            System.out.println(Database.getAllSoldiers()[i]);
        }

    }
}