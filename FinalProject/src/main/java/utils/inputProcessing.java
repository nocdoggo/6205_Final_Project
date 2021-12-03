package utils;

import java.sql.*;

public class inputProcessing {

    public static void main(String[] args) {
        try{
            Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\GitHub\\6205_Final_Project\\FinalProject\\src\\main\\database\\dbcore.db");
            System.out.println("Connected!");
//            conn.setAutoCommit(false);
            Statement statement = conn.createStatement();
            statement.execute("SELECT * FROM catalog");
            ResultSet tempCheck = statement.getResultSet();
            while(tempCheck.next()){
                System.out.println(tempCheck.getString("stroke_index") + " " +
                                    tempCheck.getString("pinyin_tone_stroke"));
            }
            tempCheck.close();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection failure, please check on the jdbc.");
        }

    }


}
