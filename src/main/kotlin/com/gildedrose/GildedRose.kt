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
            updateQuality()
        }
        "Backstage passes to a TAFKAL80ETC concert" -> {
            updateQuality()
            if (sellIn < 11) updateQuality()
            if (sellIn < 6) updateQuality()
        }
        "Sulfuras, Hand of Ragnaros" -> {
            quality -= 0
        }
        else -> {
            if (quality > 0) quality -= 1
        }
    }

    sellIn -= when (name) {
        "Sulfuras, Hand of Ragnaros" -> 0
        else -> 1
    }

    if (sellIn < 0) {
        when (name) {
            "Aged Brie" -> updateQuality()
            "Backstage passes to a TAFKAL80ETC concert" -> quality = 0
            "Sulfuras, Hand of Ragnaros" -> quality -= 0
            else -> if (quality > 0) quality -= 1
        }
    }
}

private fun Item.updateQuality() {
    if (quality < 50) quality += 1
}

