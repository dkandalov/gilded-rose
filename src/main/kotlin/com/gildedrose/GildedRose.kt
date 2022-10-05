package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (item in items) {
            item.update()
        }
    }
}

private fun Item.update() {
    if (name == "Sulfuras, Hand of Ragnaros") {
    } else {
        sellIn = sellIn - 1
    }

    when (name) {
        "Aged Brie" -> {
            incrementQuality()
        }
        "Backstage passes to a TAFKAL80ETC concert" -> {
            incrementQuality()
            if (sellIn < 10) incrementQuality()
            if (sellIn < 5) incrementQuality()
        }
        "Sulfuras, Hand of Ragnaros" -> {
        }
        else -> {
            decrementQuality()
        }
    }

    if (sellIn < 0) {
        when (name) {
            "Aged Brie" -> {
                incrementQuality()
            }
            "Backstage passes to a TAFKAL80ETC concert" -> {
                quality = 0
            }
            "Sulfuras, Hand of Ragnaros" -> {
            }
            else -> {
                decrementQuality()
            }
        }
    }
}


private fun Item.decrementQuality() {
    if (quality > 0) quality = quality - 1
}

private fun Item.incrementQuality() {
    if (quality < 50) {
        quality = quality + 1
    }
}
