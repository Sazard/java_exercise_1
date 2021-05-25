import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
            String clean = f.toLowerCase().replaceAll("[\n!?.,;:]", " ");
            String[] sp = clean.split(" ");

            Stream<String> ar = Arrays.stream(sp);
            Map<String, Long> col = ar.filter(s -> !s.isBlank()).collect(
                    Collectors.groupingBy(
                            Function.identity(),
                            Collectors.counting()));
            Function<Map.Entry<String, Long>,Long> extra = e -> e.getValue();
            String fi = col.entrySet().stream()
                    .sorted(Comparator.comparing(extra).reversed())
                    .limit(3)
                    .map(e -> e.getKey())
                    .collect(Collectors.joining(" "));
            System.out.println(fi);

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
