package sort;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class MultiMergeSort {
    public static void main(String[] args) throws Exception {
        // Create random data/////////////////////////////
        int arrSize = 1_000_000_0;
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
}
