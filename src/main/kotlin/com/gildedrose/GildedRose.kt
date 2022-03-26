package com.gildedrose

class GildedRose(val items: Array<Item>) {
    fun update() {
        items.forEach {
            it.update()
        }
    }
}

private fun Item.update() {
    when (name) {
        "Aged Brie"                                 -> updateQuality(1)
        "Backstage passes to a TAFKAL80ETC concert" -> {
            updateQuality(1)
            if (sellIn < 11) updateQuality(1)
            if (sellIn < 6) updateQuality(1)
        }
        "Sulfuras, Hand of Ragnaros"                -> quality -= 0
        else                                        -> updateQuality(-1)
    }

    sellIn -= if (name == "Sulfuras, Hand of Ragnaros") 0 else 1

    if (sellIn < 0) {
        when (name) {
            "Aged Brie"                                 -> updateQuality(1)
            "Backstage passes to a TAFKAL80ETC concert" -> quality = 0
            "Sulfuras, Hand of Ragnaros"                -> quality -= 0
            else                                        -> updateQuality(-1)
        }
    }
}

private fun Item.updateQuality(qualityChange: Int) {
    quality = (quality + qualityChange).coerceIn(minimumValue = 0, maximumValue = 50)
}

