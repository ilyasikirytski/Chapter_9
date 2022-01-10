import java.io.*;

/*
4. Найти и вывести слова текста, для которых последняя буква одного слова
совпадает с первой буквой следующего слова.
 */
public class A_4 {
    public static void main(String[] args) {
        String[] s;
        BufferedReader bf = null;
        PrintWriter pw = null;
        try {
            bf = new BufferedReader(new FileReader(new File("C:\\Users\\Admin\\Desktop\\", "Chapter_8_input.txt")));
            pw = new PrintWriter(new BufferedWriter(new FileWriter(new File("C:\\Users\\Admin\\Desktop\\", "Chapter_8_output.txt"))));
            String tmp = "";
            while ((tmp = bf.readLine()) != null) {
                s = tmp.split(" ");
                for (String res : s) {
                    if (res.charAt(res.length() - 1) == res.charAt(0)) {
                        System.out.println(res);
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
