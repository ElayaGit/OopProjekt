package spaceinvaders;

import processing.core.*;
import controlP5.*;
public class spaceshipClass extends PApplet {

    public String spaceshipPath;
    public int shipX;
    public int shipY;
    public int speed;
     
 

    public spaceshipClass(int shipX, int shipY,String spaceshipPath,int speed) {
        this.shipX = shipX;
        this.shipY = shipY;
        this.spaceshipPath = spaceshipPath; 
        this.speed = speed;
    }





}