package com.wr.riddles.hackerearth

import java.util.*

fun main(args: Array<String>) {
    val num = readLine()!!.toInt()
    val logins = Node()
    for (i in 1..num) {
        val login = readLine()!!
        if (num == 1) {
            println(login)
            return
        }
        val match = add(login, logins)
        if (match == null) {
            println(login)
        } else {
            println(login + suggest(match.suggest, match))
        }
    }
}

fun add(login: String, node: Node): Node? {
    var n = node
    for (c in login) {
        val next = Node()
        n = n.nextChars.putIfAbsent(c, next) ?: next
    }
    return if (n.isWord) {
        n
    } else {
        n.isWord = true
        null
    }
}

fun suggest(suffix: Int, node: Node): Int {
    var suff = suffix
    do {
        val existing = add(suff.toString(), node)
        if (existing != null) {
            node.suggest++
            suff = node.suggest
        }
    } while (existing != null)
    return suff
}

class Node {
    var nextChars: MutableMap<Char, Node> = HashMap()
    var isWord: Boolean = false
    var suggest: Int = 0
}