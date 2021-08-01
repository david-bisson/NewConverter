import java.awt.*;
import java.io.File;

public class openFile {
    public static void openFile() {
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
