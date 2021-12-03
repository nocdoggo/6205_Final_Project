package FinalProject.src.main.java.sort;

import FinalProject.src.main.java.utils.StringUtil;

/**
 * sort.LSD-from right to left
 * author:ZiFeng Xu
 * The length of the input array need to be fixed
 * return the sorted string array
 */

public class LSD {

    private static int[] index;
    //define the dictionary size, and it can be modified depending on the type of the words
    private static int R = 256;
    private static StringUtil su = new StringUtil();


    public static void sort(String[] s, int L){
        int len = s.length;
        String[] temp = new String[len];
        for(int i=L-1;i>=0;i--){
            index = new int[R+1];
            //calculate the frequency
            for(int j=0;j<len;j++){
                int t = su.getCharAt(s[j],i)+1;
                index[t]++;
            }
            //transfer the frequency to the index
            for(int k=0;k<R;k++){
                index[k+1] += index[k];
            }
            //save the result to a temp array
            for(int m=0;m<len;m++){
                int t = su.getCharAt(s[m],i);
                temp[index[t]++] = s[m];
            }
            //load the result back to the original array
            for(int n=0;n<len;n++){
                s[n] = temp[n];
            }
        }
    }

    public static void main(String[] args) {
        String[] a= {"abc1","abc2","abc1","acd2","xzf1","a1","ab1","a2"};
        String[] s= {"liuchiping","hongwensheng","fanhuihui","suhuimin","gaominzheng", "caoyude", "yuanjipeng", "shudongmei", "yanglaxiang",
                "xx"};
        int max = su.getMaxLength(s);
        LSD.sort(s,max);
        for(int i = 0; i < s.length; i++)
        {
            System.out.println(s[i]);
        }
    }
}
