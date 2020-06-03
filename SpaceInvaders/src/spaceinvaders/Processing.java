package spaceinvaders;

import processing.core.*;
//import processing.sound.*;
public class Processing extends PApplet {

// spaceship
    PImage spaceship;
    int y = 700;
    int x = 800;

// enemy 
    PImage enemyIMG;
    enemy enemyC = new enemy(800, 200);

//laser
    PImage laser;
    laserClass laserC = new laserClass(10, 100);


//score
    int scoreX = 100;
    int scoreY = 100;
    int scoreX1 = 100;
    int scoreY1 = 100;


    // is shot
    boolean isShot = false;

    //score
    boolean cntup = false;
    int cnt = 0;


    @Override
    public void settings() {
        size(1900, 900);
    }

    @Override
    public void setup() {
        background(0);
//spaceship
        spaceship = loadImage("images/space2.png");

        
        
//enemy
        enemyIMG = loadImage("images/space3.png");

        
//laser
       laser = loadImage("images/laser.png");
      
    }

/**
displays the score
*/
    public void Score() {
        textSize(50);
        text("Score: "+cnt, scoreX, scoreY);
         
    }

    @Override
    public void draw() {

    System.out.println("X"+x+"Y"+y);



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

//  move to the other side 
        if (x >= 1600) {
            x = 1;
        }
        if (x <= 0) {
            x = 1500;
        }

// shoot
        if (keyPressed && key == 32) {

            int bulletX1 = x;
            int bulletX2 = 100;
            int bulletY1 = y;
            int bulletY2 = 200;
            
           for(int i = y; i>0; i--){
                  //bullet
                delay(1);
                //background(0);
                //rect(x+70,i,10,100); 
                image(laser,x+70,i,laserC.laserWidth,laserC.laserHeight);
                System.out.println(i);
               // background(0);
            }
            if(x+70 > enemyC.enemyX && x+70 < enemyC.enemyX+140){
                isShot = true;
                cntup = true;
            }
           
           
        }

        if(isShot){
        enemyC.enemyX = enemyC.enemyX-1000;
        enemyC.enemyY = enemyC.enemyY-1000;
            image(enemyIMG, enemyC.enemyX, enemyC.enemyY, 0, 0);
           // background(0);
          
            if(cntup){
                cnt++;
                cntup = false;
            }
            
            //delay(1000);
            //background(0);
        }else{
            image(enemyIMG, enemyC.enemyX, enemyC.enemyY, 140, 100);
        }
        Score(); 
        image(spaceship, x, y, 150, 150);
        

    }

    public void bullet(){
        //int bulletX1 = x;
        //int bulletX2 = 100;

        //int bulletY1 = y;
        //int bulletY2 = 200;
   
    }




}
