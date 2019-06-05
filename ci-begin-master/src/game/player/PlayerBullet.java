package game.player;

import game.GameObject;
import game.Settings;
import game.Vector2D;
import game.enemy.Enemy;
import game.physics.BoxCollider;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerBullet  extends GameObject {
    public int damage;


    public  PlayerBullet(){
        image = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
        velocity = new Vector2D(-0.5,-3);
        hitBox = new BoxCollider(this,24,24);
        damage =1 ;
    }

    @Override
    public void run() {
        super.run();
        if (position.x>Settings.BACKGROUND_WIDTH-10 || position.x<0 ){
            this.deactive();
        }
        this.checkEnemy();
    }

    private void checkEnemy() {
        Enemy enemy = GameObject.findIntersects(Enemy.class,this.hitBox);
        if(enemy != null){
            // deactive enemy
            // deactive playerBullet ~ this
//            enemy.deactive();
            enemy.takeDamage(damage);
            this.deactive();


        }
    }
}
