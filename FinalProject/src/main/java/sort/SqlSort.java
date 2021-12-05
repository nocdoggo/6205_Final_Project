package sort;

import java.sql.*;

public class SqlSort {
    public static String[] sortByPinYin(int length) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\94868\\Desktop\\dbcore.db");
        Statement statement = conn.createStatement();
        statement.execute("select orig_name from converted ORDER BY pinyin_stroke_full");
        ResultSet tempCheck = statement.getResultSet();
        String name []=new String[1000000-2];
        int count=0;
        while(tempCheck.next()){
            name[count]=tempCheck.getString("orig_name");
            count++;

        }
        tempCheck.close();
        statement.close();
        conn.close();

        return name;

    }
    public static String[] sortByStroke(int length) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\94868\\Desktop\\dbcore.db");
        Statement statement = conn.createStatement();
        statement.execute("select orig_name from converted ORDER BY full_stroke");
        ResultSet tempCheck = statement.getResultSet();
        String name []=new String[1000000-2];
        int count=0;
        while(tempCheck.next()){
            name[count]=tempCheck.getString("orig_name");
            count++;
        }
        tempCheck.close();
        statement.close();
        conn.close();
        return name;
    }


}
