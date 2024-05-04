class test312312 {
    void m1(){
        System.out.println("M1");
    }
}

class lol extends test312312 {
    void m1(){
        System.out.println("M2");
    }

    public static void main(String[] args) {
        lol obj = new lol();
        obj.m1();
    }
}
