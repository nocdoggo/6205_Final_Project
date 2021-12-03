package FinalProject.src.main.java.demo;

import FinalProject.src.main.java.sort.MSD;
import utils.PinyinDemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

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
        Map<String,String> map = new HashMap<>();
        long startTime = System.nanoTime();
        File file = new File("D:\\GitHub\\6205_Final_Project\\FinalProject\\src\\main\\java\\unicodePinyin\\sample_dict.txt");
        String[] initial = toText(file);
        for (int i = 0; i < initial.length; i++) {
            String temp = initial[i];
            initial[i] = PinyinDemo.ToPinyin(initial[i]);
            map.put(initial[i],temp);
        }
        MSD.sort(initial);
        for (int i = 0; i < initial.length; i++) {
            System.out.println(i+"="+map.get(initial[i]));
        }
        long endTime = System.nanoTime();
        double time = (endTime-startTime)/100000000;
        System.out.println(time);
    }
}
