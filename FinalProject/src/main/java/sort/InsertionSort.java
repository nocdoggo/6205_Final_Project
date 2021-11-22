package sort;

import utils.StringUtil;

public class InsertionSort {
    private static StringUtil su = new StringUtil();
    public static void sort(String[] s, int low, int high){
        for(int i=low; i<high;i++){
            for(int j=i+1;j>low;j--){
                if(s[j-1].compareTo(s[j])<=0) {
                    break;
                }
                su.swap(s,j,j-1);
            }
        }

    }


}
