package preprocess;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import java.util.Properties;


public class int2Unicode2Pinyin {

    public static void main(String[] args) throws IOException {

        List<List<String>> records = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader("D:\\GitHub\\6205_Final_Project\\FinalProject\\src\\main\\java\\preprocess\\lookupDB_no_header.csv"))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int leng = records.size();
        String[] pinyinToneStroke = new String[leng];
        String[] pinyinTone = new String[leng];
        String[] pinyinOnly = new String[leng];

        // Testing
        System.out.println("Testing single unit extraction :" + records.get(0).get(2));
        System.out.println("Testing whole cell extraction :" + records.get(0));

        pinyinToneStroke = stripUnicode(records);
        pinyinTone = stripUnicodePinyinTone(records);
        pinyinOnly = stripUnicodePinyinOnly(records);
        System.out.println("Testing index array :" + pinyinToneStroke[1]);
//        System.out.println("The char is :" + String.valueOf(Character.toChars(pinyinToneStroke[1070])));

        // Write out to csv
        FileWriter writer = new FileWriter("D:\\GitHub\\6205_Final_Project\\FinalProject\\src\\main\\java\\preprocess\\pinyinToneStroke.csv");
        for (int index = 0; index < leng; index++) {
            writer.append(pinyinToneStroke[index]);
            writer.append("\n");
        }

        writer.close();

        FileWriter writer2 = new FileWriter("D:\\GitHub\\6205_Final_Project\\FinalProject\\src\\main\\java\\preprocess\\pinyinTone.csv");
        for (int index = 0; index < leng; index++) {
            writer2.append(pinyinTone[index]);
            writer2.append("\n");
        }

        writer2.close();

        FileWriter writer3 = new FileWriter("D:\\GitHub\\6205_Final_Project\\FinalProject\\src\\main\\java\\preprocess\\pinyinOnly.csv");
        for (int index = 0; index < leng; index++) {
            writer3.append(pinyinOnly[index]);
            writer3.append("\n");
        }

        writer3.close();



    }

