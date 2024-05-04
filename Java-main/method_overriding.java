// Runtime polymorphism
// differenct class not require inheritance

class A{
    void m1(int x){
        System.out.println(x);
    }
}
class method_overriding extends A{

    void m1(int x){
        super.m1(222222);
        System.out.println(x);
    }

    public static void main(String[] args) {
        // A ob = new A();
        // ob.m1(111);
         
        method_overriding obj = new method_overriding();
        obj.m1(213);

        // obj.m1(123);
    }
}


   
