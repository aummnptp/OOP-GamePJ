
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
// import java.io.File;

import javax.imageio.ImageIO;
import java.util.Random;

class PlatformPosition {
    int x, y;
}

public class Doodle extends JPanel implements Runnable {
    final int WIDTH = 500;
    final int HEIGHT = 800;

    boolean isRunning;
    Thread thread;
    BufferedImage view, background, platform, doodle;

    PlatformPosition[] platformsPosition;
    int x = 100, y = 100, h = 150;
    float dy = 0;
    boolean right, left;

    public Doodle() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    public static void main(String[] args) {
        JFrame w = new JFrame();
        w.setResizable(false);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.add(new Doodle());
        w.pack();
        w.setLocationRelativeTo(null);
        w.setVisible(true);
    }

    @Override
    public void addNotify() {
        super.addNotify();
        if (thread == null) {
            thread = new Thread();
            isRunning = true;
            thread.start();
        }
    }
    // public BufferedImage getImage() {
    //     BufferedImage image = null;
    //     try {
    //         image = ImageIO.read(new File("img\\slime1.png"));
    //         return image;
    //     } catch (Exception ex) {
    //         ex.printStackTrace();
    //     }
    //     return image;
    // }
    public void start() {
        try {
            view = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

            background = ImageIO.read(getClass().getResource("/img/bg.png"));
            platform = ImageIO.read(getClass().getResource(""));
            doodle = ImageIO.read(getClass().getResource(""));

            platformsPosition = new PlatformPosition[20];

            for (int i = 0; i < 10; i++) {
                platformsPosition[i] = new PlatformPosition();
                platformsPosition[i].x = new Random().nextInt(500);
                platformsPosition[i].y = new Random().nextInt(800);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        dy += 0.2;
        y += dy;
        if(y > 500){
            dy = -10;
        }
    }

    public void draw() {
        Graphics2D g2 = (Graphics2D) view.getGraphics();
        g2.drawImage(background, 0, 0, WIDTH, HEIGHT, null);
        g2.drawImage(doodle, x, y, doodle.getWidth(), doodle.getHeight(), null);
        for(int i =0; i<10;i++){
            g2.drawImage(
                platform,
                platformsPosition[i].x,
                platformsPosition[i].y,
                platform.getWidth(),
                platform.getHeight(),
                null
            );
        }
        Graphics g = getGraphics();
        g.drawImage(view, x, y, WIDTH, HEIGHT, null);
        g.dispose();
    }

    @Override
    public void run() {
        try {
            requestFocus();
            start();
            while (isRunning) {
                update();
                draw();
                Thread.sleep(1000 / 60);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
