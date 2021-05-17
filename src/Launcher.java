import java.util.Scanner;

public class Launcher {
    public static void main(String []args){
        System.out.println("bienvenue");
        Scanner scan = new Scanner(System.in);
        while (true) {
            var cmd = scan.nextLine();
            if (cmd.equals("quit")) {
                break;
            }
            if (cmd.equals("fibo")){
                System.out.println("Entrez le n à calculer");
                var n = scan.nextLine();
                try{
                    var fib = fibo(Integer.parseInt(n));
                    System.out.println("result " + fib);
                } catch (Exception e) {
                    System.err.println("Ce n'est pas un entier");
                }
                continue;
            }
            System.out.println("Unknown command");
        }
    }

    public static Integer fibo(Integer n){
        if (n <= 1){
            return n;
        }
        return fibo(n - 1) + fibo(n - 2);
    }
}
