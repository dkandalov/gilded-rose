package com.gildedrose

data class Item(
    val name: String,
    val sellIn: Int,
    val quality: Int
) {
    override fun toString() = "$name, $sellIn, $quality"
}