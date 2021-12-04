package FinalProject.src.test.java.sort;
import FinalProject.src.main.java.sort.DualPivotSort;
import org.junit.Test;
import utils.PinyinDemo;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
public class DualPrivotSortTest {
    public static String[] toText(File file){

        String[] res = new String[1000000-2];
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
    Map<String,String> map = new HashMap<>();
    File file = new File("C:\\Users\\94868\\Desktop\\INFO6205\\project\\shuffledChinese.txt");
    String[] testorder = toText(file);
    File file1 = new File("C:\\Users\\94868\\Desktop\\INFO6205\\project\\pinyinrightorder.txt");
    String[] rightorder = toText(file1);


    String[] input = "she sells seashells by the seashore the shells she sells are surely seashells".split(" ");
    String[] expected = "are by seashells seashells seashore sells sells she she shells surely the the".split(" ");
    @Test
    public void sort() {
        DualPivotSort.sort(input);
        System.out.println(Arrays.toString(input));
        assertArrayEquals(expected, input);
    }
    @Test
    public  void sort1() {
        for(int i = 0; i < 25000; i++) {
            String temp = testorder[i];
            testorder[i] = PinyinDemo.ToPinyin(testorder[i]);
            map.put(testorder[i],temp);
        }
        for(int i = 0; i < 25000; i++) {
            String temp = rightorder[i];
            rightorder[i] = PinyinDemo.ToPinyin(rightorder[i]);
            map.put(rightorder[i],temp);
        }
        String[] temp1 = new String[25000];
        String[] temp2 = new String[25000];
        for(int i=0;i<25000;i++){
            temp1[i]=testorder[i];
            temp2[i]=rightorder[i];
        }
        DualPivotSort.sort(temp1);
        assertArrayEquals(temp1, temp1);
    }
    @Test
    public void sort2() {
        for(int i = 0; i < 50000; i++) {
            String temp = testorder[i];
            testorder[i] = PinyinDemo.ToPinyin(testorder[i]);
            map.put(testorder[i],temp);
        }
        for(int i = 0; i < 50000; i++) {
            String temp = rightorder[i];
            rightorder[i] = PinyinDemo.ToPinyin(rightorder[i]);
            map.put(rightorder[i],temp);
        }
        String[] temp1 = new String[50000];
        String[] temp2 = new String[50000];
        for(int i=0;i<50000;i++){
            temp1[i]=testorder[i];
            temp2[i]=rightorder[i];
        }
        DualPivotSort.sort(temp1);
        assertArrayEquals(temp1, temp1);
    }
    @Test
    public void sort3() {
        for(int i = 0; i < 100000; i++) {
            String temp = testorder[i];
            testorder[i] = PinyinDemo.ToPinyin(testorder[i]);
            map.put(testorder[i],temp);
        }
        for(int i = 0; i < 100000; i++) {
            String temp = rightorder[i];
            rightorder[i] = PinyinDemo.ToPinyin(rightorder[i]);
            map.put(rightorder[i],temp);
        }
        String[] temp1 = new String[100000];
        String[] temp2 = new String[100000];
        for(int i=0;i<100000;i++){
            temp1[i]=testorder[i];
            temp2[i]=rightorder[i];
        }
        DualPivotSort.sort(temp1);
        assertArrayEquals(temp1, temp1);
    }
    @Test
    public void sort4() {
        for(int i = 0; i < 200000; i++) {
            String temp = testorder[i];
            testorder[i] = PinyinDemo.ToPinyin(testorder[i]);
            map.put(testorder[i],temp);
        }
        for(int i = 0; i < 200000; i++) {
            String temp = rightorder[i];
            rightorder[i] = PinyinDemo.ToPinyin(rightorder[i]);
            map.put(rightorder[i],temp);
        }
        String[] temp1 = new String[200000];
        String[] temp2 = new String[200000];
        for(int i=0;i<200000;i++){
            temp1[i]=testorder[i];
            temp2[i]=rightorder[i];
        }
        DualPivotSort.sort(temp1);
        assertArrayEquals(temp1, temp1);
    }
    @Test
    public void sort5() {
        for(int i = 0; i < 400000; i++) {
            String temp = testorder[i];
            testorder[i] = PinyinDemo.ToPinyin(testorder[i]);
            map.put(testorder[i],temp);
        }
        for(int i = 0; i < 400000; i++) {
            String temp = rightorder[i];
            rightorder[i] = PinyinDemo.ToPinyin(rightorder[i]);
            map.put(rightorder[i],temp);
        }
        String[] temp1 = new String[400000];
        String[] temp2 = new String[400000];
        for(int i=0;i<400000;i++){
            temp1[i]=testorder[i];
            temp2[i]=rightorder[i];
        }
        DualPivotSort.sort(temp1);
        assertArrayEquals(temp1, temp1);
    }
    @Test
    public void sort6() {
        for(int i = 0; i < 800000; i++) {
            String temp = testorder[i];
            testorder[i] = PinyinDemo.ToPinyin(testorder[i]);
            map.put(testorder[i],temp);
        }
        for(int i = 0; i < 800000; i++) {
            String temp = rightorder[i];
            rightorder[i] = PinyinDemo.ToPinyin(rightorder[i]);
            map.put(rightorder[i],temp);
        }
        String[] temp1 = new String[800000];
        String[] temp2 = new String[800000];
        for(int i=0;i<800000;i++){
            temp1[i]=testorder[i];
            temp2[i]=rightorder[i];
        }
        DualPivotSort.sort(temp1);
        assertArrayEquals(temp1, temp1);
    }
    @Test
    public void sort7() {
        for(int i = 0; i < 1000000-2; i++) {
            String temp = testorder[i];
            testorder[i] = PinyinDemo.ToPinyin(testorder[i]);
            map.put(testorder[i],temp);
        }
        for(int i = 0; i < 1000000-2; i++) {
            String temp = rightorder[i];
            rightorder[i] = PinyinDemo.ToPinyin(rightorder[i]);
            map.put(rightorder[i],temp);
        }
        String[] temp1 = new String[1000000-2];
        String[] temp2 = new String[1000000-2];
        for(int i=0;i<1000000-2;i++){
            temp1[i]=testorder[i];
            temp2[i]=rightorder[i];
        }
        DualPivotSort.sort(temp1);
        assertArrayEquals(temp1, temp1);
    }

}
