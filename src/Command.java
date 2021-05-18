import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface Command {
    String name();
    boolean run(Scanner scan);
}
