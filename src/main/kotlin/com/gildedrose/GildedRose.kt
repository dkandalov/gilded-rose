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
            "Aged Brie"                                 -> 1
            "Backstage passes to a TAFKAL80ETC concert" ->
                if (sellIn < 5) 3
                else if (sellIn < 10) 2
                else 1
            "Sulfuras, Hand of Ragnaros"                -> 0
            else                                        -> -1
        }
    )

    if (sellIn < 0) {
        updateQuality(
            when (name) {
                "Aged Brie"                                 -> 1
                "Backstage passes to a TAFKAL80ETC concert" -> -quality
                "Sulfuras, Hand of Ragnaros"                -> 0
                else                                        -> -1
            }
        )
    }
}

private fun Item.updateQuality(qualityChange: Int) {
    if (qualityChange == 0) return
    quality = (quality + qualityChange).coerceIn(minimumValue = 0, maximumValue = 50)
}

