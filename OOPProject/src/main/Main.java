package main;

import javax.swing.*;

public class Main extends JFrame {

    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("OOPGAME ADVENTURE");

        GamePanel gamePanel = new GamePanel();
        gamePanel.startGameThread();
        window.add(gamePanel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}