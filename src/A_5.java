import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
5. Найти в строке наибольшее число цифр, идущих подряд
 */

/*
найти все повторы цифр и среди них найти самое большое.
зачем replace? Сделать сравнение самого большого
 */
public class A_5 {
    public static void main(String[] args) {
        String[] s;
        BufferedReader bf = null;
        PrintWriter pw = null;
        ArrayList<Integer> integersArrayList = new ArrayList<>();
        int result = 0;
        try {
            Path file = Paths.get(System.getenv("USERPROFILE") + "\\Desktop\\Chapter_8_input.txt");
            bf = new BufferedReader(new FileReader(String.valueOf(file)));
            pw = new PrintWriter(new BufferedWriter(new FileWriter(System.getenv("USERPROFILE") + "\\Desktop\\Chapter_8_output.txt")));
            String tmp;
            if (Files.exists(file)) {
                while ((tmp = bf.readLine()) != null) {
                    s = tmp.split(" ");
                    for (int i = 1; i < s.length; i++) {
                        Pattern pattern = Pattern.compile("\\d+\\S?\\d*");
                        Matcher matcher = pattern.matcher(s[i]);
                        while (matcher.find()) {
                            String value = s[i].substring(matcher.start(), matcher.end());
                            integersArrayList.add(Integer.parseInt(value));
                            if (result < Integer.parseInt(value)) {
                                result = (Integer.parseInt(value));
                            }
                        }
                    }
                }
                System.out.println("Список всех найденых чисел:");
                for (Integer i : integersArrayList) {
                    System.out.println(i);
                }
                System.out.println("Наибольшее число в тексте - " + result);
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
