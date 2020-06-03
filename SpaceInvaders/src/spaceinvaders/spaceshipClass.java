package spaceinvaders;

import processing.core.*;

public class spaceshipClass extends PApplet {

    //PImage spaceship;
    public int shipX;
    public int shipY;
   
    public void setup() {
        PImage spaceship = loadImage("images/space2.png");  
    }

    public spaceshipClass(int shipX, int shipY) {

        this.shipX = shipX;
        this.shipY = shipY;

    }





}