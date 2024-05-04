class super1 {
    
    int x = 10000;

    void m1(){
        System.out.println("siper method");
    }
}

class super_p extends super1{

    int x = 10;

    void show(int x){
        
        System.out.println(x);
        System.out.println(this.x);
        System.out.println(super.x);
    }

    public static void main(String[] args) {
        super_p obj = new super_p();
        obj.show(30);
    }
}
