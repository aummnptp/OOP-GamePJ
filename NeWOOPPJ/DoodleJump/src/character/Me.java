package character;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
// import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Me {
    public boolean gameover = true;
    public int x, y, dogSize;
    private int jumpHigh = 150;
    private int walkLength = 30;

    public Me(int x, int y, int dogSize) {
        this.x = x;
        this.y = y;
        this.dogSize = dogSize;
    }

    public void jump(JPanel game) {
        
        // if (this.y == 300) {
            // this.y -= jumpHigh;
        //     // game.repaint();
        // } else {
        //     this.y += jumpHigh;
        //     // game.repaint();
        // }
        this.y -= jumpHigh;
        game.repaint();
        Timer timer = new Timer(450,new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        y += jumpHigh;
        game.repaint();
        }
        });
        timer.setRepeats(false);
        timer.start();
    }

    public void goLeft(JPanel game) {
        this.x -= walkLength;
        game.repaint();
    }

    public void goRight(JPanel game) {
        this.x += walkLength;
        game.repaint();
    }

    public BufferedImage getImage() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("img\\slime1.png"));
            return image;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return image;
    }
}
