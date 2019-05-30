package game;

import tklibs.Mathx;
import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {
    Player player;
    Enemy enemy;
    Background background;
    double fps;
    public GamePanel() {
        player = new Player();
        background = new Background();
        enemy = new Enemy();
        fps = 0;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, 800, 600);
        background.render(g);
        player.render(g);
        enemy.render(g);
        g.setColor(Color.black);
        g.drawString("fps :" + fps, 700, 50);


    }

    public void runAll() {
        background.run();
        enemy.run();
        player.run();
    }


    public void gameloop() {
        long lastTime = 0;
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
