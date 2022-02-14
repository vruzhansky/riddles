package com.wr.riddles.leetcode

import kotlin.math.max

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
fun main() {

    val str = readLine()!!


    println(lengthOfLongestSubstring(str))
}

//pworwkex
//tmmzuxt
//a b c a b c b b
//0 1 2 3 4 5 6 7
//|   |
fun lengthOfLongestSubstring(s: String): Int {
    val res = mutableMapOf<Char, Int>()
    var max = 0
    var startIdx = 0
    for(endIdx in 0 until s.length) {
        val idx = res[s[endIdx]]
        if (idx != null) {
            startIdx = max(startIdx, idx + 1)
        }
        res[s[endIdx]] = endIdx
        max = max(max, endIdx - startIdx + 1)
    }
    return max
}
