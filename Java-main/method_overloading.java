// COmpile time  polymorphism
// within class not require inheritance

public class method_overloading {
    
    void m1(String name){
        System.out.println(name);
    }

    void m2(int x){
        System.out.println(x);
    }

    public static void main(String[] args) {
        method_overloading obj = new method_overloading();
        obj.m1("rahul");
        obj.m2(123);
    }
}
