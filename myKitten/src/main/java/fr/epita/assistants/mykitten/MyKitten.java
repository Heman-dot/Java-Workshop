package fr.epita.assistants.mykitten;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.*;
import java.nio.file.*;
import java.util.concurrent.atomic.AtomicInteger;


public class MyKitten {
    /**
     * Initializer.
     *
     *
     * @param srcPath Source file path.
     */
    public Stream <String> streamContent;
    public MyKitten(String srcPath) {
        try{
            streamContent = Files.lines(Paths.get(srcPath));
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    /**
     * Use the streamContent to replace `wordToReplace` with "miaou". Don't forget
     * to add the line number beforehand for each line. Store the new
     * result directly in the streamContent field.
     *
     * @param wordToReplace The word to replace
     */
    public void replaceByMiaou(String wordToReplace) {
        AtomicInteger lineNumber = new AtomicInteger(1);
       List<String> updatedLines = this.streamContent.map(line ->
          line.replace(wordToReplace,"miaou")).map(line -> lineNumber.getAndIncrement()+ " " + line).collect(Collectors.toList());

       this.streamContent = updatedLines.stream();

    }

    /**
     * Use the streamContent to write the content into the destination file.
     *
     * @param destPath Destination file path.
     */
    public void toFile(String destPath) {
        try{
            Files.write(Paths.get(destPath), (Iterable<String>)streamContent::iterator);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    /**
     * Creates an instance of MyKitten and calls the above methods to do it
     * straightforwardly.
     *
     * @param srcPath       Source file path
     * @param destPath      Destination file path
     * @param wordToReplace Word to replace
     */
    public static void miaou(String srcPath, String destPath,
                             String wordToReplace) {
        // FIXME
        MyKitten myKitten = new MyKitten(srcPath);
        myKitten.replaceByMiaou(wordToReplace);
        myKitten.toFile(destPath);
    }


}
