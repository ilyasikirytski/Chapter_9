import java.io.*;
/*
В каждой строке стихотворения подсчитать частоту повторяемости каждого слова и вывести эти слова в порядке
возрастания частоты повторяемости.
 */

public class A_6 {
    public static void main(String[] args) {
        String[] s;
        BufferedReader bf = null;
        PrintWriter pw = null;
        try {
            bf = new BufferedReader(new FileReader(new File("C:\\Users\\Admin\\Desktop\\", "Chapter_8_input.txt")));
            pw = new PrintWriter(new BufferedWriter(new FileWriter(new File("C:\\Users\\Admin\\Desktop\\", "Chapter_8_output.txt"))));
            String tmp;
            while ((tmp = bf.readLine()) != null) {
                s = tmp.split(" ");
                int count = 0;
                for (int i = 0; i < s.length - 1; i++) {
                    for (int j = i + 1; j < s.length; j++) {
                        if (s[i].equals(s[j]) && i != j) {
                            count += 1;
                            System.out.printf(s[j] + " повторяется %s раз\n", count);
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
