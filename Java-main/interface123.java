interface i1{
    void show();
}
interface i2{
    void show1();
}
class a implements i1,i2{
    public void show(){
        System.out.println(("helo world"));
    }
    
    public void show1(){
        System.out.println(("helo world 1"));
    }
    public static void main(String[] args) {
        a obj = new a();
        obj.show();
    }
}