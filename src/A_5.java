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
        BufferedReader bf = null;
        PrintWriter pw = null;
        ArrayList<Integer> integersArrayList = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+");
        int result = 0;
        try {
            Path file = Paths.get(System.getenv("USERPROFILE") + "\\Desktop\\Chapter_8_input.txt");
            bf = new BufferedReader(new FileReader(String.valueOf(file)));
            pw = new PrintWriter(new BufferedWriter(new FileWriter(System.getenv("USERPROFILE") + "\\Desktop\\Chapter_8_output.txt")));
            String line;
            if (Files.exists(file)) {
                while ((line = bf.readLine()) != null) {
                    Matcher matcher = pattern.matcher(line);
                    while (matcher.find()) {
                        String groupOfNumbers = matcher.group();
                        int number = Integer.parseInt(groupOfNumbers);
                        integersArrayList.add(number);
                        if (result < number) {
                            result = (number);
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
