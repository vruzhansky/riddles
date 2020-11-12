package com.wr.riddles.codeforces.heroes5

fun main() {
    val num = readLine()!!.toInt()

    (1..num).forEach { _ ->
        val (_, k) = readLine()!!.split(' ').map { it.toInt() }
        val prices = readLine()!!.split(' ').map { it.toInt() }
        println(solve(k, prices))
    }
}

private fun solve(k: Int, prices: List<Int>): Int {
    var max = 0
    val size = prices.size
    for (i in 0 until size) {
        val free = (size - i) / k
        val result = prices.subList(i, i + free).sum()
        if (result > max) max = result
    }
    return max
}
