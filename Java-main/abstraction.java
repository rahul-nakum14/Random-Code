abstract class b {
    
    int x;
    abstract void show();
}
class ab extends b{
    void show(){
        System.out.println("Helo abcd");
    }
}
class abstraction extends b{
        void show(){
            System.out.println("Helo dho");
        }
        public static void main(String[] args) {
            abstraction obj = new abstraction();
            obj.show();

            ab o = new ab();
            o.show();
        }
}
