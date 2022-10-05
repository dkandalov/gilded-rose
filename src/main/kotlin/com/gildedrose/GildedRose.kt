package com.gildedrose

import com.gildedrose.ItemType.Brie
import com.gildedrose.ItemType.Normal
import com.gildedrose.ItemType.Pass
import com.gildedrose.ItemType.Sulfuras

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (item in items) {
            item.type.update(item)
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
    Brie, Pass, Sulfuras, Normal;

    fun update(item: Item) {
        when (this) {
            Sulfuras -> {
            }
            else -> {
                item.sellIn = item.sellIn - 1
            }
        }

        when (this) {
            Brie -> {
                item.setQuality(
                    if (item.sellIn < 0) item.quality + 2
                    else item.quality + 1
                )
            }
            Pass -> {
                item.setQuality(
                    if (item.sellIn < 0) 0
                    else if (item.sellIn < 5) item.quality + 3
                    else if (item.sellIn < 10) item.quality + 2
                    else item.quality + 1
                )
            }
            Sulfuras -> {
            }
            else -> {
                item.setQuality(
                    if (item.sellIn < 0) item.quality - 2
                    else item.quality - 1
                )
            }
        }
    }
}

private fun Item.setQuality(newQuality: Int) {
    quality = newQuality.coerceIn(0, 50)
}
