package aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileHandle {
    private List<String> lines;
    private String name;

    public FileHandle(String filePath){
        Path path = Path.of(filePath);
        try {
            lines = Files.readAllLines(path);
        }catch (IOException e){
            System.err.println("Error reading the file.");
        }
    }

    public String getLine(int index){
        return lines.get(index);
    }

    public int getIntLine(int index){
        return  Integer.parseInt(getLine(index));
    }

    public List<String> getLines() {
        return lines;
    }
}
