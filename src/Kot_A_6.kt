import java.io.File

/*
В каждой строке стихотворения подсчитать частоту повторяемости каждого слова и вывести эти слова в порядке
возрастания частоты повторяемости.
 */

fun main() {
    val repeatingWords: HashMap<String, Int> = HashMap()
    val words: ArrayList<String> = ArrayList<String>()
    val str: String
    val file = File(System.getenv("USERPROFILE") + "\\Desktop\\Chapter_8_input.txt")
    str = file.readText()
    words.addAll(str.split("\\s+".toRegex()))
    for (word in words) {
        if (!repeatingWords.containsKey(word)) {
            repeatingWords[word] = 0
        }
        repeatingWords[word] = repeatingWords[word]!! + 1
    }

    val result = repeatingWords.toList().sortedBy { (_, value) -> value }.toMap()
    for (s in result) {
        println("${s.key} - ${s.value}")
    }
}