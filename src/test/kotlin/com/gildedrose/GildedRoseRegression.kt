package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GildedRoseRegression {
    @Test
    fun `updates over 100 days`() {
        log("OMGHAI!")

        val items = arrayOf(
            Item(name = "+5 Dexterity Vest", sellIn = 10, quality = 20),
            Item(name = "Aged Brie", sellIn = 2, quality = 0),
            Item(name = "Elixir of the Mongoose", sellIn = 5, quality = 7),
            Item(name = "Sulfuras, Hand of Ragnaros", sellIn = 0, quality = 80),
            Item(name = "Sulfuras, Hand of Ragnaros", sellIn = -1, quality = 80),
            Item(name = "Backstage passes to a TAFKAL80ETC concert", sellIn = 15, quality = 20),
            Item(name = "Backstage passes to a TAFKAL80ETC concert", sellIn = 10, quality = 49),
            Item(name = "Backstage passes to a TAFKAL80ETC concert", sellIn = 5, quality = 49),
            // TODO this conjured item does not work properly yet
            Item(name = "Conjured Mana Cake", sellIn = 3, quality = 6)
        )

        val gildedRose = GildedRose(items)

        (0 until 100).forEach { day ->
            log("-------- day $day --------")
            log("name, sellIn, quality")
            gildedRose.items.forEach { item ->
                log(item)
            }
            log("")
            gildedRose.updateQuality()
        }

        assertEquals(expectedOutput, output)
    }

    private var output = ""

    private fun log(any: Any) {
        output += "$any\n"
        println(any.toString())
    }

    private val expectedOutput = """
        OMGHAI!
        -------- day 0 --------
        name, sellIn, quality
        +5 Dexterity Vest, 10, 20
        Aged Brie, 2, 0
        Elixir of the Mongoose, 5, 7
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, 15, 20
        Backstage passes to a TAFKAL80ETC concert, 10, 49
        Backstage passes to a TAFKAL80ETC concert, 5, 49
        Conjured Mana Cake, 3, 6

        -------- day 1 --------
        name, sellIn, quality
        +5 Dexterity Vest, 9, 19
        Aged Brie, 1, 1
        Elixir of the Mongoose, 4, 6
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, 14, 21
        Backstage passes to a TAFKAL80ETC concert, 9, 50
        Backstage passes to a TAFKAL80ETC concert, 4, 50
        Conjured Mana Cake, 2, 5

        -------- day 2 --------
        name, sellIn, quality
        +5 Dexterity Vest, 8, 18
        Aged Brie, 0, 2
        Elixir of the Mongoose, 3, 5
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, 13, 22
        Backstage passes to a TAFKAL80ETC concert, 8, 50
        Backstage passes to a TAFKAL80ETC concert, 3, 50
        Conjured Mana Cake, 1, 4

        -------- day 3 --------
        name, sellIn, quality
        +5 Dexterity Vest, 7, 17
        Aged Brie, -1, 4
        Elixir of the Mongoose, 2, 4
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, 12, 23
        Backstage passes to a TAFKAL80ETC concert, 7, 50
        Backstage passes to a TAFKAL80ETC concert, 2, 50
        Conjured Mana Cake, 0, 3

        -------- day 4 --------
        name, sellIn, quality
        +5 Dexterity Vest, 6, 16
        Aged Brie, -2, 6
        Elixir of the Mongoose, 1, 3
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, 11, 24
        Backstage passes to a TAFKAL80ETC concert, 6, 50
        Backstage passes to a TAFKAL80ETC concert, 1, 50
        Conjured Mana Cake, -1, 1

        -------- day 5 --------
        name, sellIn, quality
        +5 Dexterity Vest, 5, 15
        Aged Brie, -3, 8
        Elixir of the Mongoose, 0, 2
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, 10, 25
        Backstage passes to a TAFKAL80ETC concert, 5, 50
        Backstage passes to a TAFKAL80ETC concert, 0, 50
        Conjured Mana Cake, -2, 0

        -------- day 6 --------
        name, sellIn, quality
        +5 Dexterity Vest, 4, 14
        Aged Brie, -4, 10
        Elixir of the Mongoose, -1, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, 9, 27
        Backstage passes to a TAFKAL80ETC concert, 4, 50
        Backstage passes to a TAFKAL80ETC concert, -1, 0
        Conjured Mana Cake, -3, 0

        -------- day 7 --------
        name, sellIn, quality
        +5 Dexterity Vest, 3, 13
        Aged Brie, -5, 12
        Elixir of the Mongoose, -2, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, 8, 29
        Backstage passes to a TAFKAL80ETC concert, 3, 50
        Backstage passes to a TAFKAL80ETC concert, -2, 0
        Conjured Mana Cake, -4, 0

        -------- day 8 --------
        name, sellIn, quality
        +5 Dexterity Vest, 2, 12
        Aged Brie, -6, 14
        Elixir of the Mongoose, -3, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, 7, 31
        Backstage passes to a TAFKAL80ETC concert, 2, 50
        Backstage passes to a TAFKAL80ETC concert, -3, 0
        Conjured Mana Cake, -5, 0

        -------- day 9 --------
        name, sellIn, quality
        +5 Dexterity Vest, 1, 11
        Aged Brie, -7, 16
        Elixir of the Mongoose, -4, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, 6, 33
        Backstage passes to a TAFKAL80ETC concert, 1, 50
        Backstage passes to a TAFKAL80ETC concert, -4, 0
        Conjured Mana Cake, -6, 0

        -------- day 10 --------
        name, sellIn, quality
        +5 Dexterity Vest, 0, 10
        Aged Brie, -8, 18
        Elixir of the Mongoose, -5, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, 5, 35
        Backstage passes to a TAFKAL80ETC concert, 0, 50
        Backstage passes to a TAFKAL80ETC concert, -5, 0
        Conjured Mana Cake, -7, 0

        -------- day 11 --------
        name, sellIn, quality
        +5 Dexterity Vest, -1, 8
        Aged Brie, -9, 20
        Elixir of the Mongoose, -6, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, 4, 38
        Backstage passes to a TAFKAL80ETC concert, -1, 0
        Backstage passes to a TAFKAL80ETC concert, -6, 0
        Conjured Mana Cake, -8, 0

        -------- day 12 --------
        name, sellIn, quality
        +5 Dexterity Vest, -2, 6
        Aged Brie, -10, 22
        Elixir of the Mongoose, -7, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, 3, 41
        Backstage passes to a TAFKAL80ETC concert, -2, 0
        Backstage passes to a TAFKAL80ETC concert, -7, 0
        Conjured Mana Cake, -9, 0

        -------- day 13 --------
        name, sellIn, quality
        +5 Dexterity Vest, -3, 4
        Aged Brie, -11, 24
        Elixir of the Mongoose, -8, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, 2, 44
        Backstage passes to a TAFKAL80ETC concert, -3, 0
        Backstage passes to a TAFKAL80ETC concert, -8, 0
        Conjured Mana Cake, -10, 0

        -------- day 14 --------
        name, sellIn, quality
        +5 Dexterity Vest, -4, 2
        Aged Brie, -12, 26
        Elixir of the Mongoose, -9, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, 1, 47
        Backstage passes to a TAFKAL80ETC concert, -4, 0
        Backstage passes to a TAFKAL80ETC concert, -9, 0
        Conjured Mana Cake, -11, 0

        -------- day 15 --------
        name, sellIn, quality
        +5 Dexterity Vest, -5, 0
        Aged Brie, -13, 28
        Elixir of the Mongoose, -10, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, 0, 50
        Backstage passes to a TAFKAL80ETC concert, -5, 0
        Backstage passes to a TAFKAL80ETC concert, -10, 0
        Conjured Mana Cake, -12, 0

        -------- day 16 --------
        name, sellIn, quality
        +5 Dexterity Vest, -6, 0
        Aged Brie, -14, 30
        Elixir of the Mongoose, -11, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -1, 0
        Backstage passes to a TAFKAL80ETC concert, -6, 0
        Backstage passes to a TAFKAL80ETC concert, -11, 0
        Conjured Mana Cake, -13, 0

        -------- day 17 --------
        name, sellIn, quality
        +5 Dexterity Vest, -7, 0
        Aged Brie, -15, 32
        Elixir of the Mongoose, -12, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -2, 0
        Backstage passes to a TAFKAL80ETC concert, -7, 0
        Backstage passes to a TAFKAL80ETC concert, -12, 0
        Conjured Mana Cake, -14, 0

        -------- day 18 --------
        name, sellIn, quality
        +5 Dexterity Vest, -8, 0
        Aged Brie, -16, 34
        Elixir of the Mongoose, -13, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -3, 0
        Backstage passes to a TAFKAL80ETC concert, -8, 0
        Backstage passes to a TAFKAL80ETC concert, -13, 0
        Conjured Mana Cake, -15, 0

        -------- day 19 --------
        name, sellIn, quality
        +5 Dexterity Vest, -9, 0
        Aged Brie, -17, 36
        Elixir of the Mongoose, -14, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -4, 0
        Backstage passes to a TAFKAL80ETC concert, -9, 0
        Backstage passes to a TAFKAL80ETC concert, -14, 0
        Conjured Mana Cake, -16, 0

        -------- day 20 --------
        name, sellIn, quality
        +5 Dexterity Vest, -10, 0
        Aged Brie, -18, 38
        Elixir of the Mongoose, -15, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -5, 0
        Backstage passes to a TAFKAL80ETC concert, -10, 0
        Backstage passes to a TAFKAL80ETC concert, -15, 0
        Conjured Mana Cake, -17, 0

        -------- day 21 --------
        name, sellIn, quality
        +5 Dexterity Vest, -11, 0
        Aged Brie, -19, 40
        Elixir of the Mongoose, -16, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -6, 0
        Backstage passes to a TAFKAL80ETC concert, -11, 0
        Backstage passes to a TAFKAL80ETC concert, -16, 0
        Conjured Mana Cake, -18, 0

        -------- day 22 --------
        name, sellIn, quality
        +5 Dexterity Vest, -12, 0
        Aged Brie, -20, 42
        Elixir of the Mongoose, -17, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -7, 0
        Backstage passes to a TAFKAL80ETC concert, -12, 0
        Backstage passes to a TAFKAL80ETC concert, -17, 0
        Conjured Mana Cake, -19, 0

        -------- day 23 --------
        name, sellIn, quality
        +5 Dexterity Vest, -13, 0
        Aged Brie, -21, 44
        Elixir of the Mongoose, -18, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -8, 0
        Backstage passes to a TAFKAL80ETC concert, -13, 0
        Backstage passes to a TAFKAL80ETC concert, -18, 0
        Conjured Mana Cake, -20, 0

        -------- day 24 --------
        name, sellIn, quality
        +5 Dexterity Vest, -14, 0
        Aged Brie, -22, 46
        Elixir of the Mongoose, -19, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -9, 0
        Backstage passes to a TAFKAL80ETC concert, -14, 0
        Backstage passes to a TAFKAL80ETC concert, -19, 0
        Conjured Mana Cake, -21, 0

        -------- day 25 --------
        name, sellIn, quality
        +5 Dexterity Vest, -15, 0
        Aged Brie, -23, 48
        Elixir of the Mongoose, -20, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -10, 0
        Backstage passes to a TAFKAL80ETC concert, -15, 0
        Backstage passes to a TAFKAL80ETC concert, -20, 0
        Conjured Mana Cake, -22, 0

        -------- day 26 --------
        name, sellIn, quality
        +5 Dexterity Vest, -16, 0
        Aged Brie, -24, 50
        Elixir of the Mongoose, -21, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -11, 0
        Backstage passes to a TAFKAL80ETC concert, -16, 0
        Backstage passes to a TAFKAL80ETC concert, -21, 0
        Conjured Mana Cake, -23, 0

        -------- day 27 --------
        name, sellIn, quality
        +5 Dexterity Vest, -17, 0
        Aged Brie, -25, 50
        Elixir of the Mongoose, -22, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -12, 0
        Backstage passes to a TAFKAL80ETC concert, -17, 0
        Backstage passes to a TAFKAL80ETC concert, -22, 0
        Conjured Mana Cake, -24, 0

        -------- day 28 --------
        name, sellIn, quality
        +5 Dexterity Vest, -18, 0
        Aged Brie, -26, 50
        Elixir of the Mongoose, -23, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -13, 0
        Backstage passes to a TAFKAL80ETC concert, -18, 0
        Backstage passes to a TAFKAL80ETC concert, -23, 0
        Conjured Mana Cake, -25, 0

        -------- day 29 --------
        name, sellIn, quality
        +5 Dexterity Vest, -19, 0
        Aged Brie, -27, 50
        Elixir of the Mongoose, -24, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -14, 0
        Backstage passes to a TAFKAL80ETC concert, -19, 0
        Backstage passes to a TAFKAL80ETC concert, -24, 0
        Conjured Mana Cake, -26, 0

        -------- day 30 --------
        name, sellIn, quality
        +5 Dexterity Vest, -20, 0
        Aged Brie, -28, 50
        Elixir of the Mongoose, -25, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -15, 0
        Backstage passes to a TAFKAL80ETC concert, -20, 0
        Backstage passes to a TAFKAL80ETC concert, -25, 0
        Conjured Mana Cake, -27, 0

        -------- day 31 --------
        name, sellIn, quality
        +5 Dexterity Vest, -21, 0
        Aged Brie, -29, 50
        Elixir of the Mongoose, -26, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -16, 0
        Backstage passes to a TAFKAL80ETC concert, -21, 0
        Backstage passes to a TAFKAL80ETC concert, -26, 0
        Conjured Mana Cake, -28, 0

        -------- day 32 --------
        name, sellIn, quality
        +5 Dexterity Vest, -22, 0
        Aged Brie, -30, 50
        Elixir of the Mongoose, -27, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -17, 0
        Backstage passes to a TAFKAL80ETC concert, -22, 0
        Backstage passes to a TAFKAL80ETC concert, -27, 0
        Conjured Mana Cake, -29, 0

        -------- day 33 --------
        name, sellIn, quality
        +5 Dexterity Vest, -23, 0
        Aged Brie, -31, 50
        Elixir of the Mongoose, -28, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -18, 0
        Backstage passes to a TAFKAL80ETC concert, -23, 0
        Backstage passes to a TAFKAL80ETC concert, -28, 0
        Conjured Mana Cake, -30, 0

        -------- day 34 --------
        name, sellIn, quality
        +5 Dexterity Vest, -24, 0
        Aged Brie, -32, 50
        Elixir of the Mongoose, -29, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -19, 0
        Backstage passes to a TAFKAL80ETC concert, -24, 0
        Backstage passes to a TAFKAL80ETC concert, -29, 0
        Conjured Mana Cake, -31, 0

        -------- day 35 --------
        name, sellIn, quality
        +5 Dexterity Vest, -25, 0
        Aged Brie, -33, 50
        Elixir of the Mongoose, -30, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -20, 0
        Backstage passes to a TAFKAL80ETC concert, -25, 0
        Backstage passes to a TAFKAL80ETC concert, -30, 0
        Conjured Mana Cake, -32, 0

        -------- day 36 --------
        name, sellIn, quality
        +5 Dexterity Vest, -26, 0
        Aged Brie, -34, 50
        Elixir of the Mongoose, -31, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -21, 0
        Backstage passes to a TAFKAL80ETC concert, -26, 0
        Backstage passes to a TAFKAL80ETC concert, -31, 0
        Conjured Mana Cake, -33, 0

        -------- day 37 --------
        name, sellIn, quality
        +5 Dexterity Vest, -27, 0
        Aged Brie, -35, 50
        Elixir of the Mongoose, -32, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -22, 0
        Backstage passes to a TAFKAL80ETC concert, -27, 0
        Backstage passes to a TAFKAL80ETC concert, -32, 0
        Conjured Mana Cake, -34, 0

        -------- day 38 --------
        name, sellIn, quality
        +5 Dexterity Vest, -28, 0
        Aged Brie, -36, 50
        Elixir of the Mongoose, -33, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -23, 0
        Backstage passes to a TAFKAL80ETC concert, -28, 0
        Backstage passes to a TAFKAL80ETC concert, -33, 0
        Conjured Mana Cake, -35, 0

        -------- day 39 --------
        name, sellIn, quality
        +5 Dexterity Vest, -29, 0
        Aged Brie, -37, 50
        Elixir of the Mongoose, -34, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -24, 0
        Backstage passes to a TAFKAL80ETC concert, -29, 0
        Backstage passes to a TAFKAL80ETC concert, -34, 0
        Conjured Mana Cake, -36, 0

        -------- day 40 --------
        name, sellIn, quality
        +5 Dexterity Vest, -30, 0
        Aged Brie, -38, 50
        Elixir of the Mongoose, -35, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -25, 0
        Backstage passes to a TAFKAL80ETC concert, -30, 0
        Backstage passes to a TAFKAL80ETC concert, -35, 0
        Conjured Mana Cake, -37, 0

        -------- day 41 --------
        name, sellIn, quality
        +5 Dexterity Vest, -31, 0
        Aged Brie, -39, 50
        Elixir of the Mongoose, -36, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -26, 0
        Backstage passes to a TAFKAL80ETC concert, -31, 0
        Backstage passes to a TAFKAL80ETC concert, -36, 0
        Conjured Mana Cake, -38, 0

        -------- day 42 --------
        name, sellIn, quality
        +5 Dexterity Vest, -32, 0
        Aged Brie, -40, 50
        Elixir of the Mongoose, -37, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -27, 0
        Backstage passes to a TAFKAL80ETC concert, -32, 0
        Backstage passes to a TAFKAL80ETC concert, -37, 0
        Conjured Mana Cake, -39, 0

        -------- day 43 --------
        name, sellIn, quality
        +5 Dexterity Vest, -33, 0
        Aged Brie, -41, 50
        Elixir of the Mongoose, -38, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -28, 0
        Backstage passes to a TAFKAL80ETC concert, -33, 0
        Backstage passes to a TAFKAL80ETC concert, -38, 0
        Conjured Mana Cake, -40, 0

        -------- day 44 --------
        name, sellIn, quality
        +5 Dexterity Vest, -34, 0
        Aged Brie, -42, 50
        Elixir of the Mongoose, -39, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -29, 0
        Backstage passes to a TAFKAL80ETC concert, -34, 0
        Backstage passes to a TAFKAL80ETC concert, -39, 0
        Conjured Mana Cake, -41, 0

        -------- day 45 --------
        name, sellIn, quality
        +5 Dexterity Vest, -35, 0
        Aged Brie, -43, 50
        Elixir of the Mongoose, -40, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -30, 0
        Backstage passes to a TAFKAL80ETC concert, -35, 0
        Backstage passes to a TAFKAL80ETC concert, -40, 0
        Conjured Mana Cake, -42, 0

        -------- day 46 --------
        name, sellIn, quality
        +5 Dexterity Vest, -36, 0
        Aged Brie, -44, 50
        Elixir of the Mongoose, -41, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -31, 0
        Backstage passes to a TAFKAL80ETC concert, -36, 0
        Backstage passes to a TAFKAL80ETC concert, -41, 0
        Conjured Mana Cake, -43, 0

        -------- day 47 --------
        name, sellIn, quality
        +5 Dexterity Vest, -37, 0
        Aged Brie, -45, 50
        Elixir of the Mongoose, -42, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -32, 0
        Backstage passes to a TAFKAL80ETC concert, -37, 0
        Backstage passes to a TAFKAL80ETC concert, -42, 0
        Conjured Mana Cake, -44, 0

        -------- day 48 --------
        name, sellIn, quality
        +5 Dexterity Vest, -38, 0
        Aged Brie, -46, 50
        Elixir of the Mongoose, -43, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -33, 0
        Backstage passes to a TAFKAL80ETC concert, -38, 0
        Backstage passes to a TAFKAL80ETC concert, -43, 0
        Conjured Mana Cake, -45, 0

        -------- day 49 --------
        name, sellIn, quality
        +5 Dexterity Vest, -39, 0
        Aged Brie, -47, 50
        Elixir of the Mongoose, -44, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -34, 0
        Backstage passes to a TAFKAL80ETC concert, -39, 0
        Backstage passes to a TAFKAL80ETC concert, -44, 0
        Conjured Mana Cake, -46, 0

        -------- day 50 --------
        name, sellIn, quality
        +5 Dexterity Vest, -40, 0
        Aged Brie, -48, 50
        Elixir of the Mongoose, -45, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -35, 0
        Backstage passes to a TAFKAL80ETC concert, -40, 0
        Backstage passes to a TAFKAL80ETC concert, -45, 0
        Conjured Mana Cake, -47, 0

        -------- day 51 --------
        name, sellIn, quality
        +5 Dexterity Vest, -41, 0
        Aged Brie, -49, 50
        Elixir of the Mongoose, -46, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -36, 0
        Backstage passes to a TAFKAL80ETC concert, -41, 0
        Backstage passes to a TAFKAL80ETC concert, -46, 0
        Conjured Mana Cake, -48, 0

        -------- day 52 --------
        name, sellIn, quality
        +5 Dexterity Vest, -42, 0
        Aged Brie, -50, 50
        Elixir of the Mongoose, -47, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -37, 0
        Backstage passes to a TAFKAL80ETC concert, -42, 0
        Backstage passes to a TAFKAL80ETC concert, -47, 0
        Conjured Mana Cake, -49, 0

        -------- day 53 --------
        name, sellIn, quality
        +5 Dexterity Vest, -43, 0
        Aged Brie, -51, 50
        Elixir of the Mongoose, -48, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -38, 0
        Backstage passes to a TAFKAL80ETC concert, -43, 0
        Backstage passes to a TAFKAL80ETC concert, -48, 0
        Conjured Mana Cake, -50, 0

        -------- day 54 --------
        name, sellIn, quality
        +5 Dexterity Vest, -44, 0
        Aged Brie, -52, 50
        Elixir of the Mongoose, -49, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -39, 0
        Backstage passes to a TAFKAL80ETC concert, -44, 0
        Backstage passes to a TAFKAL80ETC concert, -49, 0
        Conjured Mana Cake, -51, 0

        -------- day 55 --------
        name, sellIn, quality
        +5 Dexterity Vest, -45, 0
        Aged Brie, -53, 50
        Elixir of the Mongoose, -50, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -40, 0
        Backstage passes to a TAFKAL80ETC concert, -45, 0
        Backstage passes to a TAFKAL80ETC concert, -50, 0
        Conjured Mana Cake, -52, 0

        -------- day 56 --------
        name, sellIn, quality
        +5 Dexterity Vest, -46, 0
        Aged Brie, -54, 50
        Elixir of the Mongoose, -51, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -41, 0
        Backstage passes to a TAFKAL80ETC concert, -46, 0
        Backstage passes to a TAFKAL80ETC concert, -51, 0
        Conjured Mana Cake, -53, 0

        -------- day 57 --------
        name, sellIn, quality
        +5 Dexterity Vest, -47, 0
        Aged Brie, -55, 50
        Elixir of the Mongoose, -52, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -42, 0
        Backstage passes to a TAFKAL80ETC concert, -47, 0
        Backstage passes to a TAFKAL80ETC concert, -52, 0
        Conjured Mana Cake, -54, 0

        -------- day 58 --------
        name, sellIn, quality
        +5 Dexterity Vest, -48, 0
        Aged Brie, -56, 50
        Elixir of the Mongoose, -53, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -43, 0
        Backstage passes to a TAFKAL80ETC concert, -48, 0
        Backstage passes to a TAFKAL80ETC concert, -53, 0
        Conjured Mana Cake, -55, 0

        -------- day 59 --------
        name, sellIn, quality
        +5 Dexterity Vest, -49, 0
        Aged Brie, -57, 50
        Elixir of the Mongoose, -54, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -44, 0
        Backstage passes to a TAFKAL80ETC concert, -49, 0
        Backstage passes to a TAFKAL80ETC concert, -54, 0
        Conjured Mana Cake, -56, 0

        -------- day 60 --------
        name, sellIn, quality
        +5 Dexterity Vest, -50, 0
        Aged Brie, -58, 50
        Elixir of the Mongoose, -55, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -45, 0
        Backstage passes to a TAFKAL80ETC concert, -50, 0
        Backstage passes to a TAFKAL80ETC concert, -55, 0
        Conjured Mana Cake, -57, 0

        -------- day 61 --------
        name, sellIn, quality
        +5 Dexterity Vest, -51, 0
        Aged Brie, -59, 50
        Elixir of the Mongoose, -56, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -46, 0
        Backstage passes to a TAFKAL80ETC concert, -51, 0
        Backstage passes to a TAFKAL80ETC concert, -56, 0
        Conjured Mana Cake, -58, 0

        -------- day 62 --------
        name, sellIn, quality
        +5 Dexterity Vest, -52, 0
        Aged Brie, -60, 50
        Elixir of the Mongoose, -57, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -47, 0
        Backstage passes to a TAFKAL80ETC concert, -52, 0
        Backstage passes to a TAFKAL80ETC concert, -57, 0
        Conjured Mana Cake, -59, 0

        -------- day 63 --------
        name, sellIn, quality
        +5 Dexterity Vest, -53, 0
        Aged Brie, -61, 50
        Elixir of the Mongoose, -58, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -48, 0
        Backstage passes to a TAFKAL80ETC concert, -53, 0
        Backstage passes to a TAFKAL80ETC concert, -58, 0
        Conjured Mana Cake, -60, 0

        -------- day 64 --------
        name, sellIn, quality
        +5 Dexterity Vest, -54, 0
        Aged Brie, -62, 50
        Elixir of the Mongoose, -59, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -49, 0
        Backstage passes to a TAFKAL80ETC concert, -54, 0
        Backstage passes to a TAFKAL80ETC concert, -59, 0
        Conjured Mana Cake, -61, 0

        -------- day 65 --------
        name, sellIn, quality
        +5 Dexterity Vest, -55, 0
        Aged Brie, -63, 50
        Elixir of the Mongoose, -60, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -50, 0
        Backstage passes to a TAFKAL80ETC concert, -55, 0
        Backstage passes to a TAFKAL80ETC concert, -60, 0
        Conjured Mana Cake, -62, 0

        -------- day 66 --------
        name, sellIn, quality
        +5 Dexterity Vest, -56, 0
        Aged Brie, -64, 50
        Elixir of the Mongoose, -61, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -51, 0
        Backstage passes to a TAFKAL80ETC concert, -56, 0
        Backstage passes to a TAFKAL80ETC concert, -61, 0
        Conjured Mana Cake, -63, 0

        -------- day 67 --------
        name, sellIn, quality
        +5 Dexterity Vest, -57, 0
        Aged Brie, -65, 50
        Elixir of the Mongoose, -62, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -52, 0
        Backstage passes to a TAFKAL80ETC concert, -57, 0
        Backstage passes to a TAFKAL80ETC concert, -62, 0
        Conjured Mana Cake, -64, 0

        -------- day 68 --------
        name, sellIn, quality
        +5 Dexterity Vest, -58, 0
        Aged Brie, -66, 50
        Elixir of the Mongoose, -63, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -53, 0
        Backstage passes to a TAFKAL80ETC concert, -58, 0
        Backstage passes to a TAFKAL80ETC concert, -63, 0
        Conjured Mana Cake, -65, 0

        -------- day 69 --------
        name, sellIn, quality
        +5 Dexterity Vest, -59, 0
        Aged Brie, -67, 50
        Elixir of the Mongoose, -64, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -54, 0
        Backstage passes to a TAFKAL80ETC concert, -59, 0
        Backstage passes to a TAFKAL80ETC concert, -64, 0
        Conjured Mana Cake, -66, 0

        -------- day 70 --------
        name, sellIn, quality
        +5 Dexterity Vest, -60, 0
        Aged Brie, -68, 50
        Elixir of the Mongoose, -65, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -55, 0
        Backstage passes to a TAFKAL80ETC concert, -60, 0
        Backstage passes to a TAFKAL80ETC concert, -65, 0
        Conjured Mana Cake, -67, 0

        -------- day 71 --------
        name, sellIn, quality
        +5 Dexterity Vest, -61, 0
        Aged Brie, -69, 50
        Elixir of the Mongoose, -66, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -56, 0
        Backstage passes to a TAFKAL80ETC concert, -61, 0
        Backstage passes to a TAFKAL80ETC concert, -66, 0
        Conjured Mana Cake, -68, 0

        -------- day 72 --------
        name, sellIn, quality
        +5 Dexterity Vest, -62, 0
        Aged Brie, -70, 50
        Elixir of the Mongoose, -67, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -57, 0
        Backstage passes to a TAFKAL80ETC concert, -62, 0
        Backstage passes to a TAFKAL80ETC concert, -67, 0
        Conjured Mana Cake, -69, 0

        -------- day 73 --------
        name, sellIn, quality
        +5 Dexterity Vest, -63, 0
        Aged Brie, -71, 50
        Elixir of the Mongoose, -68, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -58, 0
        Backstage passes to a TAFKAL80ETC concert, -63, 0
        Backstage passes to a TAFKAL80ETC concert, -68, 0
        Conjured Mana Cake, -70, 0

        -------- day 74 --------
        name, sellIn, quality
        +5 Dexterity Vest, -64, 0
        Aged Brie, -72, 50
        Elixir of the Mongoose, -69, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -59, 0
        Backstage passes to a TAFKAL80ETC concert, -64, 0
        Backstage passes to a TAFKAL80ETC concert, -69, 0
        Conjured Mana Cake, -71, 0

        -------- day 75 --------
        name, sellIn, quality
        +5 Dexterity Vest, -65, 0
        Aged Brie, -73, 50
        Elixir of the Mongoose, -70, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -60, 0
        Backstage passes to a TAFKAL80ETC concert, -65, 0
        Backstage passes to a TAFKAL80ETC concert, -70, 0
        Conjured Mana Cake, -72, 0

        -------- day 76 --------
        name, sellIn, quality
        +5 Dexterity Vest, -66, 0
        Aged Brie, -74, 50
        Elixir of the Mongoose, -71, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -61, 0
        Backstage passes to a TAFKAL80ETC concert, -66, 0
        Backstage passes to a TAFKAL80ETC concert, -71, 0
        Conjured Mana Cake, -73, 0

        -------- day 77 --------
        name, sellIn, quality
        +5 Dexterity Vest, -67, 0
        Aged Brie, -75, 50
        Elixir of the Mongoose, -72, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -62, 0
        Backstage passes to a TAFKAL80ETC concert, -67, 0
        Backstage passes to a TAFKAL80ETC concert, -72, 0
        Conjured Mana Cake, -74, 0

        -------- day 78 --------
        name, sellIn, quality
        +5 Dexterity Vest, -68, 0
        Aged Brie, -76, 50
        Elixir of the Mongoose, -73, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -63, 0
        Backstage passes to a TAFKAL80ETC concert, -68, 0
        Backstage passes to a TAFKAL80ETC concert, -73, 0
        Conjured Mana Cake, -75, 0

        -------- day 79 --------
        name, sellIn, quality
        +5 Dexterity Vest, -69, 0
        Aged Brie, -77, 50
        Elixir of the Mongoose, -74, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -64, 0
        Backstage passes to a TAFKAL80ETC concert, -69, 0
        Backstage passes to a TAFKAL80ETC concert, -74, 0
        Conjured Mana Cake, -76, 0

        -------- day 80 --------
        name, sellIn, quality
        +5 Dexterity Vest, -70, 0
        Aged Brie, -78, 50
        Elixir of the Mongoose, -75, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -65, 0
        Backstage passes to a TAFKAL80ETC concert, -70, 0
        Backstage passes to a TAFKAL80ETC concert, -75, 0
        Conjured Mana Cake, -77, 0

        -------- day 81 --------
        name, sellIn, quality
        +5 Dexterity Vest, -71, 0
        Aged Brie, -79, 50
        Elixir of the Mongoose, -76, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -66, 0
        Backstage passes to a TAFKAL80ETC concert, -71, 0
        Backstage passes to a TAFKAL80ETC concert, -76, 0
        Conjured Mana Cake, -78, 0

        -------- day 82 --------
        name, sellIn, quality
        +5 Dexterity Vest, -72, 0
        Aged Brie, -80, 50
        Elixir of the Mongoose, -77, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -67, 0
        Backstage passes to a TAFKAL80ETC concert, -72, 0
        Backstage passes to a TAFKAL80ETC concert, -77, 0
        Conjured Mana Cake, -79, 0

        -------- day 83 --------
        name, sellIn, quality
        +5 Dexterity Vest, -73, 0
        Aged Brie, -81, 50
        Elixir of the Mongoose, -78, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -68, 0
        Backstage passes to a TAFKAL80ETC concert, -73, 0
        Backstage passes to a TAFKAL80ETC concert, -78, 0
        Conjured Mana Cake, -80, 0

        -------- day 84 --------
        name, sellIn, quality
        +5 Dexterity Vest, -74, 0
        Aged Brie, -82, 50
        Elixir of the Mongoose, -79, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -69, 0
        Backstage passes to a TAFKAL80ETC concert, -74, 0
        Backstage passes to a TAFKAL80ETC concert, -79, 0
        Conjured Mana Cake, -81, 0

        -------- day 85 --------
        name, sellIn, quality
        +5 Dexterity Vest, -75, 0
        Aged Brie, -83, 50
        Elixir of the Mongoose, -80, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -70, 0
        Backstage passes to a TAFKAL80ETC concert, -75, 0
        Backstage passes to a TAFKAL80ETC concert, -80, 0
        Conjured Mana Cake, -82, 0

        -------- day 86 --------
        name, sellIn, quality
        +5 Dexterity Vest, -76, 0
        Aged Brie, -84, 50
        Elixir of the Mongoose, -81, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -71, 0
        Backstage passes to a TAFKAL80ETC concert, -76, 0
        Backstage passes to a TAFKAL80ETC concert, -81, 0
        Conjured Mana Cake, -83, 0

        -------- day 87 --------
        name, sellIn, quality
        +5 Dexterity Vest, -77, 0
        Aged Brie, -85, 50
        Elixir of the Mongoose, -82, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -72, 0
        Backstage passes to a TAFKAL80ETC concert, -77, 0
        Backstage passes to a TAFKAL80ETC concert, -82, 0
        Conjured Mana Cake, -84, 0

        -------- day 88 --------
        name, sellIn, quality
        +5 Dexterity Vest, -78, 0
        Aged Brie, -86, 50
        Elixir of the Mongoose, -83, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -73, 0
        Backstage passes to a TAFKAL80ETC concert, -78, 0
        Backstage passes to a TAFKAL80ETC concert, -83, 0
        Conjured Mana Cake, -85, 0

        -------- day 89 --------
        name, sellIn, quality
        +5 Dexterity Vest, -79, 0
        Aged Brie, -87, 50
        Elixir of the Mongoose, -84, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -74, 0
        Backstage passes to a TAFKAL80ETC concert, -79, 0
        Backstage passes to a TAFKAL80ETC concert, -84, 0
        Conjured Mana Cake, -86, 0

        -------- day 90 --------
        name, sellIn, quality
        +5 Dexterity Vest, -80, 0
        Aged Brie, -88, 50
        Elixir of the Mongoose, -85, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -75, 0
        Backstage passes to a TAFKAL80ETC concert, -80, 0
        Backstage passes to a TAFKAL80ETC concert, -85, 0
        Conjured Mana Cake, -87, 0

        -------- day 91 --------
        name, sellIn, quality
        +5 Dexterity Vest, -81, 0
        Aged Brie, -89, 50
        Elixir of the Mongoose, -86, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -76, 0
        Backstage passes to a TAFKAL80ETC concert, -81, 0
        Backstage passes to a TAFKAL80ETC concert, -86, 0
        Conjured Mana Cake, -88, 0

        -------- day 92 --------
        name, sellIn, quality
        +5 Dexterity Vest, -82, 0
        Aged Brie, -90, 50
        Elixir of the Mongoose, -87, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -77, 0
        Backstage passes to a TAFKAL80ETC concert, -82, 0
        Backstage passes to a TAFKAL80ETC concert, -87, 0
        Conjured Mana Cake, -89, 0

        -------- day 93 --------
        name, sellIn, quality
        +5 Dexterity Vest, -83, 0
        Aged Brie, -91, 50
        Elixir of the Mongoose, -88, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -78, 0
        Backstage passes to a TAFKAL80ETC concert, -83, 0
        Backstage passes to a TAFKAL80ETC concert, -88, 0
        Conjured Mana Cake, -90, 0

        -------- day 94 --------
        name, sellIn, quality
        +5 Dexterity Vest, -84, 0
        Aged Brie, -92, 50
        Elixir of the Mongoose, -89, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -79, 0
        Backstage passes to a TAFKAL80ETC concert, -84, 0
        Backstage passes to a TAFKAL80ETC concert, -89, 0
        Conjured Mana Cake, -91, 0

        -------- day 95 --------
        name, sellIn, quality
        +5 Dexterity Vest, -85, 0
        Aged Brie, -93, 50
        Elixir of the Mongoose, -90, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -80, 0
        Backstage passes to a TAFKAL80ETC concert, -85, 0
        Backstage passes to a TAFKAL80ETC concert, -90, 0
        Conjured Mana Cake, -92, 0

        -------- day 96 --------
        name, sellIn, quality
        +5 Dexterity Vest, -86, 0
        Aged Brie, -94, 50
        Elixir of the Mongoose, -91, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -81, 0
        Backstage passes to a TAFKAL80ETC concert, -86, 0
        Backstage passes to a TAFKAL80ETC concert, -91, 0
        Conjured Mana Cake, -93, 0

        -------- day 97 --------
        name, sellIn, quality
        +5 Dexterity Vest, -87, 0
        Aged Brie, -95, 50
        Elixir of the Mongoose, -92, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -82, 0
        Backstage passes to a TAFKAL80ETC concert, -87, 0
        Backstage passes to a TAFKAL80ETC concert, -92, 0
        Conjured Mana Cake, -94, 0

        -------- day 98 --------
        name, sellIn, quality
        +5 Dexterity Vest, -88, 0
        Aged Brie, -96, 50
        Elixir of the Mongoose, -93, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -83, 0
        Backstage passes to a TAFKAL80ETC concert, -88, 0
        Backstage passes to a TAFKAL80ETC concert, -93, 0
        Conjured Mana Cake, -95, 0

        -------- day 99 --------
        name, sellIn, quality
        +5 Dexterity Vest, -89, 0
        Aged Brie, -97, 50
        Elixir of the Mongoose, -94, 0
        Sulfuras, Hand of Ragnaros, 0, 80
        Sulfuras, Hand of Ragnaros, -1, 80
        Backstage passes to a TAFKAL80ETC concert, -84, 0
        Backstage passes to a TAFKAL80ETC concert, -89, 0
        Backstage passes to a TAFKAL80ETC concert, -94, 0
        Conjured Mana Cake, -96, 0


    """.trimIndent()
}
