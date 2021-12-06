package sort;

import edu.neu.coe.huskySort.sort.huskySort.PureHuskySort;
import edu.neu.coe.huskySort.sort.huskySortUtils.HuskyCoderFactory;
import utils.BenchMark;
import utils.PinyinDemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
    public static void MultiThreadBenchMark(int length) throws ExecutionException, InterruptedException {

        int loops=5;
        long start=  BenchMark.StartTime();
        for(int l=0;l<loops;l++){
            int arrSize = length;
            String[] unsorted = new String[arrSize];

            Random randomizer = new Random();

            for ( int i = 0; i < arrSize; i++ ) {
                unsorted[i] = Integer.toString(randomizer.nextInt( 10_00000 ));
            }
            ///////////////////////////////////////

            List<Future> futureList = new ArrayList<>();
            // Get the maximum number of threads available for the given processor
            int max_thread_count = Runtime.getRuntime().availableProcessors();
            System.out.println("The maximum physical threads allowed on this processor is " + max_thread_count);
            int perBlockSize = arrSize/max_thread_count;
            long startTime = System.currentTimeMillis();

            // Launch the pool
            final ExecutorService poolingApp = Executors.newFixedThreadPool(max_thread_count);
            ArrayList<PoolMerge> mergers = new ArrayList<>();
            for (int i = 0; i < max_thread_count; i++) {


                String[] partialArr = new String[perBlockSize];


                System.arraycopy( unsorted, i*perBlockSize, partialArr, 0, perBlockSize );
                PoolMerge PoolMerge = new PoolMerge(partialArr);

                futureList.add(poolingApp.submit(PoolMerge));
                //add PoolMerge to list to get result in future
                mergers.add(PoolMerge);
            }
            for (Future<Double> future : futureList) {
                future.get();
            }
            poolingApp.shutdown();
            int j = 0;
            // array to get result
            String[] mergered = new String[arrSize];
            // sequential merge of all partialArr of array
            for (PoolMerge PoolMerge:mergers){
                if (j == 0) {
                    mergered = PoolMerge.getSorted();
                    j+=1;
                }
                else{
                    String[] partialArr = PoolMerge.getSorted();
                    mergered = MergeProcess.merge( mergered, partialArr);
                }
            }
            long overallRuntime = System.currentTimeMillis() - startTime;
            System.out.println("With " + max_thread_count + " of threads, it needs " + overallRuntime + " milliseconds");
            startTime = System.currentTimeMillis();
            Arrays.sort(unsorted);
            overallRuntime = System.currentTimeMillis() - startTime;
            System.out.println("With single thread, it takes " + overallRuntime + " milliseconds");
        }

        long end=BenchMark.EndTime();
        long timeGap=end-start;

        double meanTime=BenchMark.toMillisecs(timeGap)/5;
        System.out.println("MultiThreadBenchMark-----------length is"+length+"---------Mean Time is----------"+meanTime+"ms");

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
    public static void SqlSortBenchMarkByPinYin(int length) throws SQLException{

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
    public static void SqlSortBenchMarkByStroke(int length) throws SQLException{

        int loops=5;
        long start=  BenchMark.StartTime();
        for(int j=0;j<loops;j++){
            SqlSort.sortByStroke(length);
        }
        long end=BenchMark.EndTime();
        long timeGap=end-start;

        double meanTime=BenchMark.toMillisecs(timeGap)/5;
        System.out.println("SqlSortBenchMarkByStroke-----------length is"+length+"---------Mean Time is----------"+meanTime+"ms");

    }
    public static void main(String[] args) throws SQLException, ExecutionException, InterruptedException {
     /*   int length=25000;
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
            SqlSortBenchMarkByPinYin(length);
            length*=2;
        }
        length=25000;
        for(int i=0;i<6;i++) {
            SqlSortBenchMarkByStroke(length);
            length*=2;
        }
        length=25000;*/
        int length=25000;
        for(int i=0;i<6;i++) {
            MultiThreadBenchMark(length);
            length*=2;
        }

    }
}
