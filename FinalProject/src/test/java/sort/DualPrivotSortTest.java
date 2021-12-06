package sort;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
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
    File file = new File("C:\\Users\\94868\\Desktop\\INFO6205\\project\\chineseshuffle,code.version.txt");
    String[] testorder = toText(file);
    File file1 = new File("C:\\Users\\94868\\Desktop\\INFO6205\\project\\pinyinrightorder, code.version.txt");
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
    public void sort1() {
        String[] temp1 = new String[1000000-2];
        String[] temp2 = new String[5000];
        String[] temp3 = new String[5000];
        for(int i=0;i<1000000-2;i++){
            temp1[i]=testorder[i];
        }
        DualPivotSort.sort(temp1);
        for(int i=0;i<5000;i++){
            temp3[i]=temp1[i];
            temp2[i]=rightorder[i];
        }
        for(int i=0;i<100;i++) {
            System.out.println("Expected------"+temp3[i]+"---------------Actual----------"+temp2[i]);
        }
        assertArrayEquals(temp2, temp3);
    }
    @Test
    public void sort2() {
        String[] temp1 = new String[1000000-2];
        String[] temp2 = new String[10000];
        String[] temp3 = new String[10000];
        for(int i=0;i<1000000-2;i++){
            temp1[i]=testorder[i];
        }
        DualPivotSort.sort(temp1);
        for(int i=0;i<10000;i++){
            temp3[i]=temp1[i];
            temp2[i]=rightorder[i];
        }
        for(int i=0;i<100;i++) {
            System.out.println("Expected------"+temp3[i]+"---------------Actual----------"+temp2[i]);
        }
        assertArrayEquals(temp2, temp3);
    }
    @Test
    public void sort3() {
        String[] temp1 = new String[1000000-2];
        String[] temp2 = new String[20000];
        String[] temp3 = new String[20000];
        for(int i=0;i<1000000-2;i++){
            temp1[i]=testorder[i];
        }
        DualPivotSort.sort(temp1);
        for(int i=0;i<20000;i++){
            temp3[i]=temp1[i];
            temp2[i]=rightorder[i];
        }
        for(int i=0;i<100;i++) {
            System.out.println("Expected------"+temp3[i]+"---------------Actual----------"+temp2[i]);
        }
        assertArrayEquals(temp2, temp3);
    }
    @Test
    public void sort4() {
        String[] temp1 = new String[1000000-2];
        String[] temp2 = new String[40000];
        String[] temp3 = new String[40000];
        for(int i=0;i<1000000-2;i++){
            temp1[i]=testorder[i];
        }
        DualPivotSort.sort(temp1);
        for(int i=0;i<40000;i++){
            temp3[i]=temp1[i];
            temp2[i]=rightorder[i];
        }
        for(int i=0;i<100;i++) {
            System.out.println("Expected------"+temp3[i]+"---------------Actual----------"+temp2[i]);
        }
        assertArrayEquals(temp2, temp3);
    }
    @Test
    public void sort5() {
        String[] temp1 = new String[1000000-2];
        String[] temp2 = new String[80000];
        String[] temp3 = new String[80000];
        for(int i=0;i<1000000-2;i++){
            temp1[i]=testorder[i];
        }
        DualPivotSort.sort(temp1);
        for(int i=0;i<80000;i++){
            temp3[i]=temp1[i];
            temp2[i]=rightorder[i];
        }
        for(int i=0;i<100;i++) {
            System.out.println("Expected------"+temp3[i]+"---------------Actual----------"+temp2[i]);
        }
        assertArrayEquals(temp2, temp3);
    }
    @Test
    public void sort6() {
        String[] temp1 = new String[1000000-2];
        String[] temp2 = new String[90000];
        String[] temp3 = new String[90000];
        for(int i=0;i<1000000-2;i++){
            temp1[i]=testorder[i];
        }
        DualPivotSort.sort(temp1);
        for(int i=0;i<90000;i++){
            temp3[i]=temp1[i];
            temp2[i]=rightorder[i];
        }
        for(int i=0;i<100;i++) {
            System.out.println("Expected------"+temp3[i]+"---------------Actual----------"+temp2[i]);
        }
        assertArrayEquals(temp2, temp3);
    }
    @Test
    public void sort7() {
        String[] temp1 = new String[1000000-2];
        String[] temp2 = new String[98000];
        String[] temp3 = new String[98000];
        for(int i=0;i<1000000-2;i++){
            temp1[i]=testorder[i];
        }
        DualPivotSort.sort(temp1);
        for(int i=0;i<98000;i++){
            temp3[i]=temp1[i];
            temp2[i]=rightorder[i];
        }
        for(int i=0;i<100;i++) {
            System.out.println("Expected------"+temp3[i]+"---------------Actual----------"+temp2[i]);
        }
        assertArrayEquals(temp2, temp3);
    }

}
