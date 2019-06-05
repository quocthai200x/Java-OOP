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
import java.util.ArrayList;

public class Enemy  extends GameObject {
    public int hp;


    public Enemy(){
        image = SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png");
        position.set(Mathx.random(0, Settings.ENEMY_MAX_WIDTH),0);
        velocity.set(0,1);
        hitBox = new BoxCollider(this,34,50);
        hp = 3;


    }
    public void takeDamage(int damage){
        hp -= damage;
        if(hp <= 0){
            hp = 0;
            this.deactive();
        }
    }

    @Override
    public void run(){
        super.run();
        this.move();

        this.fire();
        this.checkEnemyxPlayer();
    }



    int count = 120;
    private void fire() {
        count++;
        if (count > 120) {
            for (double i = 1; i <= 12; i++) {


                for (int j = 0; j <6 ; j++) {
                    EnemyBullet bullet = new EnemyBullet();


                bullet.position.set(this.position.x+10, this.position.y+10);// hàm set  mới bên vector2d
                bullet.velocity.setAngle(Math.toRadians(30*i));
                bullet.velocity.setLength(4-0.3*j);
            }
            }
            count = 0;
        }

    }





    private void move() {

        if(position.y > Settings.GAME_HEIGHT){
            position.y = -50;
            position.x = Mathx.random(0,Settings.ENEMY_MAX_WIDTH);
        }
    }


    private void checkEnemyxPlayer() {
        Player player = GameObject.findIntersects(Player.class,this.hitBox);
        if(player != null){
            this.deactive();
            player.deactive();

        }
    }
}
