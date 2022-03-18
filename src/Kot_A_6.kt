import java.io.*

/*
В каждой строке стихотворения подсчитать частоту повторяемости каждого слова и вывести эти слова в порядке
возрастания частоты повторяемости.
 */
/*
??????? ошибка NPE
 */
fun main() {
    var s: MutableList<String>
    var bf: BufferedReader? = null
    var pw: PrintWriter? = null
    try {
        bf = BufferedReader(FileReader(File("C:\\Users\\Admin\\Desktop\\", "Chapter_8_input.txt")))
        pw = PrintWriter(BufferedWriter(FileWriter(File("C:\\Users\\Admin\\Desktop\\", "Chapter_8_output.txt"))))
        var tmp: String
        while (bf.readLine().also { tmp = it } != null) {
            s = tmp.split(" ".toRegex()).toMutableList()
            var count = 0
            for (i in 0 until s.size - 1) {
                for (j in i + 1 until s.size) {
                    if (s[i] == s[j] && i != j) {
                        count += 1
                        println("${s[j]} повторяется $count раз")
                    }
                }
            }
        }
    } catch (e: IOException) {
        e.printStackTrace()
    } finally {
        if (bf != null) {
            try {
                bf.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
            pw?.close()
        }
    }
}