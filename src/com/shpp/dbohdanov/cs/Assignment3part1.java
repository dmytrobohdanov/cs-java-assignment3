package com.shpp.dbohdanov.cs;

import com.shpp.cs.a.console.TextProgram;

public class Assignment3part1 extends TextProgram {
    public void run() {
        int cardio=0, bloodpr=0;

        for (int i=1; i<=7; i++){
            int r=readInt("How many minutes did you do on day "+i+"?");
            if(r>=30)
                cardio++;
            if(r>=40)
                bloodpr++;

        }

        printResults(cardio, bloodpr);


    }

    private void printResults(int cardio, int bloodpr) {
        println("Cardiovacular health:");
        if (cardio>=5)
            println("        Great job! You've done enough exercise for cardiovacular health");
        else {
            cardio=5-cardio;
            println("        You needed to train hard for at least " + cardio + " more day(s) a week!");
        }
        println("Blood pressure:");
        if (bloodpr>=3)
            println("        Great job! You've done enough exercise to keep a low blood pressure.");
        else {
            bloodpr=3-bloodpr;
            println("        You needed to train hard for at least " + bloodpr + " more day(s) a week!");
        }
    }
}
