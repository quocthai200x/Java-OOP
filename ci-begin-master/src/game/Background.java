package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background extends  GameObject{
    public Background(){
        image = SpriteUtils.loadImage("assets/images/background/0.png");
        position.set(0,Settings.GAME_HEIGHT - Settings.BACKGROUND_HEIGHT);
    }
    @Override
    public  void run(){
        position.y += Settings.BACKGROUND_SPEED;
        if (position.y >= 0) {
            position.y = 0;
        }
    }
}
