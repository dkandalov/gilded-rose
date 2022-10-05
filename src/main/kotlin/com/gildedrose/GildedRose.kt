package com.gildedrose


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

object Brie : ItemType()
object Pass : ItemType()
object Sulfuras : ItemType()
object Normal : ItemType()

open class ItemType {

    fun update(item: Item) {
        age(item)
        degrade(item)
    }

    private fun age(item: Item) {
        when (this) {
            Sulfuras -> {
            }
            else -> {
                item.sellIn = item.sellIn - 1
            }
        }
    }

    private fun degrade(item: Item) {
        when (this) {
            Brie -> item.setQuality(
                if (item.sellIn < 0) item.quality + 2
                else item.quality + 1
            )
            Pass -> item.setQuality(
                if (item.sellIn < 0) 0
                else if (item.sellIn < 5) item.quality + 3
                else if (item.sellIn < 10) item.quality + 2
                else item.quality + 1
            )
            Sulfuras -> Unit
            Normal -> item.setQuality(
                if (item.sellIn < 0) item.quality - 2
                else item.quality - 1
            )
        }
    }
}

private fun Item.setQuality(newQuality: Int) {
    quality = newQuality.coerceIn(0, 50)
}
