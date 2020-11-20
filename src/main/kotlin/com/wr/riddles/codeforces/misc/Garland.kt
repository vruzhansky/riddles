package com.wr.riddles.codeforces.misc

fun main() {
    val num = readLine()!!.toInt()

    (1..num).forEach { _ ->
        val (r, g, b) = readLine()!!.split(" ").map { it.toInt() }.sortedDescending()
        println(solve(r, g, b))
    }
}

private fun solve(r: Int, g: Int, b: Int): String {
    return if (r - g <= 1 || r - g - b <= 1) "Yes"
    else "No"
}
