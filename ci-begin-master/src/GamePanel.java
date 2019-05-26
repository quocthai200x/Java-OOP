import tklibs.Mathx;
import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class GamePanel extends JPanel {
    BufferedImage playerImage;

    Vector2D playerPosition;
    //Vecto2D player positon



    BufferedImage enemyImage;
    Vector2D enemyPosition;



    BufferedImage backgroundImage;
    Vector2D backgroundPosition;
    double fps;

    public GamePanel() {
        playerImage = SpriteUtils.loadImage("assets/images/players/straight/0.png");
//        playerX = 300;
//        playerY = 300;
        playerPosition =  new Vector2D(300,300);



        backgroundImage = SpriteUtils.loadImage("assets/images/background/0.png");
        backgroundPosition = new Vector2D(0,600 - 3109);

        enemyImage = SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png");
        enemyPosition = new Vector2D(Mathx.random(0,360),0);
        fps = 0;


    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, 800, 600);

        g.drawImage(backgroundImage, (int)backgroundPosition.x, (int)backgroundPosition.y, null);
        g.drawImage(playerImage, (int)playerPosition.x, (int)playerPosition.y, null);
        g.drawImage(enemyImage, (int)enemyPosition.x, (int)enemyPosition.y, null);
        g.setColor(Color.black);
        g.drawString("fps :" + fps, 700, 50);


    }

    public void runAll() {

        backgroundPosition.y += 10;
        if (backgroundPosition.y >= 0) {
            backgroundPosition.y = 600 - backgroundImage.getHeight();

        }

        enemyPosition.y ++;
        if(enemyPosition.y > 600){
            enemyPosition.y = -50;
            enemyPosition.x = Mathx.random(0,360);
        }
        //playerRun
        if(KeyEventPress.isUpPress){
            playerPosition.y-=3;
        }
        if(KeyEventPress.isDownPress){
            playerPosition.y+=3;
        }
        if(KeyEventPress.isRightPress){
            playerPosition.x+=3;
        }
        if(KeyEventPress.isLeftPress){
            playerPosition.x-=3;
        }

//        if(playerX<0){
//            playerX = 0;
//        }
//        if (playerX>384-32)playerX=384-32;
//        if(playerY<0)playerY=0;

        playerPosition.x = Mathx.clamp(playerPosition.x,0,384-32);
        playerPosition.y = Mathx.clamp(playerPosition.y,0,600-50);
    }


    public void gameloop() {
        long lastTime = 0;
        long lasTime = 0;

        long delay = 1000 / 60;
        while (true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastTime > delay) {
                fps = 1000 / (currentTime - lastTime);
//                System.out.println(currentTime - lastTime);

                repaint();
                runAll();
                lastTime = currentTime;


            }
        }

    }
}
