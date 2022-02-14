package com.wr.riddles.misc

/**
 * looks for all possible substrings, e.g.
 * abc -> [a, ab, abc, b, bc]
 */
fun main() {
    val str = readLine()!!

    println(solve(str))
}

private fun solve(str: String): List<String> {
    val result = mutableListOf<String>()
    for (i in 0 until str.length - 1) {
        for (j in i  until str.length) {
            result.add(str.substring(i, j + 1))
        }

    }
    return result
}
