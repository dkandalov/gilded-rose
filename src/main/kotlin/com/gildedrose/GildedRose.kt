package com.gildedrose

import com.gildedrose.ItemType.Brie
import com.gildedrose.ItemType.Normal
import com.gildedrose.ItemType.Pass
import com.gildedrose.ItemType.Sulfuras

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (item in items) {
            item.update()
        }
    }
}

private fun Item.update() {
    when (type) {
        Sulfuras -> {
        }
        else -> {
            sellIn = sellIn - 1
        }
    }

    when (type) {
        Brie -> {
            setQuality(
                if (sellIn < 0) quality + 2
                else quality + 1
            )
        }
        Pass -> {
            setQuality(
                if (sellIn < 0) 0
                else if (sellIn < 5) quality + 3
                else if (sellIn < 10) quality + 2
                else quality + 1
            )
        }
        Sulfuras -> {
        }
        else -> {
            setQuality(
                if (sellIn < 0) quality - 2
                else quality - 1
            )
        }
    }
}

private val Item.type get() = when (name) {
    "Aged Brie" -> Brie
    "Backstage passes to a TAFKAL80ETC concert" -> Pass
    "Sulfuras, Hand of Ragnaros" -> Sulfuras
    else -> Normal
}

enum class ItemType {
    Brie, Pass, Sulfuras, Normal
}

private fun Item.setQuality(newQuality: Int) {
    quality = newQuality.coerceIn(0, 50)
}
