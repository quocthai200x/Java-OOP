import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {
    BufferedImage playerImage;
    int playerX;
    int playerY;
    BufferedImage enemyImage;
    int enemyX;
    int enemyY;


    BufferedImage backgroundImage;
    int backgroundX;
    int backgroundY;
    double fps;

    public GamePanel() {
        playerImage = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        playerX = 300;
        playerY = 300;
        backgroundX = 0;


        backgroundImage = SpriteUtils.loadImage("assets/images/background/0.png");
        backgroundY = 600 - backgroundImage.getHeight();

        enemyImage = SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png");
        enemyX = 300;
        enemyY = 20;
        fps = 0;


    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, 800, 600);

        g.drawImage(backgroundImage, backgroundX, backgroundY, null);
        g.drawImage(playerImage, playerX, playerY, null);
        g.drawImage(enemyImage, enemyX, enemyY, null);
        g.setColor(Color.black);
        g.drawString("fps :" + fps, 700, 50);


    }

    public void runAll(int i) {

        backgroundY += 10;
        if (backgroundY >= 0) {
            backgroundY = 600 - backgroundImage.getHeight();

        }
        if (i % 2 == 0) {
            enemyX = 350;
            enemyY = 10;
            if (i % 4 == 0) {
                enemyY = 30;
                enemyX = 400;
            }
        } else {
            enemyX = 250;
            enemyY = 15;
            if (i % 3 == 0) {
                enemyY = 25;
                enemyX = 200;
            }
        }

    }


    public void gameloop() {
        long lastTime = 0;
        long lasTime = 0;
        int i = 0;
        long delay = 1000 / 60;
        while (true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastTime > delay) {
                fps = 1000 / (currentTime - lastTime);
//                System.out.println(currentTime - lastTime);

                repaint();
                runAll(i);
                lastTime = currentTime;
                i++;

            }
        }

    }
}
