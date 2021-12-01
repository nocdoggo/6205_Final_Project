package preprocess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;


public class int2Unicode2Pinyin {

    public static void main(String[] args) {

        List<List<String>> records = new ArrayList<>();
        try(
                BufferedReader br = new BufferedReader(new FileReader("book.csv")))

        {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
        }

    }


}
