import tklibs.SpriteUtils;


import javax.swing.*;
import java.awt.*;
import java.awt.desktop.SystemSleepEvent;
import java.awt.image.BufferedImage;

/**
 * Created by huynq on 7/4/17.
 */


public class Program {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setTitle("Game Touhou");
        window.setSize(800, 600);
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        JPanel panel = new JPanel();
        GamePanel panel = new GamePanel();
        panel.setBackground(Color.CYAN);
        window.add(panel);


        window.setVisible(true);
        panel.gameloop();

        // Phim tat : comment post Ctrl + ?
        // alt +enter :fix codde
        // shift f6 :sua het ten
        // ctrl alt l :format code


//        BufferedImage playerImage = SpriteUtils.loadImage("assets/images/players/straight/0.png");
//        System.out.println(playerImage.getWidth());
//        System.out.println(playerImage.getHeight());

    }
}


//        student student1 = new student();
//        student student2 = new student("nguyexn ajsj",11);
//        System.out.println(student1.name);
//        student1.eat();
//        System.out.println(student2.name);
//        student2.eat();
//    }
//}

//
//public class Program {
//    public static double sum(double a, double b) {
//        return a + b;
//    }

//    public  static  void sumAndPrint(double a, double b){
//        System.out.println(a+b);
//    }
//    public static void main(String[] args) {
//        int random = 9;
//        if (random >1000){
//            System.out.println("NUMBER TOO LARGE");
//        }
//        else if (random <10){
//            System.out.println("NUMBER TOO SMALL");
//
//        }
//        else{
//            System.out.println("THIS IS NUMBER: "+ random);
//        }
//
//        switch (random){
//            case 11111:{
//                System.out.println("THIS IS NUMBER 11111");
//                break;
//            }
//            case 1 :{
//                System.out.println("NUMBER 1");
//                break;
//
//            }
//        }


//        sumAndPrint(2,2222);
//        System.out.println(sum(2,5));
//        double sum = sum(10,111);
//        System.out.println(sum);
//        ................................
//        String message = "Hello world";
//        int x = 1; // byte ,short , int,long
//        double b = 2; // float
//        char c = 'x';// ascii 120
//        boolean bool = true;
//        System.out.println(message);
//        System.out.println(x);
//        System.out.println(b+c);
//        System.out.println(bool);
//        System.out.println(message + b );
//        int a = 1;
//        double b ; // số mặc định = 0
//        boolean c ; // = false
//        String s ; // = null
//
//        System.out.println(a);
//        System.out.println(b);
//        int[] array = {1, 1, 2, 7};
//        int[] array2 = new int[5];//{0,0,0,0,0}

//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);}
//        for(int i = 0;i <array2.length;i++){
//            System.out.println(array2[i]);
//        }
//        int i =0;
//        while (i<array.length){
//            System.out.println(array[i]);
//            i++;
//        }
//
//
//        }
//        public static double[] equation2(double a, double b ,double c) {
//            double delta = b * b - 4 * a * c;
//            if ( delta >= 0) {
//                double[] result = new double[2];
//                result[0] = (-b + Math.sqrt(delta))/2/a;
//                result[1] = (-b - Math.sqrt(delta))/2/a;
//                double[] resul =  new double[2];
//                resul[0] = (-b - Math.sqrt(delta))/2*a;
//                if (result[0] == result[1]){
//                    return result;
//                }
//                else{
//                    return result;
//               }
//            }
//            else{
//                return null;
//            }
//     return  null;
//
//        }
//        public  static  void main(String[] args){
//            double [] result = equation2(1,2,1);
//            if(result == null){
//                System.out.println("CANT NOT RESOLVE EQUATION");
//            }
//            else{
//                System.out.println("x1 = " + result[0] + " ; x2 = " + result[1]);
//            }
//        }
//



