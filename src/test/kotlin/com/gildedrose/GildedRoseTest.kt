package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GildedRoseTest {
    @Test
    fun `item name doesn't change`() {
        val gildedRose = GildedRose(items = arrayOf(Item("foo", 0, 0)))
        gildedRose.update()
        assertEquals("foo", gildedRose.items[0].name)
    }
}

