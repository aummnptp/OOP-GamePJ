package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
// import java.awt.*;
import javax.swing.JPanel;
import java.util.Random;

import character.*;
import java.awt.event.*;
// import javax.swing.*;
class PlatformPosition{
    int x , y;
}
public class Game extends JPanel implements KeyListener{
    int gameSpeed = 30;
    long lastPress = 0;
    Dog dog = new Dog(50, 500, 50);
    Wave wave = new Wave(800, 300, 30, 40, 30, this);
	Wave[] waveSet = makeWaveSet(4);

    public Game(){
        this.setBounds(0,0,1000,600); 
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setLayout(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2  = (Graphics2D) g;
        g2.setColor(Color.RED);
        // g2.drawRect(dog.x, dog.y, dog.dogSize, dog.dogSize);
        g2.drawImage(dog.getImage(),dog.x,dog.y,dog.dogSize,dog.dogSize,null);
        g2.setColor(Color.BLACK);
        g2.drawRect(wave.x, wave.y, wave.width, wave.height);
        for(Wave wave : waveSet) {
            g2.drawRect(wave.x, wave.y, wave.width, wave.height);
            // Event.checkHit(dog, wave);
        }
    }

    private Wave[] makeWaveSet(int waveNumber) {
        Wave[] waveSet = new Wave[waveNumber];
        for(int i = 0; i < waveNumber; i++){
            double waveLocation = 1000 + Math.floor(Math.random()*1000);
            waveSet[i] = new Wave((int)waveLocation, 300, 30, 40, 30, this);
        }
        return waveSet;
    }
  
    @Override
    public void keyTyped(KeyEvent e){
        // todo
    }
    @Override
    public void keyPressed(KeyEvent e){
        // System.out.println(e.getKeyCode());
        if(System.currentTimeMillis()-lastPress>600){
            if(e.getKeyCode() == 38 || e.getKeyCode() == 32){
                dog.jump(this);
                this.repaint();
                System.out.println(e.getKeyCode());
            }
            lastPress = System.currentTimeMillis();
        }
        if(e.getKeyCode() == 65){
            dog.goLeft(this);
            this.repaint();
            System.out.println(e.getKeyCode());
        }
        if(e.getKeyCode() == 68){
            dog.goRight(this);
            this.repaint();
            System.out.println(e.getKeyCode());
        }
    }
    @Override
    public void keyReleased(KeyEvent  e){
        // dd
    }
    
}