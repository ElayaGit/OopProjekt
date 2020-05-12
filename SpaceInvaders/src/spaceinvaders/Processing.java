
package spaceinvaders;

import processing.core.*;
public class Processing extends PApplet{
    PImage spaceship;
    int y;
    int x;
    int xSpeed;
    @Override
    public void settings(){
        size(1900, 900);
    }
    
    @Override
    public void setup(){
        background(000);
        
        spaceship = loadImage("images/space2.png");
        x = 800;
        y = 530;
        xSpeed = 3;
    }
    
    @Override
    public void draw(){
    System.out.println("X:" + x + "y:" + y);
        if (keyPressed && keyCode == LEFT) {
            x -= 5;
            background(0);
        }
        if (keyPressed && keyCode == RIGHT) {
            x += 5;
            background(0);
        }
        if (x >= 1600) {
            x = 1;
        }
        if (x <= 0) {
            x = 1500;
        }
        image(spaceship, x, y, 300, 300);
        
    }

}
