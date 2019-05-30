package game;

import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player {
    BufferedImage image;
    Vector2D position;
    ArrayList<PlayerBullet> bullets;
//    public  BufferedImage getImage(){
//        return image;
//    }
//    public  void setImage(BufferedImage image){
//        if(image == null){return;}
//        this.image = image;
//    }

    public Player() {
        image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        position = new Vector2D(300, 300);
        bullets = new ArrayList<>();

    }

    public void render(Graphics g) {
        for (int i = 0; i < bullets.size(); i++) {
            PlayerBullet bullet = bullets.get(i);
            bullet.render(g);
        }
        g.drawImage(image, (int) position.x, (int) position.y, null);


    }

    public void run() {
        this.move();
        this.limitPosition();
        this.bulletsRun();
        this.fire();


    }

    int count = 0;

    private void fire() {
        count++;
        if (KeyEventPress.isFirePress && count > 20) {
            PlayerBullet bullet = new PlayerBullet();
            bullet.positon.set(this.position.x, this.position.y);
            bullets.add(bullet);
            count = 0;
        }
    }

    private void bulletsRun() {
        for (int i = 0; i < bullets.size(); i++) {
            PlayerBullet bullet = bullets.get(i);
            bullet.run();

        }
    }

    private void limitPosition() {
        position.x = Mathx.clamp(position.x, 0, 384 - 32);
        position.y = Mathx.clamp(position.y, 0, 600 - 48);
    }

    private void move() {
        if (KeyEventPress.isUpPress) {
            position.y -= 2;
        }
        if (KeyEventPress.isDownPress) {
            position.y += 2;
        }
        if (KeyEventPress.isLeftPress) {
            position.x -= 2;
        }
        if (KeyEventPress.isRightPress) {
            position.x += 2;
        }

    }
}
