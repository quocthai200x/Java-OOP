public class Vector2D {
    public  double x;
    public double y;
    public  double rate;

    public  Vector2D(){
        this(0,0);
    }
    public Vector2D(double x,double y){
        this.x = x;
        this.y = y;
    }
    public  void  add(double x, double y){
        this.x += x;
        this.y += y;
    }
    public  void  substract(double x, double y){
        this.x -= x;
        this.y -= y;
    }
    public void  scale(double rate ){
        this.x = this.x*rate;
        this.y = this.y*rate;
    }

    public Vector2D clone(){
        return new Vector2D(x,y);
    }
    public  void set(double x,double y){
        this.x = x;
        this.y = y;
    }

    public  double getLength(){
        return Math.sqrt(x*x+y*y);
    }

    public  void  setLength(double length){
        double oldLength = this.getLength();
        if (oldLength != 0){
            x = x*length/oldLength;
            y = y*length/oldLength;
        }

    }

    public  double getAngle(){

        return Math.atan(y/x);

    }
    public  void  setAngle(double angle){
        double length = this.getLength();
        if(length != 0 ){
            x = Math.cos(angle)*length;
            y = Math.sin(angle)*length;
        }

    }

    public static void main(String[] args) { //String [] arguments
        Vector2D v1= new Vector2D(3,3);
        System.out.println(v1.getLength()+" "+Math.sqrt(18));
        System.out.println(v1.getAngle()+ " "+ (Math.PI/4));

        v1.setLength(10);
        System.out.println(v1.getLength() +" "+10);
        v1.setAngle(Math.PI/6);
        System.out.println(v1.getAngle()+" "+(Math.PI/6));
    }
}
