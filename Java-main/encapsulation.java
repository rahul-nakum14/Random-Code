class ad {
    private int a;

    public void set_A(int x){
        a = x;
    }
    public int get_b(){
        return a;
    }
}
class encapsulation{
    public static void main(String[] args) {
        ad obj = new ad();
        obj.set_A(100);
        System.out.println(obj.get_b());
    }
      
}