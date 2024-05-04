public class Static_variable
{
    int a = 100;  
    static int b = 20;

    int _te_s$t = 10;
 

     public static void main(String[] args) {
        // static int c = 20; error as local variable should be non static 
        Static_variable obj = new Static_variable();
        b o1 = new b();
        o1.demo();
        // dkd di = new dkd();
        dkd di = obj.new dkd();
        di.ms();
        System.out.println(obj._te_s$t);
        // System.out.println(obj.b);// need to create obj to call instance variable
        // System.out.println(Static_variable.b); // static var can access by class name 
        // System.out.println(b); //static can be access by directly ,by class name and by object
    }

    public class dkd{
        void ms(){
            System.out.println("SDfsdf");
        }
       
    }
}
class b{
    void demo(){
        System.out.println("dsfsdfsdfsdf");
        // System.out.println(Static_variable.b);
    }
}

//static variable shares it value to all object copy like company name is same for all emp then make it static 
// will  share with all object 