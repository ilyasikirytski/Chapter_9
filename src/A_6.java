import java.io.*;
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
        BufferedReader bf = null;
        PrintWriter pw = null;
        try {
            bf = new BufferedReader(new FileReader(new File("C:\\Users\\Admin\\Desktop\\", "Chapter_8_input.txt")));
            pw = new PrintWriter(new BufferedWriter(new FileWriter(new File("C:\\Users\\Admin\\Desktop\\", "Chapter_8_output.txt"))));
            String line;
            while ((line = bf.readLine()) != null) {
                words = line.split(" ");
                int countOfWordRepeating = 0;
                for (int i = 0; i < words.length - 1; i++) {
                    for (int j = i + 1; j < words.length; j++) {
                        if (words[i].equals(words[j]) && i != j) {
                            countOfWordRepeating += 1;
                            System.out.printf(words[j] + " повторяется %s раз\n", countOfWordRepeating);
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
