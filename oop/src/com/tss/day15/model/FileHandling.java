package com.tss.day15.model;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileHandling {

    public static void main(String[] args) {
        File file = new File("C:\\File Handling");
        recursiveExplore(file);
    }

    private static void recursiveExplore(File file) {
        if (!file.exists()) {
            System.out.println("File doesn't exist: " + file.getAbsolutePath());
            return;
        }

        if (file.isDirectory()) {
            System.out.println("Directory: " + file.getAbsolutePath());
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.isFile()) {
                        System.out.println("File: " + f.getAbsolutePath());
                        try {
                            BufferedReader br = new BufferedReader(new FileReader(f));
                            System.out.println("Contents:");
                            String content;
                            while ((content = br.readLine()) != null) {
                                System.out.println(content);
                            }
                            br.close();
                        } catch (IOException e) {
                            System.out.println("Error reading file: " + f.getAbsolutePath());
                        }
                        System.out.println();
                    }
                }
                for (File f : files) {
                    if (f.isDirectory()) {
                        recursiveExplore(f);
                    }
                }
            }
        } else {
            System.out.println("File: " + file.getAbsolutePath());
        }
    }
}
