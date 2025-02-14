package fr.epita.assistants.fgen;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FGen {
    private Path currentPath;

    public FGen(final String inputPath) {
        this.currentPath = Paths.get("").toAbsolutePath(); // Start in the current directory
        processCommands(inputPath);
    }

    private void processCommands(String inputPath) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(inputPath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            while ((line = reader.readLine()) != null) {
                executeCommand(line);
            }

        } catch (IOException | NullPointerException e) {
            throw new RuntimeException("Error reading input file: " + inputPath, e);
        }
    }

    private void executeCommand(String command) {
        if (command.isEmpty()) return;

        char opcode = command.charAt(0);
        String relativePath = command.substring(2).trim();
        Path targetPath = currentPath.resolve(relativePath).normalize();

        switch (opcode) {
            case '+':
                create(targetPath, relativePath.endsWith("/"));
                break;
            case '>':
                changeDirectory(targetPath);
                break;
            case '-':
                delete(targetPath);
                break;
            default:
                throw new RuntimeException("Invalid command: " + command);
        }
    }

    private void create(Path path, boolean isDirectory) {
        try {
            if (isDirectory) {
                Files.createDirectories(path); // Create directories (including parents if needed)
            } else {
                Files.createDirectories(path.getParent()); // Ensure parent directory exists
                if (!Files.exists(path)) Files.createFile(path); // Create file if it doesn't exist
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to create: " + path, e);
        }
    }


    private void changeDirectory(Path path) {
        if (Files.exists(path) && Files.isDirectory(path)) {
            currentPath = path;
        } else {
            throw new RuntimeException("Invalid directory: " + path);
        }
    }

    private void delete(Path path) {
        try {
            if (Files.exists(path)) {
                Files.walk(path)
                        .sorted(Comparator.reverseOrder()) // Delete files before directories
                        .forEach(p -> {
                            try {
                                Files.delete(p);
                            } catch (IOException e) {
                                throw new RuntimeException("Failed to delete: " + p, e);
                            }
                        });
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to delete: " + path, e);
        }
    }

}
