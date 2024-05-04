// invoking current class instance variable

// class MyClass {
   
//    int ins_var = 100;

//    void test(){
//       int ins_var = 1000;
//       System.out.println(this.ins_var);
//    }

//    public static void main(String[] args) {
//       MyClass obj = new MyClass();
//       obj.test();
//    }
// }


// invoking current class method


// class MyClass {
   
//    int ins_var = 100;

//    void test(){
//     this.m2();
//    }

//    void m2()
//    {
//       System.out.println("helooo");
//    }

//    public static void main(String[] args) {
//       MyClass obj = new MyClass();
//       obj.test();
//    }
// }


//invloking currebnt class instructor


class MyClass {
   
   MyClass(){
      this(10);
   }
   MyClass(int x){
      System.out.println("helooo");
   }

   public static void main(String[] args) {
      MyClass obj = new MyClass();
   }
}