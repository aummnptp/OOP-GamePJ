package character;

import javax.swing.*;
import java.awt.event.*;

public class Wave{

    public int x, y, width, height, speed;
    private int xStart;

    public Wave(int x, int y, int width, int height, int speed, JPanel game){
        this.x = x;
        this.xStart = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        move(game);
    }

    public void move(JPanel game) {
        Timer timer = new Timer(50, new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                x -= speed;
                game.repaint();
                if (x < 0){
                    x = xStart;
                }
            }
        });
        timer.start();
    }
}