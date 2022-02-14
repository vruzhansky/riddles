package com.wr.riddles.misc

import kotlin.math.pow

/**
 * Convert binary to decimal
 * e.g. 100 -> 8
 */
fun main() {
    val str = readLine()!!

    println(solve(str))
}

private fun solve(str: String): Int {
    var result = 0
    for (i in str.indices) {
        if (str[i] == '1') {
            result += 2.0.pow(str.length - 1 - i).toInt()
        }
    }
    return result
}
