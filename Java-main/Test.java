class test312312 {
    void m1(){
        System.out.println("M1");
    }
}
class Test extends test312312{
    void m1(){
        System.out.println("M2");
    }

    public static void main(String[] args) {
        Demo obj = new Demo();
        obj.m1();
    }
}
