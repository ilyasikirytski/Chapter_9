import java.io.BufferedReader
import java.io.FileReader
import java.nio.file.Paths
import kotlin.io.path.exists

/*
В каждой строке стихотворения подсчитать частоту повторяемости каждого слова и вывести эти слова в порядке
возрастания частоты повторяемости.
 */

fun main() {
    var words: Array<String>
    val file = Paths.get(System.getenv("USERPROFILE") + "\\Desktop\\Chapter_8_input.txt")
    val bf = BufferedReader(FileReader(file.toString()))
    var line: String
    if (file.exists()) {
        while (bf.readLine().also { line = it } != null) {
            val repeatingWords = LinkedHashMap<String, Int>()
            words = line.split("\\s+".toRegex()).toTypedArray()
            for (word in words) {
                if (!repeatingWords.containsKey(word)) {
                    repeatingWords[word] = 0
                }
                repeatingWords[word] = repeatingWords[word]!! + 1
            }
            val list = ArrayList<Map.Entry<String, Int>>(repeatingWords.entries)
            list.sortedBy { it.value }.reversed()
            for ((key, value) in list) {
                print("$key ")
            }
            println()
        }
    }
}