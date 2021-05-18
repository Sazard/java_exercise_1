import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.nio.file.Files;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Launcher {
    public static void main(String []args){
        List<Command> c = new ArrayList<>();
        boolean state = false;
        int s = 0;
        boolean out = false;
        c.add(new Quit());
        c.add(new Fibo());
        c.add(new Freq());
        System.out.println("bienvenue");
        Scanner scan = new Scanner(System.in);
        while (true) {
            var cmd = scan.nextLine();
            for (var co : c){
                if(co.name().equals(cmd)){
                    out = co.run(scan);
                    s = 1;
                    break;
                }
            }
            if (s == 0){
                System.out.println("Unknown command");
                s = 0;
                continue;
            }
            if (out) return;
        }
    }
}
