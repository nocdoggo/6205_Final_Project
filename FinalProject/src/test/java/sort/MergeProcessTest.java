package sort;
import org.junit.Test;
import utils.BenchMark;
import utils.PinyinDemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;

public class MergeProcessTest {
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
    File file1 = new File("C:\\Users\\94868\\Desktop\\INFO6205\\project\\strokerightorder.txt");
    String[] strokerightorder = toText(file1);
    @Test
    public void sort1() {
        Long start= BenchMark.StartTime();
        for(int i = 0; i < 25000; i++) {
            String temp = testorder[i];
            testorder[i] = PinyinDemo.ToPinyin(testorder[i]);
            map.put(testorder[i],temp);
        }
        for(int i = 0; i < 25000; i++) {
            String temp = strokerightorder[i];
            strokerightorder[i] = PinyinDemo.ToPinyin(strokerightorder[i]);
            map.put(strokerightorder[i],temp);
        }
        String[] temp1 = new String[25000];
        String[] temp2 = new String[25000];
        for(int i=0;i<25000;i++){
            temp1[i]=testorder[i];
            temp2[i]=strokerightorder[i];
        }
        MSD.sort(temp1);
        Long end=BenchMark.EndTime();
        Long timeGap=end-start;
        BenchMark.toMillisecs(timeGap);
        assertArrayEquals(temp1, temp1);
    }
}
