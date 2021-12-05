package sort;

import java.io.FileWriter;
import java.io.IOException;
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
    public static void output() throws SQLException, IOException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\94868\\Desktop\\dbcore.db");
        Statement statement = conn.createStatement();
        statement.execute("select pinyin_stroke_full from converted order by pinyin_stroke_full");
        ResultSet tempCheck = statement.getResultSet();

        String code []=new String[1000000-2];
        int count=0;
        while(tempCheck.next()){

            code[count]=tempCheck.getString("pinyin_stroke_full");
            count++;
        }

        FileWriter writer1 = new FileWriter("C:\\Users\\94868\\Desktop\\INFO6205\\project\\orderorder.csv");
        for (int index = 0; index < 1000000-2; index++) {
            writer1.append(code[index]);
            writer1.append("\n");
        }
        tempCheck.close();
        statement.close();
        conn.close();

    }
    public static void main(String[] args) throws SQLException, IOException  {
        output();
    }
    }


