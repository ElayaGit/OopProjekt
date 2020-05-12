
package spaceinvaders;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
public class surface implements ActionListener{
    
    private Button button1;
    private Button button2;

    
    public surface(){
        button1 = new Button((java.awt.event.ActionListener) this, "Start", 100, 100, 100, 40);
        button2 = new Button((java.awt.event.ActionListener) this, "Exit", 100, 200, 200, 40);
    }
    
    public void update(){
        
    }
    
    public void render(Graphics2D g){
        button1.render(g);
        button2.render(g);
    }
    
    public void mousePressed(MouseEvent e){
        button1.mousePressed(e);
        button2.mousePressed(e);
    }
    
    public void mouseReleased(MouseEvent e){
        button1.mousePressed(e);
        button2.mousePressed(e);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button1){
            System.out.println("Hello World");
        }
        
        if(e.getSource() == button2){
            System.exit(0);
        }
    }
}
