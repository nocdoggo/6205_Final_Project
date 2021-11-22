package utils;

/**
 * Pre-operation of input array
 */
public class StringUtil {

    static StringUtil su = new StringUtil();
    /**
     * Auto append 0 to shorter String to make all String elements to the same length
     * @param s
     * @param size
     */
    public static void autoAppend(String[] s, int size){
        int max = su.getMaxLength(s);
        for(int i=0;i<s.length;i++){
           while(s[i].length()<max){
               s[i]+="0";
           }
        }
        return;
    }

    /**
     * get the max length of the string element in an array
     * @param s
     * @return max length
     */
    public static int getMaxLength(String[] s){
        int max = 0;
        for(int i=0;i<s.length;i++){
            max = Math.max(s[i].length(),max);
        }
        return max;
    }

    /**
     *
     * @param s
     * @param position
     * @return
     */
    public int getCharAt(String s, int position){
        if(position>=s.length()){
            return 0;
        }
        return s.charAt(position);
    }

    public int getChar(String s, int position){
        if(position<s.length()){
            return s.charAt(position);
        }else{
            return -1;
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
