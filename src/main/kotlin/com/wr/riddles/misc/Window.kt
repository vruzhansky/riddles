package com.wr.riddles.misc

/**
 * Sum of sliding window, e.g.
 * arr=[1,2,3,4,5], size=3
 * [1+2+3,2+3+4,3+4+5] -> [6,9,12]
 */
fun main() {

    val arr = readLine()!!.split(' ').map { it.toInt() }

    val size = readLine()!!.toInt()

    println(solve(arr, size))
}

private fun solve(arr: List<Int>, size: Int): List<Int> {
    val result = mutableListOf<Int>()
    if (size > arr.size) return result

    var sum = 0
    for (i in 0 until size) sum += arr[i]
    result.add(sum)

    for (i in 1..arr.size - size) {
        sum = sum - arr[i - 1] + arr[i + size - 1]
        result.add(sum)
    }
    return result
}
