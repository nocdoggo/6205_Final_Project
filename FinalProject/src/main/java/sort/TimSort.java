package sort;



import utils.StringUtil;


import java.util.Arrays;



public class TimSort {
    private static StringUtil su;
    /**
     * refer to the java util source package
     * @param s
     */
    public static void sort(String[] s) {

        su.sortByTim(s);
    }

    public static void main(String[] args) {
        String[] a= {"a","abc","abcd","abc2","she", "sells", "snell liabrary", "by", "the", "sunshine", "zhangfei", "guanyu", "shells", "jianzihao",
                "sells", "zhangsan", "lisi", "jahahh"};

        TimSort.sort(a);
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }
}
