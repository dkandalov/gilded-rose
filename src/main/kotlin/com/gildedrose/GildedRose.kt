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
        "Aged Brie"                                 -> if (quality < 50) quality += 1
        "Backstage passes to a TAFKAL80ETC concert" -> {
            if (quality < 50) {
                quality += 1
                if (sellIn < 11 && quality < 50) quality += 1
                if (sellIn < 6 && quality < 50) quality += 1
            }
        }
        "Sulfuras, Hand of Ragnaros"                -> quality -= 0
        else                                        -> if (quality > 0) quality -= 1
    }

    sellIn -= if (name == "Sulfuras, Hand of Ragnaros") 0 else 1

    if (sellIn < 0) {
        when (name) {
            "Aged Brie"                                 -> if (quality < 50) quality += 1
            "Backstage passes to a TAFKAL80ETC concert" -> quality = 0
            "Sulfuras, Hand of Ragnaros"                -> quality -= 0
            else                                        -> if (quality > 0) quality -= 1
        }
    }
}

