package com.shpp.dbohdanov.cs;
import com.shpp.cs.a.console.TextProgram;

public class Assignment3part2 extends TextProgram  {
    public void run(){
        double n=readDouble("enter some number");
        doSomethingWithIt(n);
        println("Finish!");
    }

    private void doSomethingWithIt(double n) {
        if(n==1)
            return;
        if(n%2==0){
            print(n + " is even so I take half: ");
            n=n/2;
            println(n);
            if(n!=1)
                doSomethingWithIt(n);
        } else {
            print(n + " is odd so I make 3n + 1: ");
            n=n*3+1;
            println(n);
            if(n!=1)
                doSomethingWithIt(n);
        }
    }


}
