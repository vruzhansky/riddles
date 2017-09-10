package com.wr.riddles.hacckerrank.ctci

import java.util.regex.Pattern

fun main(args: Array<String>) {
    val n = readLine()?.trim().orEmpty().toInt()
    val a = readLine()
            ?.trim()
            ?.split(Pattern.compile("\\s+"))
            ?.map(String::toInt)
            .orEmpty()
            .toTypedArray()
    var numOfSwaps = 0
    for (i in 0 until n) {
        // Track number of elements swapped during a single array traversal
        var numberOfSwaps = 0

        for (j in 0 until n - 1) {
            // Swap adjacent elements if they are in decreasing order
            if (a[j] > a[j + 1]) {
                swap(a, j, j + 1)
                numberOfSwaps++
            }
        }

        numOfSwaps += numberOfSwaps
        // If no elements were swapped during a traversal, array is sorted
        if (numberOfSwaps == 0) {
            break
        }
    }

    println("Array is sorted in $numOfSwaps swaps.")
    println("First Element: ${a[0]}")
    println("Last Element: ${a[n - 1]}")
}

fun swap(a: Array<Int>, i: Int, j: Int) {
    val k = a[i]
    a[i] = a[j]
    a[j] = k
}
