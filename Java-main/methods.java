class methods {
    static int i = 10;
    static void demo(){
       
        System.out.println(i);
        args(234, 23423);
        System.out.println("simple method");
    }

    static void args(int a,int b){
        int c = a*b;
        System.out.println(c);
    }

    int re1(int a ,int b){
        int c = a+b;
        return c;
    }

    public static void main(String[] args) {
        methods o1 = new methods();
        methods.demo();
        m1.dp();
        o1.args(10, 20);
        System.out.println(o1.re1(10, 20));
    }
}
class m1{
    static void dp(){
        System.out.println("other classs");

    }
}