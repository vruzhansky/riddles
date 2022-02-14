package com.wr.riddles.leetcode

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
fun main() {
    val s = readLine()!!

    println(longestPalindromeDP(s))
}

// Si..Sj = Si+1..Sj-1 && S[i] == S[j]
fun longestPalindromeDP(s: String): String {
    val n = s.length
    if (n < 2) {
        return s
    }

    val dp = Array(n) { BooleanArray(n) }
    var max = 0
    var res = ""
    for (j in 0 until n) {
        for (i in 0..j) {
            val condition = s[i] == s[j]

            dp[i][j] = if (j - i > 2) dp[i + 1][j - 1] && condition else condition

            if (dp[i][j] && j - i + 1 > max) {
                max = j - i + 1
                res = s.substring(i, j + 1)
            }
        }
    }
    return res
}

fun longestPalindrome(s: String): String {
    var maxLength = 0
    var res = ""
    for (i in 0 until s.length) {
        val candidate = palindrome(s.substring(0, i + 1))
        if (candidate.length > maxLength) {
            maxLength = candidate.length
            res = candidate
        }
        val candidate2 = palindrome(s.substring(i, s.length))
        if (candidate2.length > maxLength) {
            maxLength = candidate2.length
            res = candidate2
        }
    }
    return res
}

fun palindrome(s: String): String {
    val n = s.length
    if (n < 2) {
        return s
    }
    val mid = n / 2
    var left = mid - 1
    var right = if (n % 2 == 0) mid else mid + 1
    while (left >= 0 && right < n) {
        if (s[left] != s[right]) {
            break;
        }
        left--
        right++
    }
    return s.substring(left + 1, right)
}
