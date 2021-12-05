package sort;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;

public class SqlSortTest {
    public static String[] toText(File file){

        String[] res = new String[1000000-2];
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            int index=0;
            while((s = br.readLine())!=null&&index<res.length){
                res[index++] = s;
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }
    Map<String,String> map = new HashMap<>();
    File file1 = new File("C:\\Users\\94868\\Desktop\\INFO6205\\project\\pinyinorder(not considering polyphone.txt");
    String[] rightorder = toText(file1);
    File file = new File("C:\\Users\\94868\\Desktop\\INFO6205\\project\\strokerightorder.txt");
    String[] strokerightorder = toText(file);



    @Test
    public void sort1() throws SQLException {
        for(int i=0;i<100;i++) {

        }
        assertArrayEquals(rightorder, SqlSort.sortByPinYin(25000));
    }
    @Test
    public void sort2() throws SQLException {
        for(int i=0;i<100;i++) {

        }
        assertArrayEquals(rightorder, SqlSort.sortByPinYin(50000));
    }
    @Test
    public void sort3() throws SQLException{

        assertArrayEquals(rightorder, SqlSort.sortByPinYin(100000));
    }
    @Test
    public void sort4() throws SQLException {

        assertArrayEquals(rightorder, SqlSort.sortByPinYin(200000));
    }
    @Test
    public void sort5() throws SQLException {

        assertArrayEquals(rightorder, SqlSort.sortByPinYin(400000));
    }
    @Test
    public void sort6() throws SQLException {

        assertArrayEquals(rightorder, SqlSort.sortByPinYin(800000));
    }
    @Test
    public void sort7() throws SQLException{

        assertArrayEquals(rightorder, SqlSort.sortByPinYin(1000000-2));
    }
    @Test
    public void sort8() throws SQLException {

        assertArrayEquals(strokerightorder, SqlSort.sortByStroke(25000));
    }
    @Test
    public void sort9() throws SQLException {

        assertArrayEquals(strokerightorder, SqlSort.sortByStroke(50000));
    }
    @Test
    public void sort10() throws SQLException {

        assertArrayEquals(strokerightorder, SqlSort.sortByStroke(100000));
    }
    @Test
    public void sort11() throws SQLException {

        assertArrayEquals(strokerightorder, SqlSort.sortByStroke(200000));
    }
    @Test
    public void sort12() throws SQLException {

        assertArrayEquals(strokerightorder, SqlSort.sortByStroke(400000));
    }
    @Test
    public void sort13() throws SQLException {

        assertArrayEquals(strokerightorder, SqlSort.sortByStroke(800000));
    }
    @Test
    public void sort14() throws SQLException {

        assertArrayEquals(strokerightorder, SqlSort.sortByStroke(1000000-2));
    }
}


