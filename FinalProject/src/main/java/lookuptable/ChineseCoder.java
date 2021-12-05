package lookuptable;

import java.io.IOException;
import java.io.PrintWriter;

public class ChineseCoder {

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter("Chinese.csv");

        for (char c = 0x4E00; c <= 0x9FA5; c++) {
        int x=0x9FA5-0x4E00;
        System.out.println(x);
            out.println((int) c + "," + c);
        }
        out.flush();
        out.close();

    }

}