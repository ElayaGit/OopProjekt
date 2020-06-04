package spaceinvaders;

import processing.core.*;
import controlP5.*;

/**
this is the Main menu
*/
public class Button extends PApplet {

    ControlP5 cp5;
    String text;
    PFont font;
    String user = "user";
    //background Image
    PImage bg;
    //position for the button
    int button_x1 = 170;
    int button_x2 = 260;
    int button_y1 = 400;
    int button_y2 = 100;

    //color
    int c = color(0, 0, 0, 198);
    int cPlus = color(0, 0, 0, 255);
    int cHover = color(0, 0, 0, 180);


    public Button(){
    }
    @Override
    public void settings() {
        size(600, 900);
    }

    @Override
    public void setup() {
        font = createFont("ethnocentric/ethnocentric rg it.ttf", 30);
        bg = loadImage("images/menuBgf.png");

        cp5 = new ControlP5(this);

        cp5.addBang("submit")
            .setCaptionLabel("")
            .setPosition(button_x1, button_y1)
            .setColorBackground(color(c))
            .setSize(button_x2, button_y2)
            .setColorForeground(color(c))
            .setColorActive(cHover); 


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
        


        
    }

    @Override
    public void draw() {
        //calls background and the button
        background(bg);
        button();

        // System.out.println("X: "+mouseX+"Y: "+mouseY);
    }


    /******************************************************************************/
    //Methods
/**
the button method is for the text "inside" the submit button
*/
    public void button() {

        fill(255);
        textSize(40);
        textFont(font);
        text("New Game", button_x1 + 10, button_y1 + 60);
       
    }

/*
if the mouse button is pressed it checks if the click is within the button 
then it opens the game and gets the Username
*/
    public void mousePressed() {

        if ((mouseX > button_x1 && mouseX < (button_x1 + button_x2)) && (mouseY > button_y1 && mouseY < (button_y1 + button_y2))) {

            //the game will not open until a name has been entered
            if(getUsername().length() >= 1 ){
                openGame();
            }
            
        }
    }
/*
the openGame Method if for opening the game useing Processing
*/
    public void openGame() {
        Processing.main("spaceinvaders.Processing");
    }
/*
a Method that gets the Username of the player
*/
    public String getUsername() {
        user=cp5.get(Textfield.class, "name").getText();
        System.out.println(user);
        return user;
    }
}