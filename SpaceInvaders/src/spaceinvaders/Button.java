package spaceinvaders;

import processing.core.*;
import controlP5.*;

/**
this is the Main menu
it appears the moment you start the program

*/
public class Button extends PApplet {

    ControlP5 cp5;
    String text;
    PFont font;
    String user = "userName";
    //background Image
    PImage bg;
    //position for the button
    int button_x1 = 200;
    int button_x2 = 90;
    int button_y1 = 400;
    int button_y2 = 80;

    //color
    int c = color(0, 0, 0, 198);
    int cPlus = color(0, 0, 0, 255);
    int cHover = color(0, 0, 0, 180);

    public int time = 10;

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



//30 Seconds 
        cp5.addBang("play30s")
            .setCaptionLabel("")
            .setPosition(button_x1, button_y1+100)
            .setColorBackground(color(c))
            .setSize(button_x2, button_y2)
            .setColorForeground(color(c))
            .setColorActive(cHover); 

       


//60 Seconds 
        cp5.addBang("play60s")
            .setCaptionLabel("")
            .setPosition(button_x1 + button_x2+20, button_y1+100)
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
        textDraw("PLAY",button_x1+40,button_y1+80);
        textDraw("30",button_x1+15,button_y1+150);
        textDraw("60",button_x1+125,button_y1+150);
        //getUsername();
        // System.out.println("X: "+mouseX+"Y: "+mouseY);
    }


    /******************************************************************************/
    //Methods
/**
the button method is for the text "inside" the submit button
*/
    public void textDraw(String text,int posX,int posY) {

        fill(255);
        textSize(40);
        textFont(font);
        text(text, posX,posY);
    }


/*
the openGame Method if for opening the game useing Processing
*/
    public void openGame() {
        Processing.main("spaceinvaders.Processing");
    }

/*
if the mouse button is pressed it checks if the click is within the button 
then it opens the game and gets the Username
*/


    public int play30s() {
        if(getUsername().length() >= 1 ){
            openGame();
            this.time = 31;
        
        }
        return time;
}

    public int play60s() {
        if(getUsername().length() >= 1 ){
            openGame();
            this.time = 61;
        }
        return time;
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