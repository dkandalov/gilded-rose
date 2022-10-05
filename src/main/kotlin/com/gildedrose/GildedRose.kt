package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (item in items) {
            item.update()
        }
    }
}

private fun Item.update() {
    update1()
    age()
    update2()
}

private fun Item.update1() {
    when (name) {
        "Aged Brie" -> {
            incrementQuality()
        }
        "Backstage passes to a TAFKAL80ETC concert" -> {
            incrementQuality()
            if (sellIn < 11) incrementQuality()
            if (sellIn < 6) incrementQuality()
        }
        "Sulfuras, Hand of Ragnaros" -> {
        }
        else -> {
            decrementQuality()
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

private fun Item.age() {
    if (name == "Sulfuras, Hand of Ragnaros") {
    } else {
        sellIn = sellIn - 1
    }
}

private fun Item.update2() {
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

