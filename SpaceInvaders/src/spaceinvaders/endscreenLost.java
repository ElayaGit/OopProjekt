package spaceinvaders;
import processing.core.*;
import controlP5.*;

public class endscreenLost extends PApplet {

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
        font = createFont("ethnocentric/ethnocentric rg it.ttf", 30);
        bg = loadImage("images/endscreenIMGLost.png");

        cp5 = new ControlP5(this);



        cp5.addBang("retry")
            .setCaptionLabel("")
            .setPosition(button_x1, button_y1)
            .setColorBackground(color(c))
            .setSize(button_x2, button_y2)
            .setColorForeground(color(c))
            .setColorActive(cHover);


        cp5.addBang("exitGame")
            .setCaptionLabel("")
            .setPosition(button_x1, button_y1 + 200)
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
        exitButton();

    }

    public void retryButton() {

        fill(255);
        textSize(40);
        textFont(font);
        text("retry", button_x1 + 60, button_y1 + 60);
    }

    public void exitButton() {

        fill(255);
        textSize(40);
        textFont(font);
        text("Exit", button_x1 + 80, button_y1 + 260);
    }

    /**
    Opens a new game
    */
    public void retry() {

        openGame();

    }

    /**
    exits te Game
    */
    public void exitGame() {

        exit();

    }
    /*
    the openGame Method if for opening the game useing Processing
    */
    public void openGame() {
        Processing.main("spaceinvaders.Button");
    }
}