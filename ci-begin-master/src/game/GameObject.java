package game;

import game.physics.BoxCollider;

import java.awt.*;
import java.awt.font.GlyphMetrics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    //quan li doi tuong (khai bao static)

    public static ArrayList<GameObject> objects = new ArrayList<>();

    public static <E extends GameObject> E findIntersects(Class<E> cls, BoxCollider hitBox) {
        //E ~ Enemy| Player| EnemyBullet
        //cls~ Enemy.class | Player.class | EnemyBullet.class
        //for(GameObject object :objects
        //objects.active
        //object.hitBox != null
        // object.hitBox.intersects(hitBox)
        //object la 1 doi tuong thuoc class cls
        //return object
        //neu ko tim duoc objec thoa man >> reutrn null
        for (int i = 0; i <objects.size() ; i++) {
            GameObject object = objects.get(i);
            if(object.active
                && object.hitBox != null
                && object.hitBox.intersects(hitBox)
                && cls.isAssignableFrom(object.getClass())){
                return (E) object;
            }


        }
        return  null;
    }

    public static void renderAll(Graphics g) {
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if (object.active) {
                object.render(g);
            }

        }
    }

    public static void runAll() {
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if (object.active) {
                object.run();
            }

        }
    }

    //dinh nghia doi tuong
    public BufferedImage image;
    public Vector2D position;
    public Vector2D velocity;
    public BoxCollider hitBox; // = null
    public boolean active; // = false

    public GameObject() {
        objects.add(this);
        System.out.println(objects.size());
        position = new Vector2D(); //(0,0)
        velocity = new Vector2D();
        active = true;
    }

    public void render(Graphics g) {
        if (image != null) {
            g.drawImage(image, (int) position.x, (int) position.y, null);
        }
    }

    public void run() {
        position.add(velocity.x, velocity.y);

    }

    public void deactive() {
        active = false;
    }

    public void reset() {
        active = true;
    }
}
