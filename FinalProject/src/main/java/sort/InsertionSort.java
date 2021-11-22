package sort;

public class InsertionSort {

    public static void sort(String[] s, int low, int high){
        for(int i=low; i<high;i++){
            for(int j=i+1;j>low;j--){
                if(s[j-1].compareTo(s[j])<=0) {
                    break;
                }
                swap(s,j,j-1);
            }
        }

    }

    public static void swap(String[] s, int a, int b){
        if(s.length==0) return;
        String temp = s[a];
        s[a] = s[b];
        s[b] = temp;
        return;
    }
}
