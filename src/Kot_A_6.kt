import java.nio.file.Paths
import kotlin.io.path.exists
import kotlin.io.path.readLines

/*
В каждой строке стихотворения подсчитать частоту повторяемости каждого слова и вывести эти слова в порядке
возрастания частоты повторяемости.
 */

fun main() {
    var words: List<String>
    val file = Paths.get(System.getenv("USERPROFILE") + "\\Desktop\\Chapter_8_input.txt")
    if (file.exists()) {
        file.readLines().forEach { line ->
            val repeatingWords = LinkedHashMap<String, Int>()
            words = line.split("\\s+".toRegex())
            for (word in words) {
                repeatingWords[word] = (repeatingWords[word] ?: 0) + 1
            }
//            val list = ArrayList<Map.Entry<String, Int>>(repeatingWords.entries).sortBy { it.value }
//            val list = repeatingWords.entries.sortedBy { it.value }
            repeatingWords.entries.sortedBy { it.value }
                .forEach { print("${it.key} ") }
            println()
//            list.sortedByDescending { it.value }
//            for ((key, value) in list) {
//                print("$key ")
//            }
//            println()
        }
    }
}