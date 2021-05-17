import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.nio.file.Files;
import java.util.concurrent.atomic.AtomicInteger;

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
            if (cmd.equals("freq")){
                System.out.println("Entrer le chemin vers votre fichier");
                var path = scan.nextLine();
                try {
                    String f = Files.readString(Paths.get(path));
                    String[] sp = f.split(" ");
                    Map<String, Integer> ma = new HashMap<String, Integer>();
                    for(int i = 0; i < sp.length; i++){
                        if(ma.containsKey(sp[i])){
                            ma.put(sp[i], ma.get(sp[i]) + 1);
                        } else{
                            ma.put(sp[i], 1);
                        }
                    }
                    for(int zz=0; zz < 3; zz++) {
                        String max = Collections.max(ma.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
                        if (zz == 2){
                            System.out.println(max);
                            continue;
                        }
                        System.out.print(max + " ");
                        ma.remove(max);
                    }
                } catch(IOException e){
                    System.err.println("Unreadable file: IOException "+ e.getMessage());
                } catch(OutOfMemoryError e1){
                    System.err.println("Unreadable file: OutOfMemoryError " + e1.getMessage());
                } catch(SecurityException e2){
                    System.err.println("Unreadable file: SecurityException " + e2.getMessage());
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
