package game;

import game.enemy.Enemy;
import game.player.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    Player player;
    Enemy enemy;
    Background background;
    double fps;
    public GamePanel() {

        background = new Background();
        enemy = new Enemy();
        player = new Player();
        fps = 0;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, Settings.GAME_WIDTH, Settings.GAME_HEIGHT);
        GameObject.renderAll(g);
        g.setColor(Color.black);
        g.drawString("fps :" + fps, 700, 50);


    }

    public void runAll() {
        GameObject.runAll();
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
