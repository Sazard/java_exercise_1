import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Freq implements Command {
    @Override
    public String name() {
        return "freq";
    }


    @Override
    public boolean run(Scanner scan) {
        System.out.println("Entrer le chemin vers votre fichier");
        var path = scan.nextLine();
        try {
            String f = Files.readString(Paths.get(path));
            String[] sp = f.split(" ");
            Map<String, Integer> ma = new HashMap<String, Integer>();
            for (String s : sp) {
                ma.merge(s,1,Integer::sum);
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
        return false;
    }
}
