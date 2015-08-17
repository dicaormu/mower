package fr.com.mowitnow.entrystrategy;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileComputeStrategy  {

    //TODO ERASE

    private String filename;

    public FileComputeStrategy(String filename) {
        this.filename = filename;
    }


    public List<String> getInstructions() {
        File file = new File(filename);
        try (Stream<String> lines = Files.lines(file.toPath())) {
            return lines
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
