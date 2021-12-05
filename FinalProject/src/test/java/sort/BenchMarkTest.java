package sort;

import edu.neu.coe.huskySort.sort.huskySort.PureHuskySort;
import edu.neu.coe.huskySort.sort.huskySortUtils.HuskyCoderFactory;
import utils.BenchMark;
import utils.PinyinDemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class BenchMarkTest {
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
    public static void MSDBenchMark(int length){

        int loops=5;
        long start=  BenchMark.StartTime();
        for(int j=0;j<loops;j++){
            Map<String,String> map = new HashMap<>();
            File file = new File("C:\\Users\\94868\\Desktop\\INFO6205\\project\\shuffledChinese.txt");
            String[] testorder = toText(file);
            for(int i = 0; i < 1000000-2; i++) {
                String temp = testorder[i];
                testorder[i] = PinyinDemo.ToPinyin(testorder[i]);
                map.put(testorder[i],temp);
            }
            String[] temp1 = new String[length];
            for(int i=0;i<length;i++){
                temp1[i]=testorder[i];
            }
            MSD.sort(temp1);
        }
        long end=BenchMark.EndTime();
        long timeGap=end-start;

        double meanTime=BenchMark.toMillisecs(timeGap)/5;
        System.out.println("MSDBenchMark-----------length is"+length+"---------Mean Time is----------"+meanTime+"ms");

    }
    public static void HuskySortBenchMark(int length){

        int loops=5;
        long start=  BenchMark.StartTime();
        for(int j=0;j<loops;j++){
            Map<String,String> map = new HashMap<>();
            File file = new File("C:\\Users\\94868\\Desktop\\INFO6205\\project\\shuffledChinese.txt");
            String[] testorder = toText(file);
            for(int i = 0; i < 1000000-2; i++) {
                String temp = testorder[i];
                testorder[i] = PinyinDemo.ToPinyin(testorder[i]);
                map.put(testorder[i],temp);
            }
            String[] temp1 = new String[length];
            for(int i=0;i<length;i++){
                temp1[i]=testorder[i];
            }
            PureHuskySort<String> sorter = new PureHuskySort<>(HuskyCoderFactory.asciiCoder, false, false);
            sorter.sort(temp1);
        }
        long end=BenchMark.EndTime();
        long timeGap=end-start;

        double meanTime=BenchMark.toMillisecs(timeGap)/5;
        System.out.println("HuskySortBenchMark-----------length is"+length+"---------Mean Time is----------"+meanTime+"ms");

    }
    public static void TimSortBenchMark(int length){

        int loops=5;
        long start=  BenchMark.StartTime();
        for(int j=0;j<loops;j++){
            Map<String,String> map = new HashMap<>();
            File file = new File("C:\\Users\\94868\\Desktop\\INFO6205\\project\\shuffledChinese.txt");
            String[] testorder = toText(file);
            for(int i = 0; i < 1000000-2; i++) {
                String temp = testorder[i];
                testorder[i] = PinyinDemo.ToPinyin(testorder[i]);
                map.put(testorder[i],temp);
            }
            String[] temp1 = new String[length];
            for(int i=0;i<length;i++){
                temp1[i]=testorder[i];
            }
            TimSort.sort(temp1);
        }
        long end=BenchMark.EndTime();
        long timeGap=end-start;

        double meanTime=BenchMark.toMillisecs(timeGap)/5;
        System.out.println("TimSortBenchMark-----------length is"+length+"---------Mean Time is----------"+meanTime+"ms");

    }

    public static void DualPrivotSortBenchMark(int length){

        int loops=5;
      long start=  BenchMark.StartTime();
      for(int j=0;j<loops;j++){
          Map<String,String> map = new HashMap<>();
          File file = new File("C:\\Users\\94868\\Desktop\\INFO6205\\project\\shuffledChinese.txt");
          String[] testorder = toText(file);
          for(int i = 0; i < 1000000-2; i++) {
              String temp = testorder[i];
              testorder[i] = PinyinDemo.ToPinyin(testorder[i]);
              map.put(testorder[i],temp);
          }
          String[] temp1 = new String[length];
          for(int i=0;i<length;i++){
              temp1[i]=testorder[i];
          }
          DualPivotSort.sort(temp1);
      }
      long end=BenchMark.EndTime();
      long timeGap=end-start;

      double meanTime=BenchMark.toMillisecs(timeGap)/5;
      System.out.println("DualPrivotSortBenchMark-----------length is"+length+"---------Mean Time is----------"+meanTime+"ms");

    }
    public static void SqlSortBenchMark(int length) throws SQLException {

        int loops=5;
        long start=  BenchMark.StartTime();
        for(int j=0;j<loops;j++){
            SqlSort.sortByPinYin(length);
        }
        long end=BenchMark.EndTime();
        long timeGap=end-start;

        double meanTime=BenchMark.toMillisecs(timeGap)/5;
        System.out.println("SqlSortBenchMarkBypinyin-----------length is"+length+"---------Mean Time is----------"+meanTime+"ms");

    }
    public static void main(String[] args) throws SQLException {
        int length=25000;
        for(int i=0;i<6;i++) {
            DualPrivotSortBenchMark(length);
            length*=2;
        }
        length=25000;
        for(int i=0;i<6;i++) {
            MSDBenchMark(length);
            length*=2;
        }
       length=25000;
        for(int i=0;i<6;i++) {
            TimSortBenchMark(length);
            length*=2;
        }
        length=25000;
        for(int i=0;i<6;i++) {
            HuskySortBenchMark(length);
            length*=2;
        }
        length=25000;
        for(int i=0;i<6;i++) {
            SqlSortBenchMark(length);
            length*=2;
        }

    }
}
