package com.gildedrose

class GildedRose(val items: Array<Item>) {
    fun update() {
        items.forEach {
            it.update()
        }
    }
}

private fun Item.update() {
    sellIn -= if (name == "Sulfuras, Hand of Ragnaros") 0 else 1

    updateQuality(
        when (name) {
            "Aged Brie"                                 -> if (expired) 2 else 1
            "Backstage passes to a TAFKAL80ETC concert" ->
                if (expired) -quality
                else if (sellIn < 5) 3
                else if (sellIn < 10) 2
                else 1
            "Sulfuras, Hand of Ragnaros"                -> 0
            else                                        -> if (expired) -2 else -1
        }
    )
}

private val Item.expired get() = sellIn < 0

private fun Item.updateQuality(qualityChange: Int) {
    if (qualityChange == 0) return
    quality = (quality + qualityChange).coerceIn(minimumValue = 0, maximumValue = 50)
}

