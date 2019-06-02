package game;

import java.awt.*;
import java.awt.font.GlyphMetrics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    //quan li doi tuong (khai bao static)
    public static ArrayList<GameObject> objects = new ArrayList<>();
    public static  void  renderAll(Graphics g){
        for (int i = 0; i < objects.size() ; i++) {
            GameObject object = objects.get(i);
            object.render(g);
        }
    }

    public  static void runAll(){
        for (int i = 0; i <objects.size() ; i++) {
            GameObject object = objects.get(i);
            object.run();
        }
    }

    //dinh nghia doi tuong
    public BufferedImage image;
    public Vector2D position;
    public  GameObject(){
        objects.add(this);
        System.out.println(objects.size());
        position = new Vector2D(); //(0,0)

    }
    public void  render(Graphics g){
        if(image != null){
            g.drawImage(image,(int)position.x,(int)position.y,null);
        }
    }
    public void run(){

    }
}
