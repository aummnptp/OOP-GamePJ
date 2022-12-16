package entity;

import main.GamePanel;
// import main.KeyHandler;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.Random;
import java.awt.Color;

import javax.imageio.ImageIO;

// import java.util.random.*;


public class Platforms extends Entity{
    // public int x, y,h;
    GamePanel gp;
    Player player;
    int x = 100, y = 100, h = 150;
    public Platforms[] platformsPosition;
    public Platforms() {
    }
    public Platforms(GamePanel gp, Player player) {

        this.gp = gp;
        this.player = player;
        setDefaultValues();
        getPlatformImage();
    }

	public void setDefaultValues() {
        x = 100;
        y = 100;
        h = 150;
    }

    public void getPlatformImage() {
        try {
            platform = ImageIO.read(getClass().getResourceAsStream("/player/platform.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){

        platformsPosition = new Platforms[20];

        for (int i=0; i < 10; i++){
            platformsPosition[i] = new Platforms();
            platformsPosition[i].x = new Random().nextInt(400);
            platformsPosition[i].y = new Random().nextInt(533);
        }

    }
    public void update() {
        
        for(int i = 0; i < 10; i++){
            if((player.x + 35 > platformsPosition[i].x)&&
            (player.x + 10 < platformsPosition[i].x + 68)&&
            (player.y + 55 > platformsPosition[i].y)&&
            (player.y + 55 < platformsPosition[i].y + 14)&&
            (player.y > 0)){
                player.fallspeed = -10;
                System.out.println(player.x);
            }
         }
        //  for(int i = 0; i < 10; i++){
        //     if((player.x + 50 > platformsPosition[i].x)&&
        //     (player.x + 20 < platformsPosition[i].x + 68)&&
        //     (player.y + 70 > platformsPosition[i].y)&&
        //     (player.y + 70 < platformsPosition[i].y + 14)&&
        //     (player.y > 0)){
        //         player.fallspeed = -10;
        //         System.out.println(player.x);
        //     }
        //  }
        //  กระโดดแล้วหน้าจอเปลี่ยน
        if(player.y<h){
            for (int i = 0; i<10;i++){
                player.y= h;
                platformsPosition[i].y = platformsPosition[i].y -(int) player.fallspeed;
                if (platformsPosition[i].y >533){
                    platformsPosition[i].y = 0;
                    platformsPosition[i].x = new Random().nextInt(408);
                }
            }
        }
            
        
    }
    public void draw(Graphics2D g2) {
        // g2.drawImage(platform, x, y, gp.tileSize, gp.tileSize, null);
        // g2.setColor(Color.white);
        // g2.fillRect(x, y, gp.tileSize, gp.tileSize);
    
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
    }
    
    public Platforms[] getPlatforms(){
        return platformsPosition;
    }
}

