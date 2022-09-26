package com.gildedrose

class GildedRose(var items: Array<Item>) {
    fun update() {
        items.forEach { item ->
            item.type.update(item)
        }
    }
}

object Pass : ItemType() {
    override fun degrade(item: Item) {
        val quality = when {
            item.sellIn < 0 -> 0
            item.sellIn < 5 -> item.quality + 3
            item.sellIn < 10 -> item.quality + 2
            else -> item.quality + 1
        }
        item.setQuality(quality)
    }
}

object Brie : ItemType() {
    override fun degrade(item: Item) {
        val quality = when {
            item.sellIn < 0 -> item.quality + 2
            else -> item.quality + 1
        }
        item.setQuality(quality)
    }
}

object Sulfuras : ItemType() {
    override fun age(item: Item) {}
    override fun degrade(item: Item) {}
}

object NormalItem : ItemType()

open class ItemType {

    fun update(item: Item) {
        age(item)
        degrade(item)
    }

    protected open fun age(item: Item) {
        item.sellIn -= 1
    }

    protected open fun degrade(item: Item) {
        val quality = when {
            item.sellIn < 0 -> item.quality - 2
            else -> item.quality - 1
        }
        item.setQuality(quality)
    }
}

val Item.type
    get() = when (name) {
        "Aged Brie" -> Brie
        "Backstage passes to a TAFKAL80ETC concert" -> Pass
        "Sulfuras, Hand of Ragnaros" -> Sulfuras
        else -> NormalItem
    }

private fun Item.setQuality(quality: Int) {
    this.quality = quality.coerceIn(minimumValue = 0, maximumValue = 50)
}
