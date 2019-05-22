public class student{
    //thuoc tinh
    String name;
    int age;
    public  student(){
        name = "NGUYEEXN VAN A";
        age = 20;
    }
    public  student(String name,int age){
        this.name = name;
        this.age = age;
    }


    // phuong thuc
    void sleep(){
        System.out.println("Sleeping...");
    }
    void eat(){
        System.out.println("Eating...");
    }
}
