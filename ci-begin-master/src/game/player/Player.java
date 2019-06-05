package game.player;

import game.GameObject;
import game.KeyEventPress;
import game.Settings;
import game.physics.BoxCollider;
import tklibs.Mathx;
import tklibs.SpriteUtils;

public class Player extends GameObject {
    public int hp;


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
        hitBox = new BoxCollider(this,32,48);
        hp =12;
    }
    public void takeDamage(int damage){
        hp -= damage;
        if(hp<=0){
            hp=0;
            this.deactive();
        }

    }

    @Override
    public void run() {
        super.run();
        this.move();
        this.limitPosition();

        this.fire();


    }

    int count = 0;

    private void fire() {
        count++;
        if (KeyEventPress.isFirePress && count > 20) {
            double startAngle = -60;
            double endAngle = -120;
            double startX = 20;
            double endX = -20;
            int numberBullet = 3;
            double stepAngle = Math.abs(endAngle - startAngle)/(numberBullet-1);
            double stepX = Math.abs(endX- startX)/(numberBullet-1);
            for (int i = 0; i <numberBullet ; i++) {
                PlayerBullet bullet = new PlayerBullet();
                bullet.position.set(this.position.x +(startX - stepX*i),this.position.y);
                bullet.velocity.setAngle( Math.toRadians(startAngle -  stepAngle * i));
                bullet.velocity.setLength(3);

            }
            count = 0;
        }
    }



    private void limitPosition() {
        position.x = Mathx.clamp(position.x, 0, Settings.BACKGROUND_WIDTH-Settings.PLAYER_WIDTH);
        position.y = Mathx.clamp(position.y, 0, Settings.GAME_HEIGHT - Settings.PLAYER_HEIGHT);
    }

    private void move() {
        double vx = 0 ;
        double vy = 0;
        if (KeyEventPress.isUpPress) {
            vy -= 2;

        }
        if (KeyEventPress.isDownPress) {
           vy += 2;

        }
        if (KeyEventPress.isLeftPress) {
            vx -= 2;
            image = SpriteUtils.loadImage("assets/images/players/left/0.png");
        }
        if (KeyEventPress.isRightPress) {
            vx += 2;
            image = SpriteUtils.loadImage("assets/images/players/right/0.png");
        }
        velocity.set(vx,vy);
        velocity.setLength(4);
        if(vx == 0 && vy ==0){
            image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        }

    }

}
