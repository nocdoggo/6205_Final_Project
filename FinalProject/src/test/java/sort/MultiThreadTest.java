package sort;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.Assert.assertArrayEquals;

public class MultiThreadTest {
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
    long[] testorder1=new long[999998];
    long[] rightorder1=new long[999998];
    public  void transfer(String[] x1,String[] x2){
        for(int i=0;i<testorder1.length;i++){
            testorder1[i]= Long.parseLong(x1[i]);
            rightorder1[i]= Long.parseLong(x2[i]);
        }

    }
    File file = new File("C:\\Users\\94868\\Desktop\\INFO6205\\project\\chineseshuffle,codestroke.version.txt");
    String[] testorder = toText(file);
    File file1 = new File("C:\\Users\\94868\\Desktop\\INFO6205\\project\\strokeorder,codestroke.version.txt");
    String[] rightorder = toText(file1);

    @Test
    public void sort1() throws ExecutionException, InterruptedException {
        transfer(testorder,rightorder);


        List<Future> futureList = new ArrayList<>();
        // Get the maximum number of threads available for the given processor
        int max_thread_count = Runtime.getRuntime().availableProcessors();
        System.out.println("The maximum physical threads allowed on this processor is " + max_thread_count);
        int perBlockSize = testorder1.length/max_thread_count;
        long startTime = System.currentTimeMillis();

        // Launch the pool
        final ExecutorService poolingApp = Executors.newFixedThreadPool(max_thread_count);
        ArrayList<PoolMerge> mergers = new ArrayList<>();
        for (int i = 0; i < max_thread_count; i++) {


            String[] partialArr = new String[perBlockSize];


            System.arraycopy( testorder1, i*perBlockSize, partialArr, 0, perBlockSize );
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
        String[] mergered = new String[testorder1.length];
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
        Arrays.sort(testorder1);
        overallRuntime = System.currentTimeMillis() - startTime;
        System.out.println("With single thread, it takes " + overallRuntime + " milliseconds");
        assertArrayEquals(rightorder1, testorder1);
    }
}