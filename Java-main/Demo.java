class test {
    void m1(){
        System.out.println("M1");
    }
}
class Demo extends test{
    void m1(){
        System.out.println("M2");
    }

    public static void main(String[] args) {
        Demo obj = new Demo();
        obj.m1();
    }
}
