import game.Vector2D;

import javax.print.DocFlavor;

public class Rectangle {
    public Vector2D position;
    public  int width;
    public int height;
    public  Rectangle(Vector2D position,int width,int height){
        this.position = position;
        this.width = width;
        this.height = height;
    }
    public  Rectangle(double x, double y , int width , int height){
        this(new Vector2D(x,y),width,height);
    }
    public double top(){
        return position.y;
    }
    public double bot(){
        return top()+height;
    }
    public double left(){
        return position.x;
    }
    public  double right(){
        return  width + left();
    }
    public  boolean intersects(Rectangle other){
        return  other.right()>=this.left()
                && other.left() <= this.right()
                && other.bot() >= this.top()
                && other.top() <= this.bot();

    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(0,0,1,1);
        Rectangle r2 = new Rectangle(1,1,2,2);
        System.out.println(r1.intersects(r2));
    }
}
