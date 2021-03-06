package sort;

import java.util.Arrays;

public class MergeProcess {
    private String[] unsorted, sorted;

    public MergeProcess( String[] unsorted ) {
        this.unsorted = unsorted;
    }


    public void sort() {
        // Initialize the mid-point index
        int midIdx;
        String[] left, right;


        midIdx = unsorted.length / 2;
        left = new String[midIdx];
        // array length may be odd
        right = new String[unsorted.length - midIdx];
        System.arraycopy( unsorted, 0, left, 0, midIdx );
        System.arraycopy( unsorted, midIdx, right, 0, unsorted.length - midIdx );
        // array sort
        Arrays.sort(left);
        Arrays.sort(right);
        sorted = merge(left, right);
    }

    public static String[] merge( String[] leftPart, String[] rightPart ) {
        int cursorLeft = 0, cursorRight = 0, counter = 0;
        String[] merged = new String[leftPart.length + rightPart.length];
        while ( cursorLeft < leftPart.length && cursorRight < rightPart.length ) {
            if (leftPart[cursorLeft].compareTo(rightPart[cursorRight] ) < 0 ) {
                merged[counter] = leftPart[cursorLeft];
                cursorLeft++;
            } else {
                merged[counter] = rightPart[cursorRight];
                cursorRight++;
            }
            counter++;
        }
        if ( cursorLeft < leftPart.length ) {
            System.arraycopy( leftPart, cursorLeft, merged, counter, merged.length - counter );
        }
        if ( cursorRight < rightPart.length ) {
            System.arraycopy( rightPart, cursorRight, merged, counter, merged.length - counter );
        }
        return merged;
    }
    public String[] getSorted() {
        return sorted;
    }
}

