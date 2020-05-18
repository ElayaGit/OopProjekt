
package spaceinvaders;

import processing.core.*;
public class Processing extends PApplet{
    PImage spaceship;
    PImage enemy;
    int y;
    int x;
    int z;
    int w;
    int scoreX = 100;
    int scoreY = 100;
    int scoreX1 = 100;
    int scoreY1 = 100;
    int xSpeed;
    @Override
    public void settings(){
        size(1900, 900);
    }
    
    @Override
    public void setup(){
        background(000);
        
        spaceship = loadImage("images/space2.png");
        enemy = loadImage("images/space3.jpg");
        z = 800;
        w = 200;
        x = 800;
        y = 530;
        xSpeed = 3;
    }
    
    public void enemy(){
        
    }
    
    public void Score(){
        text("Score: ", scoreX, scoreY);
        textSize(50);
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
        image(enemy, x, y, 140, 100);
        Score();
    }

}
