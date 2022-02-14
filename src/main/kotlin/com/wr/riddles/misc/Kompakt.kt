package com.wr.riddles.misc

/**
 * Compact string, e.g. aaabbbcccdde -> a3b3c3d2e1
 */
fun main() {
    val str = readLine()!!

    println(solve(str))
}

private fun solve(str: String): String {
    val sb = StringBuilder()
    var counter = 1
    for (i in str.indices) {
        if (i < str.length - 2 && str[i] == str[i+1]) {
            counter++
        } else {
            sb.append(str[i]).append(counter)
            counter = 1
        }
    }
    return sb.toString()
}
