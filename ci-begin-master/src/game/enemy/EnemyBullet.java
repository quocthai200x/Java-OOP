package game.enemy;

import game.GameObject;
import game.Settings;
import game.Vector2D;
import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemyBullet extends GameObject {

    public  EnemyBullet(){
        image = SpriteUtils.loadImage("assets/images/enemies/bullets/cyan.png");
    }

    public void run(){
        position.y += position.speedY;
        position.x += position.speedX;
    }

}
