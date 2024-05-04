class Inheritance1 {
    void m1() {
        System.out.println("M1");
    }
}

class Inheritance123 extends Inheritance1 {
    void m2() {
        System.out.println("M2");
    }

    public static void main(String[] args) {
        Inheritance1 obj = new Inheritance1();
        obj.m1();

        Inheritance123 obj1 = new Inheritance123();
        obj1.m2();
        obj1.m1(); // You can also call the m1() method from the inherited class Inheritance1
    }
}

// public class Inheritance1 {
//     void m1(){
//         System.out.println("M1");
//     }
// }
// class Inheritance123 extends Inheritance1{
   
//     void m2(){
//         System.out.println("M2");
//     }

//     public static void main(String[] args) {
//         Inheritance1 obj = new Inheritance1();
//         obj.m1();

//         Inheritance123 obj1 = new Inheritance123();
//         obj1.m2();
//         // obj.m1();
//     }

// }