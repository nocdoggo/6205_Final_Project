package sort;

import FinalProject.src.main.java.utils.StringUtil;

public class DualPivotSort {

    private static StringUtil su = new StringUtil();
    private static FinalProject.src.main.java.sort.InsertionSort insetion = new FinalProject.src.main.java.sort.InsertionSort();
    private static final int M = 4;

    public static void sort (String[] input){
        int L = input.length;
        sort (input, 0, L-1);
    }

    private static void sort(String[] s, int low, int high) {

        if (high<=low) {
            return;
        }else if(high<low+M){
            insetion.sort(s, low, high);
            return;
        }
        //default choose the first node and the second node as two pivot
        String pivot1 = s[low];
        String pivot2 = s[high];
        if (pivot1.compareTo(pivot2)>0){
            su.swap(s, low, high);
            pivot1 = s[low];
            pivot2 = s[high];
        }
        else if (pivot1.equals(pivot2)){
            while (pivot1.equals(pivot2) && low<high){
                low++;
                pivot1 = s[low];
            }
        }

        int i = low + 1;
        int lt = low + 1;
        int gt = high - 1;

        while (i<=gt){
            if (s[i].compareTo(pivot1)<0){
                su.swap(s, i++, lt++);
            }
            else if (pivot2.compareTo(s[i])<0){
                su.swap(s, i, gt--);
            }
            else{
                i++;
            }

        }

        su.swap(s, low, --lt);
        su.swap(s, high, ++gt);

        sort(s, low, lt-1);
        sort (s, lt+1, gt-1);
        sort(s, gt+1, high);

    }

    public static void main(String[] args) {
        String[] a= {"a","abc","abcd","abc2","she", "sells", "snell liabrary", "by", "the", "sunshine", "zhangfei", "guanyu", "shells", "jianzihao",
                "sells", "zhangsan", "lisi", "jahahh"};

        DualPivotSort.sort(a);
        for(int i = 0; i < a.length; i++)
        {
            System.out.println(a[i]);
        }
    }


}
