
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
        y = 400;
        xSpeed = 3;
    }
    
    @Override
    public void draw(){
    /*int i = 800;
    do{
        image(spaceship, i++, 510);
    }while(keyPressed);
        */
    if(x >= 900) xSpeed = -xSpeed;
    if(x <= 100) xSpeed = -xSpeed;
    
    x = x + xSpeed;
    
    image(spaceship, x, y, 300, 300);
            
    }
    
    
    

}
