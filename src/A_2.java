/*
Имена входного и выходного файлов, а также абсолютный путь к ним могут
быть введены как параметры командной строки или храниться в файле.
2. В каждой строке стихотворения найти и заменить заданную подстроку
на подстроку иной длины.
 */
/*
ВЕЗДЕ
убрать дублирование кода, разделение слов. цикл for
вынести regex и replacement в отдельные переменные
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class A_2 {
    public static void main(String[] args) {
        String regexSubStringToDelete = "ин";
        String replacementString = "#########";
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
                    pw.printf("%s%n", line);
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
