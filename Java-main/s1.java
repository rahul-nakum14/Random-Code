class s1 {
    int a;
    int b;
    static String name= "Rahul";

    s1(int a,int b){
        this.a = a;
        this.b = b;
    }
    void disp(){
        System.out.println(a+ "" +""+b+""+name);    
    }
    public static void main(String[] args) {
        s1 obj = new s1(23,45);
        obj.disp();

    }
}
