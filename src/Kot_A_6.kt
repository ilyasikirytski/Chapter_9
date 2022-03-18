import java.io.File

/*
В каждой строке стихотворения подсчитать частоту повторяемости каждого слова и вывести эти слова в порядке
возрастания частоты повторяемости.
 */

fun main() {
    val s: MutableList<String> = mutableListOf()
    val str: String

    val file = File("C:\\Users\\Admin\\Desktop\\", "Chapter_8_input.txt")
    str = file.readText()
    s.addAll((str.split(" ".toRegex())))
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