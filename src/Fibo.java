import java.util.Scanner;

public class Fibo implements Command {
    @Override
    public String name() {
        return "fibo";
    }

    public int fct(Integer n) {
        if (n <= 1){
            return n;
        }
        return fct(n - 1) + fct(n - 2);
    }

    @Override
    public boolean run(Scanner scan) {
        System.out.print("Entrez un nombre pour calculer Fibo : ");
        String in = scan.nextLine();
        int a = Integer.parseInt(in);
        System.out.println("Resultat : " + fct(a));
        return false;
    }
}
