class Super{

    int a;

    Super(int a){
        this.a = a;
        System.out.println("This is A constructor"+a);
    }
}
class B extends Super{
    
    B(){
        super(10);
    }

    public static void main(String[] args) {
        B obj = new B();
        
    }
}

// class C extends B{

//     int a = 9999;

//     void show(int c){
//         System.out.println(c);
//         System.out.println(this.a);
//         System.out.println(super.a);
//     }

//     public static void main(String[] args) {
//         C obj = new C();
//         obj.show(333333333);
//     }
// }

// }
        // Call the new method with int parameter
    //     newMethod(10);
    //     main(args,3434);
     
    
//     public static void main(String[] args, int x) {
//         System.out.println("Second main() " + x);
//     }
    
//     public static void newMethod(int x) {
//         System.out.println("New method called with value " + x);
//     }
// }
