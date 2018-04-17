package com.wr.riddles.hackerearth

import java.util.*

fun main(args: Array<String>) {
    val num = readLine()!!.toInt()
    if (num == 1) {
        println(readLine())
        return
    }
    val logins = Node()
    for (i in 1..num) {
        val login = readLine()!!
        print(login)
        val match = add(login, logins)
        if (match == null) {
            println()
        } else {
            println(suggest(match))
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

fun suggest(node: Node): Int {
    do {
        val existing = add(node.suggest.toString(), node)
        if (existing != null) {
            node.suggest++
        }
    } while (existing != null)
    return node.suggest
}

class Node {
    var nextChars: MutableMap<Char, Node> = HashMap()
    var isWord: Boolean = false
    var suggest: Int = 0
}