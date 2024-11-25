import java.util.Scanner;

public class prime {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter the number = ");

        int num = input.nextInt();


        if(num %2!=0){
            System.out.println("It's is prime number");
        }
    }
}
