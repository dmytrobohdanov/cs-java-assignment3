package com.shpp.dbohdanov.cs;

import com.shpp.cs.a.console.TextProgram;

public class Assignment3part3 extends TextProgram {
    public void run() {
        double n=raiseToPower(2.0, 2);
        println("answer is " + n);


    }

    private double raiseToPower(double base, int exponent){
        double n=1;

        if (exponent==0)
            return 1;

        if (exponent==1)
            return base;

        if (exponent==-1)
            return 1/base;

        if(exponent<0) {
            base = 1 / base;
            exponent=-exponent;
        }

        for (int i=1; i<=exponent; i++)
            n=n*base;


        return n;
    }
}