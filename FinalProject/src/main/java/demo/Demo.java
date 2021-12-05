package demo;

import sort.MSD;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Demo {


    public static String[] toText(File file){

        String[] res = new String[999875];
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            int index=0;
            while((s = br.readLine())!=null&&index<res.length){
                res[index++] = s;
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        Map<String,String> map = new HashMap<>();
        long startTime = System.nanoTime();
        File file = new File("C:\\Users\\94868\\Desktop\\INFO6205\\project\\test3.txt");
        String[] initial = toText(file);
        for (int i = 0; i < 999875; i++) {
            System.out.println(initial[i]);
        }
        MSD.sort(initial);
        FileWriter writer1 = new FileWriter("C:\\Users\\94868\\Desktop\\INFO6205\\project\\outcomecome.csv");
        for (int index = 0; index < 999875; index++) {
            writer1.append(initial[index]);
            writer1.append("\n");
        }


    }


    }

