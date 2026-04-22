package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String input = "";
        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/log.txt");
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);

            String todayFmt = updatedDateTime();
            bufWriter.write(todayFmt + " launch \n");

            while (!input.equals("X")) {
                System.out.print("Enter a search term (X to exit): ");
                input = myScanner.nextLine();
                if (input.equals("X")) {
                    break;
                }
                todayFmt = updatedDateTime();
                bufWriter.write(todayFmt + " : " + input + "\n");
            }
            todayFmt = updatedDateTime();
            bufWriter.write(todayFmt + " exit");
            bufWriter.close();
        }
        catch(IOException e){
            System.err.println("U did something wrong");

        }

    }

    public static String updatedDateTime()
    {
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return today.format(fmt);
    }
}
