package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class PrimeNumbersThread extends Thread {
    private Path fileDir;

    public PrimeNumbersThread(Path dir) {
        fileDir = dir;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = Files.newBufferedReader(fileDir, StandardCharsets.UTF_8);
            String[] numbers = reader.readLine().split(" ");
            String primeNumber;
            String result = " ";
            for (String number : numbers) {
                for(int i = 2; i <= numbers.length; i ++){
                    boolean isPrime = true;

                    for(int j = 2; j < i; j++){
                        if(i % j == 0){
                            isPrime = false;
                            break;
                        }
                    }

                    if(isPrime) {
                        BufferedWriter writer = Files.newBufferedWriter(Path.of("TextResultPrimeNumbers.txt"), StandardCharsets.UTF_8);
                        writer.write(result = result + i + " ");
                        writer.flush();
                        //System.out.println(i + " ");
                    }
                }
            }
            System.out.println("The file is full.");
            Thread.sleep(500);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
