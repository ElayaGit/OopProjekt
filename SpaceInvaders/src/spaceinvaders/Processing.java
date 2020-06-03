package spaceinvaders;

import processing.core.*;
//import processing.sound.*;
public class Processing extends PApplet {

    // spaceship
    PImage spaceship;
    spaceshipClass shipC = new spaceshipClass(800, 700);

    // enemy 
    PImage enemyIMG;
    enemyClass enemyC = new enemyClass(800, 200);

    //laser
    PImage laser;
    laserClass laserC = new laserClass(10, 100);

    //score
    scoreClass scoreC = new scoreClass(100, 100, 0);

    // is shot
    boolean isShot = false;

    //score
    boolean cntup = false;



    @Override
    public void settings() {
        size(1900, 900);
    }

    @Override
    public void setup() {
        background(0);

        //spaceship
        spaceship = loadImage("images/space2.png");
        //shipC.setup();
        //enemy
        enemyIMG = loadImage("images/space3.png");
        //laser
        laser = loadImage("images/laser.png");


    }

    @Override
    public void draw() {

        //prints out the position of the spaceship
        //System.out.println("X" + shipC.shipX + "Y" + shipC.shipY);

        //move method is called to move the spaceship
        move();

        // shoot method iscalled to shoot a bullet
        shoot();

    }

    /******************************************************************************/

    //methodes

    public void shoot() {
        if (keyPressed && key == 32) {

            for (int i = shipC.shipY; i > 0; i--) {
                //bullet
                delay(1);
                image(laser, shipC.shipX + 70, i, laserC.laserWidth, laserC.laserHeight);
                System.out.println(i);
            }

            delay(1000);
            if (shipC.shipX + 70 > enemyC.enemyX && shipC.shipX + 70 < enemyC.enemyX + 140) {
                isShot = true;
                cntup = true;
            }


        }

        if (isShot) {
            enemyC.enemyX = enemyC.enemyX - 1000;
            enemyC.enemyY = enemyC.enemyY - 1000;
            image(enemyIMG, enemyC.enemyX, enemyC.enemyY, 0, 0);

            if (cntup) {
                //img ändern bei gewissem score
                if (scoreC.cnt == 1) {
                    //img ändern
                }

                scoreC.cnt++;
                cntup = false;
            }

            //delay(1000);
            //background(0);
        } else {
            image(enemyIMG, enemyC.enemyX, enemyC.enemyY, 140, 100);
        }

        displayScore();
        image(spaceship, shipC.shipX, shipC.shipY, 150, 150);


    }
    /**
    displays the score
    because of the text it is not posible to change the score in the score class
    */
    public void displayScore() {
        fill(0);
        rect(0, 0, 300, 300);
        fill(255);
        textSize(50);
        text("Score: " + scoreC.cnt, scoreC.scoreX, scoreC.scoreY);
    }
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
            background(0);
        }

        //move right

        if (keyPressed && keyCode == RIGHT) {
            shipC.shipX += 5;
            background(0);
        }

        //  move to the other side 

        if (shipC.shipX >= 1600) {
            shipC.shipX = 1;
        }
        if (shipC.shipX <= 0) {
            shipC.shipX = 1500;
        }

    }




}