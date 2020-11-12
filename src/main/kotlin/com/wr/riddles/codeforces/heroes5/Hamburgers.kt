package com.wr.riddles.codeforces.heroes5

fun main() {
    val num = readLine()!!.toInt()

    (1..num).forEach { _ ->
        readLine()
        val coins = readLine()!!.split(' ').map { it.toLong() }
        println(solve(coins))
    }
}

fun solve(coins: List<Long>): Long {
    val num = coins.size
    val sorted = coins.sorted()

    var max: Long = 0
    sorted.forEachIndexed { index, myCoins ->
        val result = myCoins * (num - index)
        if (result > max) max = result
    }
    return max
}
