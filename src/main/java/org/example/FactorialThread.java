package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FactorialThread extends Thread {
    private Path fileDir;

    public FactorialThread(Path dir) {
        fileDir = dir;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = Files.newBufferedReader(fileDir, StandardCharsets.UTF_8);
            String[] numbers = reader.readLine().split(" ");
            String factorial = " ";

            for (String number : numbers) {
                int result = 1;

                for (int i = 1; i <=numbers.length; i ++){
                    result = result * i;
                }

                BufferedWriter writer = Files.newBufferedWriter(Path.of("TextResultFactorial.txt"), StandardCharsets.UTF_8);
                writer.write(factorial = factorial + result + " ");
                writer.flush();
            }
            System.out.println("The file is full.");
            Thread.sleep(500);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
