package spaceinvaders;
import java.util.Random;
import processing.core.*;
import java.util.Timer;
//import processing.sound.*;
public class Processing extends PApplet {
    Timer timer = new Timer();

    PImage background;
    PFont font;
    // spaceship
    PImage spaceship1,spaceship2;
    spaceshipClass shipC = new spaceshipClass(800, 650);

    // enemy 
    PImage enemyIMG,enemyIMGexpl;
    enemyClass enemyC = new enemyClass(800, 200);

    //laser
    PImage laser;
    laserClass laserC = new laserClass(10, 900);

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
        background(0);
        //spaceship
        spaceship1 = loadImage("images/space1.png");
       // spaceship2 = loadImage("images/space2.png");
        //shipC.setup();
        //enemy
        enemyIMG = loadImage("images/space3.png");
        enemyIMGexpl = loadImage("images/space3expl.png");
        //laser
        laser = loadImage("images/laser.png");
        //startCounter();

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

            delay(1000);
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
            
                //img ändern bei gewissem score
                if (scoreC.cnt == 9) {
                    enemyIMG = loadImage("images/space4.png");
                    enemyIMGexpl = loadImage("images/space4expl.png");
                }

                scoreC.cnt++;
                cntup = false;
            }

            //delay(1000);
            //background(0);
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
        int blueColor = color(109, 181, 211, 256);
        fill(0);
        rect(6, 6, 290, 160);
        fill(blueColor);
        textSize(50);
        textFont(font);
        text("Score: " +scoreC.cnt, scoreC.scoreX, scoreC.scoreY);
    }
// +button.getUsername()
    /** is it needet?
     */
    public void bullet() {
        //int bulletX1 = shipC.shipX;
        //int bulletX2 = 100;

        //int bulletY1 = shipC.shipY;
        //int bulletY2 = 200;

    }
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
/*
    public void startCounter(){

    
    timer.schedule(new TimerTask() {
    @Override
        public void run() {
        Processing.main("spaceinvaders.Button");
        }
    }, 2*60*1000);
    
    }
*/


}