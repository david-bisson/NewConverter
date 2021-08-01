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
}

