package com.shpp.dbohdanov.cs;

import com.shpp.cs.a.graphics.WindowProgram;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.graphics.GLabel;

import java.awt.*;


public class Assignment3part4 extends WindowProgram {
    public static final double BRICK_HEIGHT=20;
    public static final double BRICK_WIDTH=40;
    public static final int BRICKS_IN_BASE=10;
    public static final double SIZE_OF_LINE_BETWEEN_BRICKS = 0;

    public void run() {
        int blocksInCurrentLine=BRICKS_IN_BASE;

        while(blocksInCurrentLine!=0||isItEnoughSpace(blocksInCurrentLine)){
            drawLine(blocksInCurrentLine);
            blocksInCurrentLine--;
        }


    }

    private boolean isItEnoughSpace(int blocksInCurrentLine) {
        int currentLineNumer=BRICKS_IN_BASE-blocksInCurrentLine+1;
        double currentY=getWidth()-currentLineNumer*BRICK_HEIGHT-(currentLineNumer-1)*SIZE_OF_LINE_BETWEEN_BRICKS;
        if(currentY>=BRICK_HEIGHT)
           return true;
        else
            return false;
    }


    private void drawLine(int blocksInCurrentLine) {
        double x = findLineStartX(blocksInCurrentLine);
        double y = findLineStartY(blocksInCurrentLine);
        for (int i=0; i<blocksInCurrentLine; i++) {
            drawBrick(x, y);
            x=x+BRICK_WIDTH+SIZE_OF_LINE_BETWEEN_BRICKS;
        }
    }

    private double findLineStartY(int blocksInCurrentLine) {
        double y;
        y=getHeight()-(BRICKS_IN_BASE-blocksInCurrentLine+1)*BRICK_HEIGHT;
        return y;
    }

    private double findLineStartX(int blocksInCurrentLine) {
        double x;
        x=getWidth()/2-blocksInCurrentLine*BRICK_WIDTH/2-(blocksInCurrentLine-1)*SIZE_OF_LINE_BETWEEN_BRICKS/2;
        return x;
    }

    private void drawBrick(double x, double y) {
        GRect brick=new GRect(x,y, BRICK_WIDTH, BRICK_HEIGHT);
        brick.setFilled(true);
        brick.setFillColor(new Color(216, 70, 14));
        add(brick);
    }
}