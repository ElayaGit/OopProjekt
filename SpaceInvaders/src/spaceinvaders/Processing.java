package spaceinvaders;
import processing.core.*;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Processing extends PApplet {
    
    PImage background;
    PFont font;

    int sec = second();
    int plusSec = 60;
    int plusSecNum = 0;
    int storeS = 0;
    int level = 1;
    int scoreColor = 0;
    String user = "userN";

    // spaceship
    PImage spaceship1;
    spaceshipClass shipC = new spaceshipClass(800, 650,"images/space1.png",10);

    // enemy 
    PImage enemyIMG,enemyIMGexpl,enemyIMG2,enemyIMGexpl2;
    enemyClass enemyC = new enemyClass(800, 200);
    enemyClass enemyC2 = new enemyClass(400, 240);

    //laser
    PImage laser;
    laserClass laserC = new laserClass(10, 900,"images/laser.png");

    //score
    scoreClass scoreC = new scoreClass(30, 100, 0);

    //button
    Button buttonC = new Button();

    // is shot
    boolean isShot = false;

    //score
    boolean cntup = false;

    //last pos of ship
    int lastPosX = 0;
    
    //for the fire animation
    boolean changeShip;
    
    //checks if the game is won in order to open the endscreen only one time 
    boolean won = false;
    //second ship
    boolean secondShip = false;
    
    //checks if the game has ended
    boolean endGame = false;

    public Processing(){
    }

    @Override
    public void settings() {
        size(1900, 900);
    }
   
    @Override
    public void setup() {
        
        font = createFont("ethnocentric/ethnocentric rg it.ttf", 30);
        scoreColor = color(255, 215, 0, 256);

        //spaceship
        spaceship1 = loadImage(shipC.spaceshipPath);
       
        //enemy
        enemyIMG = loadImage(enemyC.enemy1);
        enemyIMGexpl = loadImage(enemyC.enemy1expl);
        
        //enemy 2
        enemyIMG2 = loadImage(enemyC2.enemy1);
        enemyIMGexpl2 = loadImage(enemyC2.enemy1expl);

        //laser
        laser = loadImage(laserC.laserPath);
        
        //background
        background = loadImage("images/backgroundIMG.png");

        background(background);
        lvl();
    }

    @Override
    public void draw() {

    if(!endGame){
        // move method is called to move the spaceship
        move();
        // shoot method iscalled to shoot a bullet
        shoot();
        // counts and displys the seconds
        time();
        //draws the spaceship
        image(spaceship1, shipC.shipX, shipC.shipY, 150, 150); 
        System.out.println(buttonC.user);
    }
}
    
        
    /******************************************************************************/

    //methodes

/**
the method is for shooting 
it is called in the draw method
*/
    public void shoot() {
        
        if (keyPressed && key == 32) {
            //the laser beam is drawn 
            image(laser, shipC.shipX + 70, -110, laserC.laserWidth, laserC.laserHeight);

            //collition detection
            if (shipC.shipX + 70 > enemyC.enemyX + 30 && shipC.shipX + 70 < enemyC.enemyX + 100) {

               //change enemy to dead
                isShot = true;
                cntup = true;   
                playMusic("src/sounds/shoot_01.wav");

            }
           
        }

        //checks if the ship is shot
        if (isShot) {
            
            if (cntup) {
            playMusic("src/sounds/boom.wav");
                image(enemyIMGexpl, enemyC.enemyX, enemyC.enemyY, 140, 100);
            //enemyIMG = loadImage(enemyC.enemy1expl);
                lastPosX = shipC.shipX;
                enemyC.enemyX = (int)(Math.random() * 800 + 300);

            //img changes due to counter
                if (scoreC.cnt == 3) {
                    enemyIMG = loadImage(enemyC.enemy2);
                    enemyIMGexpl = loadImage(enemyC.enemy2expl);
                    background = loadImage("images/backgroundIMG2.png");
                    this.level++;
                    lvl();
                    shipC.speed = 15;
                }

                if (scoreC.cnt == 5) {
                    enemyIMG = loadImage(enemyC.enemy3);
                    enemyIMGexpl = loadImage(enemyC.enemy3expl);
                    background = loadImage("images/backgroundIMG3.png");

                   // enemyIMG2 = loadImage(enemyC2.enemy3);
                   // enemyIMGexpl2 = loadImage(enemyC2.enemy3expl);
                   // secondShip = true;
                    this.level++;
                    lvl();
                    shipC.speed = 20;
                }
            //as soon as the player reaches a score the game stops and the player won
                if (scoreC.cnt == 8){
                    shipC.shipY = -1000;
                    enemyC.enemyY = -1000;
                    openEndWon();
                    won = true;
                }
                
            //wenn die zeit aus ist dann wird das du hast verlohren ausgegeben

                scoreC.cnt++;
                cntup = false;
            }

            isShot = false;
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
        
        
        fill(0);
        rect(6, 6, 290, 160);
        fill(scoreColor);
        textSize(50);
        textFont(font);
        
        text("Score: " +scoreC.cnt, scoreC.scoreX, scoreC.scoreY);
    }
// +button.getUsername()

/**
displays the level your are playing
*/
    public void lvl(){
            textFont(font);
            fill(scoreColor);
            String lvlSring = "LEVEL"+level+"\n MOVE";    
            text(lvlSring, 800, 400);
            lvlSring = " ";
            delay(1000);
            text(lvlSring, 800, 400);
                
    }
    /**
    moves the spaceShip
    */
    public void move() {

        //move left

        if (keyPressed && keyCode == LEFT) {
            shipC.shipX -= shipC.speed;
            background(background);
        }

        //move right

        if (keyPressed && keyCode == RIGHT) {
            shipC.shipX += shipC.speed;
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
this method checks the seconds and if certain time has passed thegame stopes => the player lost
we get the seconds using second() and subracting the start time. 
if the seconds reached 59 it sets back to 0 so we have to add 60 seconds to every minute that passes
the diff is shown in the top right corner
*/
    public void time(){
            
            int s = second();
            int diff = s - sec + (plusSecNum * plusSec);
            this.storeS = diff;
            text(diff , 10, 28);

            if(s == 0 && s % 60 == 0){
                this.plusSecNum++;
                delay(1000);
            }

            
        if (this.storeS >= 60 && !won){
                    shipC.shipY = -1000;
                    enemyC.enemyY = -1000;
                    openEndLost();
                    delay(500000);
                }
        }

    public void playMusic(String musicLocation) {
        try {
            File file = new File(musicLocation).getAbsoluteFile();
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);

            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



/**
opens the end screen
*/
     public void openEndWon() {
       
        endGame = true;
        Processing.main("spaceinvaders.endscreen");
    }
        
    public void openEndLost() {
        endGame = true;
        Processing.main("spaceinvaders.endscreenLost");
        
    }

}