//    public static int[] stripUnicode(List<List<String>> records) {
    public static String[] stripUnicode(List<List<String>> records) {
//        List<Integer> unicodeRecordTemp = new ArrayList<>();
        int leng = records.size();
        int[] unicodeRecord = new int[leng];
        String[] tempChar = new String[leng];
        String[] unicodeRecordFinale = new String[leng];

        // Now we traverse the list to obtain the unicode, cuz I am dumb
        for (int idx = 0; idx < leng; idx ++){
            unicodeRecord[idx] = Integer.parseInt(records.get(idx).get(1));
//            System.out.println(Integer.parseInt(records.get(idx).get(1)));
            tempChar[idx] = String.valueOf(Character.toChars(unicodeRecord[idx]));
//            System.out.println(tempChar[idx]);

            try{
                // Add stroke number in, but needs to pad.
                if (Integer.parseInt(records.get(idx).get(2)) < 10) {
                    unicodeRecordFinale[idx] = getFullSpelling(tempChar[idx])+ "0" +  records.get(idx).get(2);
                } else {
                    unicodeRecordFinale[idx] = getFullSpelling(tempChar[idx])+ records.get(idx).get(2);
                }
                // Do note that, there are 5 tones, the no-tone is considered as 5.
            } catch (Exception e) {
                // Max take 7-digits
                unicodeRecordFinale[idx] = "zzzzzz599";
            }


//            System.out.println(unicodeRecordFinale[idx]);

        }

        return unicodeRecordFinale;
    }

    public static String[] stripUnicodePinyinTone(List<List<String>> records) {
//        List<Integer> unicodeRecordTemp = new ArrayList<>();
        int leng = records.size();
        int[] unicodeRecord = new int[leng];
        String[] tempChar = new String[leng];
        String[] unicodeRecordFinale = new String[leng];

        // Now we traverse the list to obtain the unicode, cuz I am dumb
        for (int idx = 0; idx < leng; idx ++){
            unicodeRecord[idx] = Integer.parseInt(records.get(idx).get(1));
//            System.out.println(Integer.parseInt(records.get(idx).get(1)));
            tempChar[idx] = String.valueOf(Character.toChars(unicodeRecord[idx]));
//            System.out.println(tempChar[idx]);

            try{
//                // Add stroke number in, but needs to pad.
//                if (Integer.parseInt(records.get(idx).get(2)) < 10) {
//                    unicodeRecordFinale[idx] = getFullSpelling(tempChar[idx])+ "0" +  records.get(idx).get(2);
//                } else {
//                    unicodeRecordFinale[idx] = getFullSpelling(tempChar[idx])+ records.get(idx).get(2);
//                }
                unicodeRecordFinale[idx] = getFullSpelling(tempChar[idx]);
                // Do note that, there are 5 tones, the no-tone is considered as 5.
            } catch (Exception e) {
                // Max take 7-digits
                unicodeRecordFinale[idx] = "zzzzzz5";
            }


//            System.out.println(unicodeRecordFinale[idx]);

        }

        return unicodeRecordFinale;
    }

    public static String[] stripUnicodePinyinOnly(List<List<String>> records) {
//        List<Integer> unicodeRecordTemp = new ArrayList<>();
        int leng = records.size();
        int[] unicodeRecord = new int[leng];
        String[] tempChar = new String[leng];
        String[] unicodeRecordFinale = new String[leng];

        // Now we traverse the list to obtain the unicode, cuz I am dumb
        for (int idx = 0; idx < leng; idx ++){
            unicodeRecord[idx] = Integer.parseInt(records.get(idx).get(1));
//            System.out.println(Integer.parseInt(records.get(idx).get(1)));
            tempChar[idx] = String.valueOf(Character.toChars(unicodeRecord[idx]));
//            System.out.println(tempChar[idx]);

            try{
//                // Add stroke number in, but needs to pad.
//                if (Integer.parseInt(records.get(idx).get(2)) < 10) {
//                    unicodeRecordFinale[idx] = getFullSpelling(tempChar[idx])+ "0" +  records.get(idx).get(2);
//                } else {
//                    unicodeRecordFinale[idx] = getFullSpelling(tempChar[idx])+ records.get(idx).get(2);
//                }
                unicodeRecordFinale[idx] = getPinyinOnly(tempChar[idx]);
                // Do note that, there are 5 tones, the no-tone is considered as 5.
            } catch (Exception e) {
                // Max take 7-digits
                unicodeRecordFinale[idx] = "zzzzzz";
            }


//            System.out.println(unicodeRecordFinale[idx]);

        }

        return unicodeRecordFinale;
    }

    public static String getFullSpelling(String src) {

        char[] t1 = null;
        t1 = src.toCharArray();
        String[] t2 = new String[t1.length];
        HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();

        t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        t3.setToneType(HanyuPinyinToneType.WITH_TONE_NUMBER);
        t3.setVCharType(HanyuPinyinVCharType.WITH_V);
        String t4 = "";
        int t0 = t1.length;
        try {
            for (int i = 0; i < t0; i++) {
                // 判断是否为汉字字符
                if (java.lang.Character.toString(t1[i]).matches(
                        "[\\u4E00-\\u9FA5]+")) {
                    t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);
                    t4 += t2[0];
                } else
                    t4 += java.lang.Character.toString(t1[i]);
            }
            // System.out.println(t4);
            return t4;
        } catch (BadHanyuPinyinOutputFormatCombination e1) {
            e1.printStackTrace();
        }
        return t4;
    }

    public static String getPinyinOnly(String src) {

        char[] t1 = null;
        t1 = src.toCharArray();
        String[] t2 = new String[t1.length];
        HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();

        t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        t3.setVCharType(HanyuPinyinVCharType.WITH_V);
        String t4 = "";
        int t0 = t1.length;
        try {
            for (int i = 0; i < t0; i++) {
                // 判断是否为汉字字符
                if (java.lang.Character.toString(t1[i]).matches(
                        "[\\u4E00-\\u9FA5]+")) {
                    t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);
                    t4 += t2[0];
                } else
                    t4 += java.lang.Character.toString(t1[i]);
            }
            // System.out.println(t4);
            return t4;
        } catch (BadHanyuPinyinOutputFormatCombination e1) {
            e1.printStackTrace();
        }
        return t4;
    }

    // Obtain the first letter of the Chinese string
    public static String getHeadPinYinOnly(String str) {

        String convert = "";
        for (int j = 0; j < str.length(); j++) {
            char word = str.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert += pinyinArray[0].charAt(0);
            } else {
                convert += word;
            }
        }
        return convert;
    }

    // 将字符串转移为ASCII码
    public static String getASCIIForm(String cnStr) {
        StringBuffer strBuf = new StringBuffer();
        byte[] bytewiseGBK2312 = cnStr.getBytes();
        for (int i = 0; i < bytewiseGBK2312.length; i++) {
            strBuf.append(Integer.toHexString(bytewiseGBK2312[i] & 0xff));
        }
        return strBuf.toString();
    }


}
