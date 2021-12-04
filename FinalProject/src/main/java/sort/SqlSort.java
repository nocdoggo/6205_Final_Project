package sort;

import java.sql.*;

public class SqlSort {
    public static void sort() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\94868\\Desktop\\dbcore.db");
        System.out.println("Connected!");
        Statement statement = conn.createStatement();
        statement.execute("select orig_name from converted ORDER BY pinyin_full");
        ResultSet tempCheck = statement.getResultSet();
        while(tempCheck.next()){
            System.out.println(tempCheck.getString("Name") + " " );
        }
        tempCheck.close();

        statement.close();
        conn.close();
    }
    public static void main(String[] args) throws SQLException {
        sort();
    }
}
