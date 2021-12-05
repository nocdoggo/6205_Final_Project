package lookuptable;

import java.io.*;
import java.io.IOException;
import java.util.Scanner;

public class StrokeNumbers {
    public int Strokebumbers(char a)throws IOException {
        if(a<0x4E00||a>0x9FA5){
        System.out.println("not chinese character");

        }

            Scanner in = new Scanner(new File("Stroke.txt"));
            File sourceFile = new File("\"Stroke.txt\"");
            int line = a - 0x4E00 + 1;
            String numbers = "";

            for (int i = 0; i < line; i++) {
                numbers = in.nextLine();
            }
            int number = Integer.parseInt(numbers);

            return number;

    }
    public int[] split(String str) throws IOException {
        char chars[]=   str.toCharArray();
        int numbers[]=new int[chars.length];

        for(int i=0;i<chars.length;i++){
            numbers[i]=Strokebumbers(chars[i]);
            System.out.println(chars[i]);
        }
        return numbers;
    }
    }
