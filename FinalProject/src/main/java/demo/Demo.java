package demo;

import sort.MSD;
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
        File file = new File("/Users/xuzifeng/Desktop/INFO6150/6205_Final_Project/FinalProject/src/main/resources/shuffledChinese.txt");
        String[] initial = toText(file);
        for (int i = 0; i < initial.length; i++) {
            initial[i] = PinyinDemo.ToPinyin(initial[i]);
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
