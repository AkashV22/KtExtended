package com.akashv22.kotlin.ktextended

fun <T> Iterable<T>.getLastIndex(indexOrigin: Int = 0): Int = this.count() - 1 + indexOrigin

fun <T> Iterable<T>.isLastIndex(currentIndex: Int, indexOrigin: Int = 0): Boolean =
        currentIndex == this.getLastIndex(indexOrigin)