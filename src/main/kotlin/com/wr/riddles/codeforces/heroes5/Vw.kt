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

//private fun solve(coins: List<Char>): Int {
//    val num = coins.size
//    val sorted = coins.sorted()
//
//    var max: Long = 0
//    sorted.forEachIndexed { index, myCoins ->
//        val result = myCoins * (num - index)
//        if (result > max) max = result
//    }
//    return max
//}
