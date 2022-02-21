import java.io.*;
import java.util.Collections;

/*
5. Найти в строке наибольшее число цифр, идущих подряд
 */
public class A_5 {
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
                int mostBigCountOfNumber = 0;
                for (int i = 1; i < s.length; i++) {
                    if (s[i].matches("[^0-9]{1,}")) {
                        char[] num = {'1','2','3','4','5','6','7','8','9','0'};
                        System.out.println(s[i]);
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
