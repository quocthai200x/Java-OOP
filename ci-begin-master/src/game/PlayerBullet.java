package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerBullet {
    BufferedImage image;
    Vector2D positon;
    public  PlayerBullet(){
        image = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
        positon = new Vector2D(0,0);

    }
    public void render(Graphics g){
        g.drawImage(image,(int)positon.x,(int)positon.y,null);
    }
    public void  run(){
        positon.y -= 4;

    }
}
