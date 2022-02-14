package com.wr.riddles.leetcode

/**
 * https://leetcode.com/problems/contiguous-array/
 */
fun main() {

    val arr = readLine()!!.removeSurrounding("[", "]").split(',').map { it.toInt() }.toIntArray()


    println(findMaxLength(arr))
}

//[0,1,0,1,1,1,0,0,1,1,0,1,1,1,1,1,1,0,1,1,0,1,1,0,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,0,0,0,0,1,0,0,0,1,1,1,0,1,0,0,1,1,1,1,1,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,0,0,0,1,0,1,0,1,1,0,0,1,1,0,1,1,1,1,0,1,1,0,0,0,1,1]
//[0,0,0,1,1,1]
//[0,0,0,1,1,1,1,1]
//[1,1,0,1,1,1,1]
private fun findMaxLength(nums: IntArray): Int {
    var ctr = 0
    val ctrMaxIdx = mutableMapOf<Int, Int>()

    var max = 0
    for (i in nums.indices) {
        if (nums[i] == 1) ctr++
        else ctr--

        if (ctr == 0 && max < i + 1) {
            max = i + 1
        } else {
            val idx = ctrMaxIdx[ctr]
            if (idx == null) {
                ctrMaxIdx[ctr] = i
            } else if (max < i - idx) max = i - idx
        }

    }

    return max
}
