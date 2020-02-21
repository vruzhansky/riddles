package com.wr.riddles.hashcode.y2020.online

import java.io.File
import kotlin.math.max
import kotlin.math.min

fun main() {
    val name = readLine()
    val reader = File("$name.in").bufferedReader()

    val first = reader.readLine().split(' ')

    val totalLibs = first[1].toInt()
    val days = first[2].toInt()

    val scores = reader.readLine().split(' ').map { it.toInt() }

    val libs = (0 until totalLibs)
            .map {
                val firstL = reader.readLine().split(' ')
                val signUpDays = firstL[1].toInt()
                val booksPerDay = firstL[2].toInt()

                val booksInLib = reader.readLine().split(' ').map { it.toInt() }

                Lib(it, signUpDays, booksPerDay, booksInLib, scores)
            }
    var remDays = days

    val outLibs: MutableList<BestLib> = mutableListOf()
    val outLibsIds: MutableList<Int> = mutableListOf()
    val used: MutableSet<Int> = mutableSetOf()
    while (remDays > 0) {
        print("----> $remDays")
        libs.asSequence()
                .filter { !outLibsIds.contains(it.id) }
                .map { it.myScore(remDays, used) }
                .filter { it.score > 0 }
                .maxBy { it.score }
                ?.let {
                    println(" ----> score is ${it.score}, signup is ${it.signupDays}")
                    outLibs.add(it)
                    used.addAll(it.books)
                    outLibsIds.add(it.id)
                    remDays -= it.signupDays
                } ?: break
    }

    File("$name.out").printWriter().use { out ->
        out.println(outLibs.size)
        outLibs.forEach {
            out.println("${it.id} ${it.books.size}")
            it.books.joinToString(" ") { it.toString() }.let { out.println(it) }
        }
    }
}

data class Lib(val id: Int, val signupDays: Int, val booksPerDay: Int, val booksInLib: List<Int>, val scores: List<Int>) {
    private val byScore = booksInLib.sortedByDescending { scores[it] }

    fun myScore(days: Int, used: Set<Int>): BestLib {
        val remaining = max(days - signupDays, 0)
        return if (remaining > 0) {
            val maxBooks = min(booksPerDay * remaining.toLong(), booksInLib.size.toLong())
            val subList = byScore.asSequence()
                    .filter { !used.contains(it) }
                    .take(maxBooks.toInt())
                    .toList()

            BestLib(id, signupDays, subList, score(subList, days, remaining))
        } else {
            BestLib(id, signupDays, emptyList(), 0.0)
        }
    }

    private val maxScore = booksInLib.sumBy { scores[it] }

    private fun score(subList: List<Int>, days: Int, remaining: Int) =
        subList.sumByDouble { scores[it] / maxScore.toDouble()*9.0+1.0*remaining.toDouble()/days }
}

data class BestLib(val id: Int, val signupDays: Int, val books: List<Int>, val score: Double)
