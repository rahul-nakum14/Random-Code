import java.util.Scanner;

class t1{
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        
        System.out.println("Enter A");
        int a = obj.nextInt();
        
        System.out.println("Enter B");
        int b = obj.nextInt();

        System.out.println("Enter choice \n 1.(+) \n 2.(-)");
        int ch = obj.nextInt();

        switch(ch){
            case 1:
                int sum = a+b;
                System.out.println("Sum is"+sum);
            break;

            case 2:
                int sub = a-b;
                System.out.println("Sub is"+sub);

        }


    }
}