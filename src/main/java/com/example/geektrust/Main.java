package com.example.geektrust;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.example.geektrust.commands.CommandInvoker;
import com.example.geektrust.config.ConfigProperties;

public class Main {
    public static void main(String[] args) {
        // Sample code to read from file passed as command line argument
        ConfigProperties configProperties = new ConfigProperties();
        CommandInvoker commandInvoker = configProperties.getCommandInvoker();
        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
                // Add your code here to process input commands
                String line = sc.nextLine();
                List<String> tokens = Arrays.asList(line.split(" "));
                try {
                    commandInvoker.executeCommand(tokens.get(0), tokens);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
            System.out.println(e.getMessage());

        }

    }
}
