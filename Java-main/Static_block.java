// it execute automatic when class load into memory

// used to initialze static variable


public class Static_block {

    static int a;

    static void m1(){
        System.out.println("afdfsdfsf");    

    }
    static{
        a = 200;
        m1();
        // System.out.println("afdfsdfsf");    
    }

    public static void main(String[] args) {
        System.out.println(a);    
    }
    
}
