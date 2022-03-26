import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/*
В каждой строке стихотворения подсчитать частоту повторяемости каждого слова и вывести эти слова в порядке
возрастания частоты повторяемости.
 */
/*
алгоритм не корректный
выводит 3 2 1...
доработать вывод слов в порядке возрастания частоты повторяемости (по заданию)
 */
public class A_6 {
    public static void main(String[] args) {
        String[] words;
        Map<String, Integer> repeatingWords = new HashMap<>();
        BufferedReader bf = null;
        PrintWriter pw = null;
        try {
            Path file = Paths.get(System.getenv("USERPROFILE") + "\\Desktop\\Chapter_8_input.txt");
            bf = new BufferedReader(new FileReader(String.valueOf(file)));
            pw = new PrintWriter(new BufferedWriter(new FileWriter(System.getenv("USERPROFILE") + "\\Desktop\\Chapter_8_output.txt")));
            String line;
            if (Files.exists(file)) {
                while ((line = bf.readLine()) != null) {
                    words = line.split("\\s+");
                    for (String word : words) {
                        if (!repeatingWords.containsKey(word)) {
                            repeatingWords.put(word, 0);
                        }
                        repeatingWords.put(word, repeatingWords.get(word) + 1);
                    }
                }
            }

            List<Map.Entry<String, Integer>> list = new ArrayList<>(repeatingWords.entrySet());
            list.sort(new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o1.getValue() - o2.getValue();
                }
            });
            for (Map.Entry<String, Integer> item : list) {
                String key = item.getKey();
                int value = item.getValue();
                System.out.println(key + " " + value);
            }

        } catch (
                IOException e) {
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
