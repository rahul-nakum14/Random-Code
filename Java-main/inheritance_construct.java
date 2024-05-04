class A{

    int a;
    String name;

    A(int a, String name){
        this.a = a;
        this.name = name;
    }
}

class inheritance_construct extends A{

    int id;
    inheritance_construct(int w,String name1,int y){
        super(w,name1);
        this.id = y;
    }
    void show(){
        System.out.println(a);
        System.out.println(name);
        System.out.println(id);
    }
    public static void main(String[] args) {
        inheritance_construct obj = new inheritance_construct(10,"adasda",1111111111);
        obj.show();
    }
}
