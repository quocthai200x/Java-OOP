package game.enemy;

import game.GameObject;
import game.Settings;
import game.Vector2D;
import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy  extends GameObject {

    public Enemy(){
        image = SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png");
        position.set(Mathx.random(0, Settings.ENEMY_MAX_WIDTH),0);

    }

    @Override
    public void run(){
        this.move();

        this.fire();
    }
    int count = 0;
    private void fire() {
        count++;
        if (count > 60) {
            for (double i = 1; i <= 12; i++) {
                Vector2D test = new Vector2D(1,1);
                Vector2D angle = test.setAngle(30*i);
                Vector2D speed = angle.setLength(4);
                EnemyBullet b = new EnemyBullet();
                b.position.set(this.position.x, this.position.y, speed.x, speed.y);// hàm set  mới bên vector2d

            }
            count = 0;
        }
    }





    private void move() {
        position.y ++;
        if(position.y > Settings.GAME_HEIGHT){
            position.y = -50;
            position.x = Mathx.random(0,Settings.ENEMY_MAX_WIDTH);
        }
    }
}
