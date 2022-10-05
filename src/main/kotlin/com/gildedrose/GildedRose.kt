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
    update2()
    update3()
}

private fun Item.update1() {
    if (name == "Aged Brie" || name == "Backstage passes to a TAFKAL80ETC concert") {
        if (quality < 50) {
            quality = quality + 1

            if (name == "Backstage passes to a TAFKAL80ETC concert") {
                if (sellIn < 11) {
                    if (quality < 50) {
                        quality = quality + 1
                    }
                }

                if (sellIn < 6) {
                    if (quality < 50) {
                        quality = quality + 1
                    }
                }
            }
        }
    } else {
        if (quality > 0) {
            if (name == "Sulfuras, Hand of Ragnaros") {
            } else {
                quality = quality - 1
            }
        }
    }
}

private fun Item.update2() {
    if (name == "Sulfuras, Hand of Ragnaros") {
    } else {
        sellIn = sellIn - 1
    }
}

private fun Item.update3() {
    if (sellIn < 0) {
        if (name == "Aged Brie") {
            if (quality < 50) {
                quality = quality + 1
            }
        } else {
            if (name == "Backstage passes to a TAFKAL80ETC concert") {
                quality = 0
            } else {
                if (quality > 0) {
                    if (name == "Sulfuras, Hand of Ragnaros") {

                    } else {
                        quality = quality - 1
                    }
                }
            }
        }
    }
}

