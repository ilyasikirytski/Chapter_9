/*
Имена входного и выходного файлов, а также абсолютный путь к ним могут
быть введены как параметры командной строки или храниться в файле.
3. В каждой строке найти слова, начинающиеся с гласной буквы.
 */

/*
output должен содержать только список нужных слов
можно использовать классы regex и pattern
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class A_3 {

    public static void main(String[] args) {
        String[] words;
        String regEx = "[ауоыиэяюёеАУОЫИЭЯЮЁЕ].*";
        BufferedReader bf = null;
        PrintWriter pw = null;
        try {
            Path file = Paths.get(System.getenv("USERPROFILE") + "\\Desktop\\Chapter_8_input.txt");
            bf = new BufferedReader(new FileReader(String.valueOf(file)));
            pw = new PrintWriter(new BufferedWriter(new FileWriter(System.getenv("USERPROFILE") + "\\Desktop\\Chapter_8_output.txt")));
            String line;
            if (Files.exists(file)) {
                while ((line = bf.readLine()) != null) {
                    words = line.split(" ");
                    for (String word : words) {
                        if (word.matches(regEx)) {
                            System.out.println(word);
                            pw.printf("%s%n", word);
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
