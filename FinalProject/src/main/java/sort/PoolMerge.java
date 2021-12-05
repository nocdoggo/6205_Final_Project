package sort;
import java.util.Arrays;

public class PoolMerge implements Runnable{
    private String[] unsorted, sorted;

    public PoolMerge(String[] unsorted) {
        this.unsorted = unsorted;
    }

    public void run() {
        int midpoint;
        String[] left, right;
        // array is sorted

        midpoint = unsorted.length / 2;
        left = new String[midpoint];
        right = new String[unsorted.length - midpoint];
        // Now split one array into two
        System.arraycopy(unsorted, 0, left, 0, midpoint);
        System.arraycopy(unsorted, midpoint, right, 0, unsorted.length - midpoint);
        MergeProcess leftSort = new MergeProcess(left);
        MergeProcess rightSort = new MergeProcess(right);
        leftSort.sort();
        rightSort.sort();

        // Now after the sort we merge
        sorted = MergeProcess.merge(leftSort.getSorted(), rightSort.getSorted());

    }
    public String[] getSorted() {
        return sorted;
    }
}
