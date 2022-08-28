package org.example;

import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class RandomThread extends Thread {

    private Path fileDir;

    public RandomThread(Path dir) {
        fileDir = dir;
    }

    @Override
    public void run() {
        Random rnd = new Random(System.currentTimeMillis());
        try {
            BufferedWriter writer = Files.newBufferedWriter(fileDir, StandardCharsets.UTF_8);
            for (int i = 0; i < 100; ++i)
                writer.write(rnd.nextInt(100) + " ");
            writer.flush();
            System.out.println("The file is full.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


