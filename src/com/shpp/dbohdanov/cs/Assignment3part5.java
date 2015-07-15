package com.shpp.dbohdanov.cs;

import acm.util.RandomGenerator;
import com.shpp.cs.a.console.TextProgram;

public class Assignment3part5 extends TextProgram {
    public void run() {
        int prize=0, gameCounter=0;
        while (prize<20){
            prize=prize+doGame();
            println("Your total is "+prize+"$");
            gameCounter++;
        }

        println("We finished. It took "+gameCounter+" games to earn "+prize+"$");

    }

    private int doGame() {
        int thisGamePrize=1;
        boolean orelOrReshka;
        RandomGenerator r=RandomGenerator.getInstance();
        while(true) {
            orelOrReshka = r.nextBoolean(0.5); //true is "orel", false is "reshka"
            if (orelOrReshka)
                thisGamePrize = thisGamePrize * 2;
            else {
                println("This game, you earned "+thisGamePrize+"$");
                return thisGamePrize;
            }
        }
    }
}