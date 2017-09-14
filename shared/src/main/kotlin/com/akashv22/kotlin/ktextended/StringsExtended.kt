package com.akashv22.kotlin.ktextended

fun CharSequence?.isNotNullOrBlank(): Boolean = !this.isNullOrBlank()

fun CharSequence?.isNotNullOrEmpty(): Boolean = !this.isNullOrEmpty()

fun CharSequence.toStringBuilder(): StringBuilder = StringBuilder(this)

fun Iterable<CharSequence>.trimAll(): List<CharSequence> = this.map { it.trim() }