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
/*
считать ВЕСЬ ТЕКС, а не одну строчку. и потом уже сравнивать слова.
 */
public class A_4 {
    public static void main(String[] args) {
        String[] word;
        BufferedReader bf = null;
        PrintWriter pw = null;
        try {
            Path file = Paths.get(System.getenv("USERPROFILE") + "\\Desktop\\Chapter_8_input.txt");
            bf = new BufferedReader(new FileReader(String.valueOf(file)));
            pw = new PrintWriter(new BufferedWriter(new FileWriter(System.getenv("USERPROFILE") + "\\Desktop\\Chapter_8_output.txt")));
            String line;
            if (Files.exists(file)) {
                while ((line = bf.readLine()) != null) {
                    word = line.split(" ");
                    for (int i = 0; i < word.length - 1; i++) {
                        // вынести указатели слов в отдельные переменные в цикле
                        // и сразу перевести word в нижний регистр.
                        String firstWord = word[i].toLowerCase(Locale.ROOT);
                        String nextWord = word[i + 1].toLowerCase(Locale.ROOT);
                        if (firstWord.charAt(word[i].length() - 1) == nextWord.charAt(0)) {
                            System.out.println(word[i] + " - " + word[i + 1]);
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
