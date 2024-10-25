package org.example.entity;

import lombok.*;

import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Soldier {

    int id = 0;
    Rank rank;
    int[] shootings = new int[4];
    int finalScore;



}
