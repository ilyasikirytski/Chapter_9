/*
Имена входного и выходного файлов, а также абсолютный путь к ним могут
быть введены как параметры командной строки или храниться в файле.
3. В каждой строке найти слова, начинающиеся с гласной буквы.
 */

import java.io.*;

public class A_3 {
    public static void main(String[] args) {
        String[] s;
        BufferedReader bf = null;
        PrintWriter pw = null;
        try {
            bf = new BufferedReader(new FileReader(new File("C:\\Users\\Admin\\Desktop\\", "Chapter_8_input.txt")));
            pw = new PrintWriter(new BufferedWriter(new FileWriter(new File("C:\\Users\\Admin\\Desktop\\", "Chapter_8_output.txt"))));
            String tmp = "";
            while ((tmp = bf.readLine()) != null) {
                s = tmp.split(" ");
                for (String res : s) {
                    System.out.println(res.replaceAll("\\b[ауоыиэяюёеАУОЫИЭЯЮЁЕ]", "######"));
                    pw.printf("%s%n", res.replaceAll("\\b[ауоыиэяюёеАУОЫИЭЯЮЁЕ]", "######"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (pw != null) {
                    pw.close();
                }
            }
        }
    }
}
