package lookuptable;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Stroke {


    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("Chinesetxt.txt"));
        PrintWriter out = new PrintWriter("ChineseStroke.csv");
        String oldLine = "999999";
        int stroke =0 ;
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.compareTo(oldLine) < 0) {
                stroke++;
            }
            oldLine = line;
            out.println(line + "," + stroke);
        }
        out.flush();
        out.close();
        in.close();
    }

}