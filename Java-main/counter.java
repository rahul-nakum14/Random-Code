public class counter {

    final int count = 0;

    counter(){
        count ++;
        System.out.println(count);
    }

    public static void main(String[] args) {
        counter obj = new counter();
        counter obj1 = new counter();
        counter obj2 = new counter();
    }
}


//static variable shares it value to all object copy 