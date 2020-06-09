package spaceinvaders;

import processing.core.*;

public class enemyClass {

    public int enemyX;
    public int enemyY;

    public String enemy1 = "images/space3.png";
    public String enemy1expl = "images/space3expl.png";

    public String enemy2 = "images/space4.png";
    public String enemy2expl = "images/space4expl.png";

    public String enemy3 = "images/space5.png";
    public String enemy3expl = "images/space5expl.png";


    public enemyClass(int enemyX, int enemyY) {

        this.enemyX = enemyX;
        this.enemyY = enemyY;

    }

}