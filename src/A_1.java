/*
Имена входного и выходного файлов, а также абсолютный путь к ним могут
быть введены как параметры командной строки или храниться в файле.
1. В каждой строке найти и удалить заданную подстроку.
 */

/*
использовать относительный путь
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class A_1 {
    public static void main(String[] args) {
        String regexSubStringToDelete = "о";
        String replacementString = "";
        BufferedReader bf = null;
        PrintWriter pw = null;
        try {
            Path file = Paths.get(System.getenv("USERPROFILE") + "\\Desktop\\Chapter_8_input.txt");
            bf = new BufferedReader(new FileReader(String.valueOf(file)));
            pw = new PrintWriter(new BufferedWriter(new FileWriter(System.getenv("USERPROFILE") + "\\Desktop\\Chapter_8_output.txt")));
            String line;
            if (Files.exists(file)) {
                while ((line = bf.readLine()) != null) {
                    line = line.replaceAll(regexSubStringToDelete, replacementString);
                    System.out.println(line);
                    pw.printf(line);
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