package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        //System.out.println("Hello world!");
        String path;
        System.out.println("Enter file path or file name:");
        Scanner scanner = new Scanner(System.in);
        path = scanner.next();

        Path path1 = FileSystems.getDefault().getPath(path);

        RandomThread randomThread = new RandomThread(path1);
        randomThread.start();
        sleep(1000);

        PrimeNumbersThread primeNumbersThread = new PrimeNumbersThread(path1);
        primeNumbersThread.start();

        FactorialThread factorialThread = new FactorialThread(path1);
        primeNumbersThread.start();

    }
}