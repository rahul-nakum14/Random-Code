class innnn{
    void m1(){
        System.out.println("asdasdasdasd");
    }
}
class rrr extends innnn{

    void m1(){
        System.out.println("wolrd");
    }

    public static void main(String[] args) {
        innnn obj = new innnn();
        obj.m1();

        rrr oo = new rrr();
        oo.m1();
    }
}


   
