import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFromFile {


public static String[] readMe() {
    Scanner sc = null;
    try {
        sc = new Scanner(new File("Words.txt"));
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    List<String> lines = new ArrayList<String>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }

        String [] animals = lines.toArray(new String[0]);

        return animals;
    }
}
