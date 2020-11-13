package com.wr.riddles.codeforces.heroes5

fun main() {
    val num = readLine()!!.toInt()

    (1..num).forEach { _ ->
        readLine()
        val lectors = readLine()!!.split(' ').map { it.toInt() }
        println(solve(lectors))
    }
}

private fun solve(lectors: List<Int>): String {
    val num = lectors.size
    val sorted = lectors.mapIndexed { index, value -> IndexedValue(index + 1, value) }.sortedBy { it.value }
    val result = mutableListOf<Int>()
    var b = 0
    var e = num - 1
    var mark = 0
    while (b <= e) {
        val cand = sorted[b]
        if (cand.value <= mark) {
            result.add(cand.index)
            ++b
            mark = 1
        } else {
            result.add(sorted[e].index)
            --e
            mark++
        }
    }
    return result.joinToString(" ")
}
