package spaceinvaders;

import processing.core.*;

public class Processing extends PApplet {

// spaceship
    PImage spaceship;
    int y;
    int x;
// enemy 
    PImage enemy;
    int z;
    int w;

//score
    int scoreX = 100;
    int scoreY = 100;
    int scoreX1 = 100;
    int scoreY1 = 100;
    int xSpeed;

    @Override
    public void settings() {
        size(1900, 900);
    }

    @Override
    public void setup() {
        background(000);
        spaceship = loadImage("images/space2.png");
        x = 800;
        y = 530;
        xSpeed = 3;
        
            enemy = loadImage("images/space3.png");
            z = 800;
            w = 200;
        
    }

/**
displays the score
*/
    public void Score() {
        textSize(50);
        int cnt = 0;
        text("Score: "+cnt, scoreX, scoreY);
       
        
    }

    @Override
    public void draw() {

        //System.out.println("X:" + x + "y:" + y);
//move left
        if (keyPressed && keyCode == LEFT) {
            x -= 5;
            background(0);
        }
//move right
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
        image(enemy, z, w, 140, 100);
        Score();

    }

}
