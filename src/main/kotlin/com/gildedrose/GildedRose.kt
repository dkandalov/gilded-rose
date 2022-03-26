package com.gildedrose

class GildedRose(val items: Array<Item>) {
    fun updateQuality() {
        items.forEach {
            it.updateQuality()
        }
    }
}

private fun Item.updateQuality() {
    if (name != "Aged Brie" && name != "Backstage passes to a TAFKAL80ETC concert") {
        if (quality > 0) {
            if (name != "Sulfuras, Hand of Ragnaros") {
                quality -= 1
            }
        }
    } else {
        if (quality < 50) {
            quality += 1

            if (name == "Backstage passes to a TAFKAL80ETC concert") {
                if (sellIn < 11) {
                    if (quality < 50) {
                        quality += 1
                    }
                }

                if (sellIn < 6) {
                    if (quality < 50) {
                        quality += 1
                    }
                }
            }
        }
    }

    if (name != "Sulfuras, Hand of Ragnaros") {
        sellIn -= 1
    }

    if (sellIn < 0) {
        if (name != "Aged Brie") {
            if (name != "Backstage passes to a TAFKAL80ETC concert") {
                if (quality > 0) {
                    if (name != "Sulfuras, Hand of Ragnaros") {
                        quality -= 1
                    }
                }
            } else {
                quality = 0
            }
        } else {
            if (quality < 50) {
                quality += 1
            }
        }
    }
}

