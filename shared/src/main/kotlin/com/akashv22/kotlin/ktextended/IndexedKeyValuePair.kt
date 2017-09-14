package com.akashv22.kotlin.ktextended

data class IndexedKeyValuePair<out K, out V>(val index: Int, val key: K, val value: V)