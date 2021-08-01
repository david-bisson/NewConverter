import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        WriteToLog.fileFlush();
        System.out.println("Welcome to currency converter");
        Runner runner = new Runner();
        runner.runner();
    }




    private static void openFile() {
        try {
//constructor of file class having file as argument
            File file = new File("src/main/resources/results.txt");
            if (!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not
            {
                System.out.println("not supported");
                return;
            }
            Desktop desktop = Desktop.getDesktop();
            if (file.exists())         //checks file exists or not
                desktop.open(file);              //opens the specified file
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

