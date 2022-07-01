package com.example.secondexam


fun main(){
    var arr  = arrayOf<String>("kata", "akat", "bia")
    print(groupAnagrams(arr))

}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val resultingMap = mutableMapOf<Map<Char, Int>, List<String>>()

    strs.forEach { str ->
        val key = mutableMapOf<Char, Int>()
        str.forEach {
            key[it] = (key[it] ?: 0) + 1
        }

        resultingMap[key] = (resultingMap[key] ?: listOf<String>()) + str
    }

    return resultingMap.values.toList()
}