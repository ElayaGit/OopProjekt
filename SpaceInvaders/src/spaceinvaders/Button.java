
package spaceinvaders;

import processing.core.*;
import controlP5.*;


/**
this is the Main menu
*/
public class Button extends PApplet{

    ControlP5 cp5;
    String text;
    PFont font;

    //background Image
    PImage bg;
//position for the button
    int button_x1 = 170;
    int button_x2 = 260;

    int button_y1 = 400;
    int button_y2 = 100;

    //color
  int c = color(0, 0, 0, 198); 

    @Override
    public void settings(){
        size(600, 900);
    }
    
    @Override
    public void setup(){
    bg = loadImage("images/menuBgf.png");
    cp5 = new ControlP5(this);
    cp5.addTextfield("")
                    .setPosition(200, 600)
                    .setFont(createFont("ethnocentric",20))
                    .setColor(color(255))
                    .setColorBackground(color(c))
                    .setSize(200, 50)
                    .setColorForeground(color(c))
                    .setAutoClear(true);
    font = createFont("ethnocentric", 30);
}
    
    @Override
    public void draw(){
//calls background and the button
    background(bg);
    button();



      // System.out.println("X: "+mouseX+"Y: "+mouseY);
    }
    public void button(){
      
        fill(c);

        rect(button_x1, button_y1, button_x2,button_y2);
        fill(255);
        textSize(40);
        textFont(font);
        text("New Game", button_x1 + 10, button_y1 + 60);
       
    }

    void openGame(){
        int x = 300;
        int y = 300;
        Processing.main("spaceinvaders.Processing");
    }
    
    public void closeMenu(){
        
    }
    public void mousePressed(){
            
        if((mouseX > button_x1 && mouseX < (button_x1+button_x2)) && (mouseY > button_y1 && mouseY < (button_y1+button_y2))){
            openGame();
            
        }
    }
     
}