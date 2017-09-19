package com.github.akashv22.kotlin.ktextended.collections

data class IndexedKeyValuePair<out K, out V>(val index: Int, val key: K, val value: V)