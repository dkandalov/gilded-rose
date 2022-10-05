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
            setQuality(
                if (sellIn < 0) quality + 2
                else quality + 1
            )
        }
        "Backstage passes to a TAFKAL80ETC concert" -> {
            setQuality(
                if (sellIn < 0) 0
                else if (sellIn < 5) quality + 3
                else if (sellIn < 10) quality + 2
                else quality + 1
            )
        }
        "Sulfuras, Hand of Ragnaros" -> {
        }
        else -> {
            setQuality(
                if (sellIn < 0) quality - 2
                else quality - 1
            )
        }
    }
}

private fun Item.setQuality(newQuality: Int) {
    quality = newQuality.coerceIn(0, 50)
}
