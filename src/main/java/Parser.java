import org.junit.rules.ExpectedException;

import java.io.File;
import java.nio.file.NoSuchFileException;
import java.util.*;

/**
 * Created by josoder on 13.04.18.
 */
public class Parser {
    private String fileName;
    private LinkedHashSet<String> content;


    public Parser(String fileName){
        if (fileName == null || fileName.isEmpty()) {
            throw new IllegalArgumentException("Filename cant be null or empty!");
        }

        this.fileName = fileName;
    }

    private void addContent(String line) {
        if (line.contains(",")){
            Arrays.asList(line.split(","))
                    .forEach(c -> content.add(c.trim()));
        } else {
            content.add(line);
        }
    }

    public LinkedHashSet<String> getContent() throws Exception{
        content = new LinkedHashSet<>();
        Scanner scanner;

            File file = new File(fileName);
            if(!file.exists()) {
                throw new NoSuchFileException("the file does not exist");
            }

            scanner = new Scanner(file);

            if(!scanner.hasNext()) {
                System.out.println("file is empty! :(");
                return null;
            }

            while (scanner.hasNext()) {
                addContent(scanner.nextLine().trim());
            }


        return content;
    }

}
