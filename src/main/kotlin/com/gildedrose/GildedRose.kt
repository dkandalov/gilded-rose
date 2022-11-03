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
            if (quality < 50) quality += 1
        }
        "Backstage passes to a TAFKAL80ETC concert" -> {
            if (quality < 50) {
                quality += 1
                if (sellIn < 11) {
                    if (quality < 50) quality += 1
                }
                if (sellIn < 6) {
                    if (quality < 50) quality += 1
                }
            }
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
            "Aged Brie" -> if (quality < 50) quality += 1
            "Backstage passes to a TAFKAL80ETC concert" -> quality = 0
            "Sulfuras, Hand of Ragnaros" -> quality -= 0
            else -> if (quality > 0) quality -= 1
        }
    }
}

