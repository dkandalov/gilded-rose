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
            if (sellIn < 0) setQuality(quality + 2)
            else setQuality(quality + 1)
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
            if (sellIn < 0) setQuality(quality - 2)
            else setQuality(quality - 1)
        }
    }
}

private fun Item.setQuality(newQuality: Int) {
    quality = newQuality.coerceIn(0, 50)
}
