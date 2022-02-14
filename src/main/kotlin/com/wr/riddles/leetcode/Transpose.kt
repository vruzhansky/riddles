package com.wr.riddles.leetcode

/**
 * https://leetcode.com/problems/transpose-matrix/
 */
fun main() {
    // [[1,2,3],[4,5,6],[7,8,9]]
    val matrix = readLine()!!
        .removeSurrounding("[", "]")
        .split("],")
        .map { it.removePrefix("[").removeSuffix("]").split(",").map { it.toInt() }.toIntArray() }
        .toTypedArray()

    println(solve(matrix).contentDeepToString())
}

private fun solve(matrix: Array<IntArray>): Array<IntArray> {
    val m = matrix.size
    val n = matrix[0].size
    val answer = Array(n) { IntArray(m) }

    for (i in 0 until m) {
        for (j in 0 until n) {
            answer[j][i] = matrix[i][j]
        }
    }
    return answer
}
