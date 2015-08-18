package fr.com.mowitnow.suppliers;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileComputeSupplier implements Supplier<List<String>> {

    private String filename;

    public FileComputeSupplier(String filename) {
        this.filename = filename;
    }

    public List<String> get() {
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
