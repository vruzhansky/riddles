package com.wr.riddles.codeforces.heroes5

fun main() {
    val num = readLine()!!.toInt()

    (1..num).forEach { _ ->
        val str = readLine()!!.toCharArray()
        println(solve(str))
    }
}

private fun solve(str: CharArray): Int {
    var result = 0
    var prevV = false
    str.forEach {
        if (it == 'w') {
            result++
            prevV = false
        }
        if (it == 'v') {
            prevV = if (prevV) {
                result++
                false
            } else true
        }
    }
    return result
}
