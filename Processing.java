
package spaceinvaders;

import processing.core.*;
public class Processing extends PApplet{
    PImage space;
    
    @Override
    public void settings(){
        size(240, 400);
    }
    
    @Override
    public void setup(){
        background(000);
        space = loadImage("Space4.png");
    }
    
    @Override
    public void draw(){
        image(space, 0, 0);
        rect(mouseX, mouseY, 20, 20);
    }
}
