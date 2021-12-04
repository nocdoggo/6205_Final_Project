package  sort;

import utils.StringUtil;

public class MSD {
    private static int R=256;
    private static String[] temp;
    private static StringUtil su = new StringUtil();
    private static final int M = 4;
    private static final sort.InsertionSort insertion = new sort.InsertionSort();


    public static void sort(String[] s,int low,int high,int position){
        if(high<=low){
            return;
        }else if(high<low+M){
            insertion.sort(s, low, high);
            return;
        }
        int[] count=new int[R+2];
        for(int i=low;i<=high;i++){
            count[su.getChar(s[i],position)+2]++;
        }
        for(int r=0;r<R+1;r++){
            count[r+1]+=count[r];
        }
        for(int i=low;i<=high;i++){
            temp[count[su.getChar(s[i],position)+1]++]=s[i];
        }

        if (high>=low){
            System.arraycopy(temp, 0, s, low, high - low+1);
        }
        for(int r=0;r<R;r++){
            int newLow = low + count[r];
            int newHigh = low+count[r+1]-1;
            sort(s,newLow,newHigh,position+1);
        }
    }

    public static void sort(String[] s){
        int N = s.length;
        temp = new String[N];
        sort(s,0,N-1,0);
    }



    public static void main(String[] args){
        String[] a= {"liuchiping","hongwensheng","fanhuihui","suhuimin","gaominzheng", "caoyude", "yuanjipeng", "shudongmei", "yanglaxiang",
            "xx"};
        MSD.sort(a);
        for(int i = 0; i < a.length; i++){
            System.out.println(i+"="+a[i]);
        } 
     }

}
