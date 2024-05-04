//can be call with class name no need to create obj


// can call only satic data ,not allowd non static 

// not allow this and super

// why need bcz not require to create obj we can call it by class name
public class Static_method {
    int i = 10;
    static void main1(){
        System.out.println("sdfsdfsfdsfs");    
    }
    public static void main(String[] args) {
        Static_method obj = new Static_method();
        Static_method.main1();
    }
}

