package com.gildedrose

class GildedRose(var items: Array<Item>) {
    fun update() {
        items.forEach { item ->
            item.update()
        }
    }
}

private fun Item.update() {
    when (name) {
        "Aged Brie" -> {
            updateQuality(1)
        }
        "Backstage passes to a TAFKAL80ETC concert" -> {
            updateQuality(1)
            if (sellIn < 11) updateQuality(1)
            if (sellIn < 6) updateQuality(1)
        }
        "Sulfuras, Hand of Ragnaros" -> {
            updateQuality(0)
        }
        else -> {
            updateQuality(-1)
        }
    }

    sellIn -= when (name) {
        "Sulfuras, Hand of Ragnaros" -> 0
        else -> 1
    }

    if (sellIn < 0) {
        when (name) {
            "Aged Brie" -> updateQuality(1)
            "Backstage passes to a TAFKAL80ETC concert" -> quality = 0
            "Sulfuras, Hand of Ragnaros" -> updateQuality(0)
            else -> updateQuality(-1)
        }
    }
}

private fun Item.updateQuality(change: Int) {
    if (change == 0) return
    quality = (quality + change).coerceIn(0, 50)
}

