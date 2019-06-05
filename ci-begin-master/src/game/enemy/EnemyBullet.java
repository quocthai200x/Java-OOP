package game.enemy;

import game.GameObject;
import game.Settings;
import game.Vector2D;
import game.physics.BoxCollider;
import game.player.Player;
import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;



public class EnemyBullet extends GameObject {
    public  int damage;
    public  EnemyBullet(){
        image = SpriteUtils.loadImage("assets/images/enemies/bullets/cyan.png");
        velocity.set(1,1);
        damage = 1;
        hitBox = new BoxCollider(this,16,16);

    }

    @Override
    public void run() {
        super.run();
        if (position.x>Settings.BACKGROUND_WIDTH-16|| position.x<0 ){
            this.deactive();
        }
        this.checkPlayer();
    }

    private void checkPlayer() {
        Player player = GameObject.findIntersects(Player.class,this.hitBox);
        if(player != null){
            // deactive enemy
            // deactive playerBullet ~ this
            player.takeDamage(damage);
            this.deactive();
        }
    }



}
