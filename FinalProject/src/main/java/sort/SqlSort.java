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
        statement.execute("select full_stroke FROM converted  ORDER BY full_stroke");
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
        statement.execute("select full_stroke FROM converted   ");
        ResultSet tempCheck = statement.getResultSet();

        String code []=new String[1000000-2];
        int count=0;
        while(tempCheck.next()){

            code[count]=tempCheck.getString("full_stroke");

            count++;
        }

        FileWriter writer1 = new FileWriter("C:\\Users\\94868\\Desktop\\INFO6205\\project\\chineseshuffle,codestroke.version.txt");
        for (int index = 0; index < code.length; index++) {

            writer1.append(code[index]);
            writer1.append("\n");
        }
        writer1.close();
        tempCheck.close();
        statement.close();
        conn.close();

    }
    public static void main(String[] args) throws SQLException, IOException  {
        output();
    }
    }


