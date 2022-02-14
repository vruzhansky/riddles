package com.wr.riddles.misc

/**
 * Reduce number by summing its digits until there is a single one, e.g. 789 -> 24 -> 6
 */
fun main() {
    val num = readLine()!!.toInt()

    println(solve(num))
}

private fun solve(num: Int): Int {
    var res = num
    while (res > 9) {
        res = sumOfDigits(res)
    }

    return res
}

private fun sumOfDigits(num: Int): Int {
    var res = num
    var next = 0
    while (res > 0) {
        next += res % 10
        res /= 10
    }
    res = next
    return res
}
