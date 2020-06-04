package spaceinvaders;
import java.util.Random;
import processing.core.*;

public class Processing extends PApplet {
    

    PImage background;
    PFont font;
    // spaceship
    PImage spaceship1;
    spaceshipClass shipC = new spaceshipClass(800, 650,"images/space1.png");

    // enemy 
    PImage enemyIMG,enemyIMGexpl;
    enemyClass enemyC = new enemyClass(800, 200);

    //laser
    PImage laser;
    laserClass laserC = new laserClass(10, 900,"images/laser.png");

    //score
    scoreClass scoreC = new scoreClass(30, 100, 0);

    //button
    Button button = new Button();

    // is shot
    boolean isShot = false;

    //score
    boolean cntup = false;

    //last pos of ship
    int lastPosX = 0;

    //for the fire animation
    boolean changeShip;


    @Override
    public void settings() {
        size(1900, 900);
    }

   
    @Override
    public void setup() {

        //spaceship
        spaceship1 = loadImage(shipC.spaceshipPath);
       
        //enemy
        enemyIMG = loadImage(enemyC.enemy1);
        enemyIMGexpl = loadImage(enemyC.enemy1expl);

        //laser
        laser = loadImage(laserC.laserPath);
        

        //background
        background = loadImage("images/backgroundIMG.png");

        background(background);
    }

    @Override
    public void draw() {

        //prints out the position of the spaceship
        //System.out.println("X" + shipC.shipX + "Y" + shipC.shipY);

        //move method is called to move the spaceship
        move();
        // shoot method iscalled to shoot a bullet
        shoot();
        
            image(spaceship1, shipC.shipX, shipC.shipY, 150, 150);
          
       
    }

    /******************************************************************************/

    //methodes

    public void shoot() {
        
        if (keyPressed && key == 32) {
            //for (int i = shipC.shipY; i > 0; i--) {
                //bullet
                //delay(1);
                image(laser, shipC.shipX + 70, -110, laserC.laserWidth, laserC.laserHeight);
                //System.out.println(i);
            //}

           //delay(1000);
            if (shipC.shipX + 70 > enemyC.enemyX + 30 && shipC.shipX + 70 < enemyC.enemyX + 100) {
               //change enemy to dead
                image(enemyIMGexpl, enemyC.enemyX, enemyC.enemyY, 140, 100);
                isShot = true;
                cntup = true;
            }


        }

        if (isShot) {
            
            if (cntup) {
                lastPosX = shipC.shipX;
                enemyC.enemyX = (int)(Math.random() * 800 + 300);
            
                //img ändern bei gewissem score und endsrceen
                if (scoreC.cnt == 0) {
                    enemyIMG = loadImage(enemyC.enemy2);
                    enemyIMGexpl = loadImage(enemyC.enemy2expl);
                    background = loadImage("images/backgroundIMG2.png");
                }

                if (scoreC.cnt == 1) {
                    enemyIMG = loadImage(enemyC.enemy3);
                    enemyIMGexpl = loadImage(enemyC.enemy3expl);
                    background = loadImage("images/backgroundIMG3.png");
                }
                if (scoreC.cnt == 2){
                    shipC.shipY = -1000;
                    enemyC.enemyY = -1000;
                    openEnd();
                }

                scoreC.cnt++;
                cntup = false;
            }

            
        }
        
        displayScore();
        
        
        //wenn sich das raumschif wieder bewegt wird ein neuer gegner gesetzt
        if(shipC.shipX != lastPosX){
            image(enemyIMG, enemyC.enemyX, enemyC.enemyY, 140, 100);
        }
}
    /**
    displays the score
    because of the text it is not posible to change the score in the score class
    */
    public void displayScore() {
        font = createFont("ethnocentric", 30);
        int scoreColor = color(255, 215, 0, 256);
        fill(0);
        rect(6, 6, 290, 160);
        fill(scoreColor);
        textSize(50);
        textFont(font);
        text("Score: " +scoreC.cnt, scoreC.scoreX, scoreC.scoreY);
    }
// +button.getUsername()

    /**
    moves the spaceShip
    */
    public void move() {


        //move left

        if (keyPressed && keyCode == LEFT) {
            shipC.shipX -= 5;
            background(background);
        }

        //move right

        if (keyPressed && keyCode == RIGHT) {
            shipC.shipX += 5;
            background(background);
        }

        //  move to the other side 

        if (shipC.shipX >= 1600) {
            shipC.shipX = 1;
        }
        if (shipC.shipX <= 0) {
            shipC.shipX = 1500;
        }

    }


/**
opens the end screen
*/
     public void openEnd() {
        Processing.main("spaceinvaders.endscreen");
    }


}