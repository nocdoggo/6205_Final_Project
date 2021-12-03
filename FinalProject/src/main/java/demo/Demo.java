package FinalProject.src.main.java.demo;

import FinalProject.src.main.java.sort.MSD;
import utils.PinyinDemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Demo {
    public static String[] toText(File file){

        String[] res = new String[1000000];
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

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        File file = new File("C:\\Users\\94868\\Desktop\\INFO6205\\project\\test.txt");
        String[] initial = toText(file);
        System.out.println(initial.length);
        for (int i = 0; i < initial.length; i++) {
            System.out.println(initial[i]);
            initial[i] = PinyinDemo.ToPinyin(initial[i]);
           // System.out.println(initial[i]);
        }
        MSD.sort(initial);
        for (int i = 0; i < initial.length; i++) {
            System.out.println(i+"="+initial[i]);
        }
        long endTime = System.nanoTime();
        double time = (endTime-startTime)/100000000;
        System.out.println(time);
    }
}
