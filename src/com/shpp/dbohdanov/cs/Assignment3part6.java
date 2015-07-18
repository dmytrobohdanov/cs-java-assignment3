package com.shpp.dbohdanov.cs;

import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.util.RandomGenerator;
import com.shpp.cs.a.graphics.WindowProgram;


import java.awt.*;

public class Assignment3part6 extends WindowProgram {

    public static final int APPLICATION_WIDTH = 800;
    public static final int APPLICATION_HEIGHT = 600;

    private static final double STAR_SPEED=5; //X-difference between 2 steps of star
    //private static final double STAR_DISTANCE=10;
    private static final double PAUSE=10;
   // private static final double WIDTH_OF_RECT_WITHOUT_STARS=APPLICATION_WIDTH/3;
   // private static final double HEIGHT_OF_RECT_WITHOUT_STARS=APPLICATION_HEIGHT/3;
    private static final int STAR_NUMBER=30;
    private static final int NUMBER_OF_STAR_CHARACTERISTICS =4;// [0]=x,[1]=y coordinates, [2]=k=y/x and [3]=star shape
                                                                //star shape [1..7] - mean how big the star is





    public void run() {
        double [][] stars=new double[STAR_NUMBER][NUMBER_OF_STAR_CHARACTERISTICS];
        setBackground(Color.BLACK);
        makeSomeStars(stars);

        while(true)
            moveStars(stars);

    }

    private void moveStars(double[][] stars) {
        for(int j=0; j<STAR_NUMBER; j++)
            moveOneStar(j, stars);
        pause(PAUSE);
    }

    private void moveOneStar(int j, double[][] stars) {
        GObject tempStar= getElementAt(getX_FromDekX(stars[j][0])+1, getX_FromDekY(stars[j][1])+1);
        if(stars[j][3]==7){
            makeOneNewStar(j,stars);
            stars[j][3]=1;
            remove(tempStar);
        }
        double dy = STAR_SPEED * stars[j][3];
        double dx = STAR_SPEED;
        if((getX_FromDekX(stars[j][0])+dx>=getWidth())||( getX_FromDekY(stars[j][1])+dy>=getHeight())){
            makeOneNewStar(j,stars);
            stars[j][3]=1;
            remove(tempStar);
        }
        else {
            tempStar.move(dx, dy);
            stars[j][0] = stars[j][0] + STAR_SPEED;
            stars[j][1] = stars[j][1] + STAR_SPEED * stars[j][3];
            stars[j][3]++;
        }
    }

    private void makeSomeStars(double[][] stars) {
        for (int i=0; i<STAR_NUMBER; i++)
            makeOneNewStar(i, stars);
    }

    private void makeOneNewStar(int i, double[][] stars) {
        RandomGenerator r=RandomGenerator.getInstance();
        stars[i][0]=r.nextDouble(0-getWidth()/2, getWidth()/2); //set random X to i-star
        stars[i][1]=r.nextDouble(0-getHeight()/2, getHeight()/2); //set random Y to i-star
        stars[i][2]=stars[i][1]/stars[i][0]; //k=y/x - koef to calculate next coordinate from y=kx
        stars[i][3]=0; //set iteration of star moving
        drawStar(stars[i][0], stars[i][1], stars[i][3]);
    }

    private void drawStar(double dekX, double dekY, double i) {
        GRect starPict= new GRect(getX_FromDekX(dekX), getX_FromDekY(dekY), getStarWidth(i), getStarHeight(i));
        starPict.setFilled(true);
        starPict.setFillColor(Color.WHITE);
        starPict.setColor(Color.WHITE);
        add(starPict);
    }

    private double getStarWidth(double i) {
        double n;

        switch ((int)i){
            case 1:  n=1;
            case 2:  n=2;
            case 3:  n=2;
            case 4:  n=3;
            case 5:  n=3;
            case 6:  n=4;
            case 7:  n=4;
            default: n=100;
        }
        return n;
    }
    private double getStarHeight(double i) {
        double n;
        switch ((int)i){
            case 1:  n=1;
            case 2:  n=1;
            case 3:  n=2;
            case 4:  n=2;
            case 5:  n=3;
            case 6:  n=3;
            case 7:  n=4;
            default: n=10;
        }
        return n;
    }
    private double getX_FromDekX(double dekX) {
        double x;
        x=dekX+getWidth()/2;
        return x;
    }
    private double getX_FromDekY(double dekY) {
        double y;
        y=dekY+getHeight()/2;
        return y;
    }


}