
package spaceinvaders;

import processing.core.*;
public class Button extends PApplet{
    PImage my_image;
    int button_x1 = 300;
    int button_y1 = 300;
    int button_x2 = 800;
    int button_y2 = 400;
    
    @Override
    public void settings(){
        size(800, 800);
    }
    
    @Override
    public void setup(){
        
    }
    
    @Override
    public void draw(){
        button();
    }
    public void button(){
        fill(0, 0, 0);
        rect(button_x1, button_y1, button_x1, button_x2 - button_y2 - button_y1);
        fill(255);
        text("New Game", button_x1 + 20, button_y1 + 44);
        textSize(40);
    }
    void openGame(){
        int x = 300;
        int y = 300;
        Processing.main("spaceinvaders.Processing");
    }
    
    public void closeMenu(){
        
    }
    public void mousePressed(){
        if(mouseX > button_x1 && mouseX < button_x2 && mouseY > button_y1 && mouseY < button_y2){
            openGame();
            
        }
    }
     
}
