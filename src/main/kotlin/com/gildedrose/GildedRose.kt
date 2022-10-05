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
            setQuality(quality + 1)
            if (sellIn < 0) setQuality(quality + 1)
        }
        "Backstage passes to a TAFKAL80ETC concert" -> {
            setQuality(quality + 1)
            if (sellIn < 10) setQuality(quality + 1)
            if (sellIn < 5) setQuality(quality + 1)
            if (sellIn < 0) quality = 0
        }
        "Sulfuras, Hand of Ragnaros" -> {
        }
        else -> {
            setQuality(quality - 1)
            if (sellIn < 0) setQuality(quality - 1)
        }
    }
}

private fun Item.setQuality(newQuality: Int) {
    quality = newQuality.coerceIn(0, 50)
}
