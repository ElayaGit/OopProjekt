package spaceinvaders;

import processing.core.*;
import controlP5.*;

public class endscreen extends PApplet {

    ControlP5 cp5;
    String text;
    PFont font;
    String user = "user";
    PImage bg;

    int c = color(0, 0, 0, 198);
    int cPlus = color(0, 0, 0, 255);
    int cHover = color(0, 0, 0, 180);

    int button_x1 = 170;
    int button_x2 = 260;
    int button_y1 = 400;
    int button_y2 = 100;



    @Override
    public void settings() {
        size(600, 900);
    }

    @Override
    public void setup() {
        background(0);
        font = createFont("ethnocentric", 30);
        bg = loadImage("images/endscreenIMG.png");

        cp5 = new ControlP5(this);
        cp5.addTextfield("name")
            .setCaptionLabel("")
            .setPosition(200, 600)
            .setFont(font)
            .setColor(color(255))
            .setColorBackground(color(c))
            .setSize(200, 50)
            .setColorForeground(color(c))
            .setAutoClear(true)
            .setColorActive(cHover); 
        


        cp5.addBang("submit")
            .setCaptionLabel("")
            .setPosition(button_x1, button_y1)
            .setColorBackground(color(c))
            .setSize(button_x2, button_y2)
            .setColorForeground(color(c))
            .setColorActive(cHover); 
        
        background(bg);
    }

    @Override
    public void draw() {
        background(bg);
        retryButton();

    }

public void retryButton() {

        fill(255);
        textSize(40);
        textFont(font);
        text("RETRY", button_x1 + 60, button_y1 + 60);
       

}
    public void submit() {

        if ((mouseX > button_x1 && mouseX < (button_x1 + button_x2)) && (mouseY > button_y1 && mouseY < (button_y1 + button_y2))) {

            
                openGame();
            
            
        }
    }
/*
the openGame Method if for opening the game useing Processing
*/
    public void openGame() {
        Processing.main("spaceinvaders.Processing");
    }
}