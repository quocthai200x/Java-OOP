package game.player;

import game.GameObject;
import game.KeyEventPress;
import game.Settings;
import tklibs.Mathx;
import tklibs.SpriteUtils;

public class Player extends GameObject {


//    public  BufferedImage getImage(){
//        return image;
//    }
//    public  void setImage(BufferedImage image){
//        if(image == null){return;}
//        this.image = image;
//    }

    public Player() {
        image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        position.set(Settings.PLAYER_START_WIDTH, Settings.PLAYER_START_HEIGHT);
    }

    @Override
    public void run() {
        this.move();
        this.limitPosition();

        this.fire();


    }

    int count = 0;

    private void fire() {
        count++;
        if (KeyEventPress.isFirePress && count > 20) {
            PlayerBullet bullet = new PlayerBullet();
            bullet.position.set(this.position.x, this.position.y);

            count = 0;
        }
    }



    private void limitPosition() {
        position.x = Mathx.clamp(position.x, 0, Settings.BACKGROUND_WIDTH-Settings.PLAYER_WIDTH);
        position.y = Mathx.clamp(position.y, 0, Settings.GAME_HEIGHT - Settings.PLAYER_HEIGHT);
    }

    private void move() {
        if (KeyEventPress.isUpPress) {
            position.y -= Settings.PlAYER_SPEED;
        }
        if (KeyEventPress.isDownPress) {
            position.y += Settings.PlAYER_SPEED;
        }
        if (KeyEventPress.isLeftPress) {
            position.x -= Settings.PlAYER_SPEED;
        }
        if (KeyEventPress.isRightPress) {
            position.x += Settings.PlAYER_SPEED;
        }

    }
}
