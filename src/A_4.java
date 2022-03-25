import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;

/*
4. Найти и вывести слова текста, для которых последняя буква одного слова
совпадает с первой буквой следующего слова.
 */

/*
сделать обычный for (сделать указатель на СЛЕДУЮЩЕЕ слово). не допустить Возможную "ошибку"
 */
public class A_4 {
    public static void main(String[] args) {
        String[] s;
        BufferedReader bf = null;
        PrintWriter pw = null;
        try {
            Path file = Paths.get(System.getenv("USERPROFILE") + "\\Desktop\\Chapter_8_input.txt");
            bf = new BufferedReader(new FileReader(String.valueOf(file)));
            pw = new PrintWriter(new BufferedWriter(new FileWriter(System.getenv("USERPROFILE") + "\\Desktop\\Chapter_8_output.txt")));
            String tmp;
            if (Files.exists(file)) {
                while ((tmp = bf.readLine()) != null) {
                    s = tmp.split(" ");
                    for (int i = 0; i < s.length - 1; i++) {
                        if (s[i].toLowerCase(Locale.ROOT).charAt(s[i].length() - 1) == s[i + 1].toLowerCase(Locale.ROOT).charAt(0)) {
                            System.out.println(s[i] + " - " + s[i + 1]);
                        }
                    }
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
