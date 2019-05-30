package game;

import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy {
    BufferedImage image;
    Vector2D position;
    ArrayList<EnemyBullet> bullets;
    public Enemy(){
        image = SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png");
        position = new Vector2D(Mathx.random(0,360),0);
        bullets = new ArrayList<>();
    }
    public  void render(Graphics g){

        g.drawImage(image,(int)position.x,(int)position.y,null);
        for(int i =0;i<bullets.size();i++){
            EnemyBullet  bullet = bullets.get(i);
            bullet.render(g);
        }
    }
    public void run(){
        this.move();
        this.bulletsRun();
        this.fire();
    }
    int count = 0;
    private void fire() {
        count ++;
        if(count> 20){
            EnemyBullet bullet = new EnemyBullet();
            bullet.position.set(this.position.x, this.position.y);
            bullets.add(bullet);
            count = 0;
        }

    }

    private void bulletsRun() {
        for(int i = 0;i<bullets.size();i++){
            EnemyBullet bullet = bullets.get(i);
            bullet.run();

        }
    }

    private void move() {
        position.y ++;
        if(position.y > 600){
            position.y = -50;
            position.x = Mathx.random(0,360);
        }
    }
}
