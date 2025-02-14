package fr.epita.assistants.embedfiles;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.stream.Collectors;

public class DisplayEmbedFile {
    private final String filename;

    public DisplayEmbedFile(String filename) {
        this.filename = filename;
    }

    public Optional<String> display() {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("fr/epita/assistants/embedfiles/" + filename);
        if (inputStream == null) {
            inputStream = classLoader.getResourceAsStream(filename);
        }


        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            String content = reader.lines().collect(Collectors.joining("\n")) + "\n";
            return Optional.of(content);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
