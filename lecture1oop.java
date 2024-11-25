public class lecture1oop{
    public static void main(String[] args) throws InterruptedException {
        String s = "Happy Birthda to Me";
        String message = "\n I love you";

        for(int i = 5; i >= 0; i--){
            System.out.print("Line Remaining: " + i + "\r");
            Thread.sleep(1000);
        }

        for(int i = 0; i < s.length(); i++){
            System.out.print(s.charAt(i));
            Thread.sleep(200);
        }

        for(int i = 0; i < message.length(); i++){
            System.out.print(message.charAt(i));
            Thread.sleep(100);
        }

    }
}
