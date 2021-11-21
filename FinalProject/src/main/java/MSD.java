public class MSD {
    private static int R = 256;     
    private static final int M = 3;
    private static String[] aux;   

    private static int charAt(String s, int d)
    {
        if(d < s.length())
        {
            return s.charAt(d);
        }
        else
        {
            return -1;
        }
    }

    public static void sort(String[] a)
    {
        int N = a.length;
        aux = new String[N];
        sort(a, 0, N-1, 0);
    }

    private static void sort(String[] a, int low, int high, int d){
        if(high <= low + M){
            InsertionSort(a, low, high, d);
            return;
        }

        int[] count = new int[R+2]; 
        for(int i = low; i <= high; i++){
            count[charAt(a[i], d) + 2]++;
        }

        for(int r = 0; r < R+1; r++){
            count[r+1] +=count[r];
        }

        for(int i = low; i <= high; i++){
            aux[count[charAt(a[i], d) + 1]++] = a[i];
        }

        for(int i = low; i <= high; i++) {
            a[i] = aux[i-low];
        }

        for(int r = 0; r < R; r++){
            sort(a, low + count[r], low + count[r+1] - 1, d+1);
        }
    }

    private static void InsertionSort(String[] a, int low, int high, int d) 
    {   
        for( int i = low; i < high; i++) 
        { 
            for( int j=i+1; j>low; j--) 
            {               
                if( a[j-1].compareTo(a[j]) <= 0)
                {
                    break;
                }
                String temp = a[j];
                a[j] = a[j-1];
                a[j-1] = temp;              
            }
        }  
    }

    public static void main(String[] args) 
     {
        String[] a= {"a","abc","abd","she", "sells", "snell liabrary", "by", "the", "sunshine", "zhangfei", "guanyu", "shells", "jianzihao",
            "sells", "zhangsan", "lisi", "jahahh"};

        MSD.sort(a);
        for(int i = 0; i < a.length; i++)
        {
            System.out.println(a[i]);
        } 
     }

}
