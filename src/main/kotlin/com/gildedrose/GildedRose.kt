package com.gildedrose

class GildedRose(var items: Array<Item>) {
    fun update() {
        items.forEach { item ->
            item.update()
        }
    }
}

private fun Item.update() {
    sellIn -= when (name) {
        "Sulfuras, Hand of Ragnaros" -> 0
        else -> 1
    }

    updateQuality(
        when (name) {
            "Aged Brie" -> if (sellIn < 0) 2 else 1
            "Backstage passes to a TAFKAL80ETC concert" ->
                if (sellIn < 0) -quality
                else when {
                    sellIn < 5 -> 3
                    sellIn < 10 -> 2
                    else -> 1
                }
            "Sulfuras, Hand of Ragnaros" -> 0
            else -> if (sellIn < 0) -2 else -1
        }
    )
}

private fun Item.updateQuality(change: Int) {
    if (change == 0) return
    quality = (quality + change).coerceIn(0, 50)
}

