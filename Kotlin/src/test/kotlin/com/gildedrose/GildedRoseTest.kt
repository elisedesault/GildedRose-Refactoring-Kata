package com.gildedrose

import com.sun.java.accessibility.util.GUIInitializedListener
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun foo() {
        val items = arrayOf<Item>(Item("fixme", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("fixme", app.items[0].name)

    }

    @Test
    fun checkQuality_whenSellInValueZero() {
        val sellIn = 4
        val quality = 10
        val items = arrayOf<Item>(Item("niceRose", sellIn, quality))
        val app = GildedRose(items)
        for (day in sellIn downTo 1) {
            app.updateQuality()
        }

        assertEquals(quality - sellIn, app.items[0].quality, "Quality when sellIn passed")
    }


    @Test
    fun checkQuality_whenSellByDatePassedByOneDay() {
        val sellIn = 4
        val quality = 10
        val items = arrayOf<Item>(Item("niceRose", sellIn, quality))
        val app = GildedRose(items)
        for (day in sellIn downTo 0) {
            app.updateQuality()
        }

        app.updateQuality()
        assertEquals(quality - 6, app.items[0].quality, "Quality when sellIn passed")
    }

    @Test
    fun checkQuality_whenNeverLowerThanZero() {
        val sellIn = 4
        val quality = 3
        val items = arrayOf<Item>(Item("niceRose", sellIn, quality))
        val app = GildedRose(items)
        for (day in sellIn downTo 0) {
            app.updateQuality()
        }

        assertTrue(app.items[0].quality == 0, "Quality never lower than zero")
    }

    @Test
    fun checkQuality_AgedBrieIncrease_when2DaysOlder() {
        val sellIn = 5
        val quality = 3
        val items = arrayOf<Item>(Item("Aged Brie", sellIn, quality))
        val app = GildedRose(items)

        app.updateQuality()
        app.updateQuality()

        assertEquals(quality + 2, app.items[0].quality, "Quality increases")
    }

    @Test
    fun checkQuality_whenNeverMoreThan50() {
        val sellIn = 5
        val quality = 47
        val items = arrayOf<Item>(Item("Aged Brie", sellIn, quality))
        val app = GildedRose(items)

        for (day in sellIn downTo 1) {
            app.updateQuality()
        }

        assertTrue(app.items[0].quality <= 50, "Quality never more than 50 ")
    }

    @Test
    fun checkQuality_Sulfuras_whenNeverDecreases() {
        val sellIn = 5
        val quality = 80
        val items = arrayOf<Item>(Item("Sulfuras, Hand of Ragnaros", sellIn, quality))
        val app = GildedRose(items)

        for (day in sellIn downTo 1) {
            app.updateQuality()
        }

        assertEquals(quality, app.items[0].quality, "Quality always the same ")
    }

    @Test
    fun checkSellIn_Sulfuras_whenNeverHasToBeSold() {
        val sellIn = 5
        val quality = 80
        val items = arrayOf<Item>(Item("Sulfuras, Hand of Ragnaros", sellIn, quality))
        val app = GildedRose(items)

        app.updateQuality()
        assertEquals(sellIn, app.items[0].sellIn, "SellIn value always the same ")

        app.updateQuality()
        assertEquals(sellIn, app.items[0].sellIn, "SellIn value always the same ")
    }

    @Test
    fun checkQuality_BackstagePasses_whenMoreThan10Days() {
        val sellIn = 15
        val quality = 3
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality))
        val app = GildedRose(items)

        while (app.items[0].sellIn > 10) {
            app.updateQuality()
        }

        assertEquals(8, app.items[0].quality, "Quality increases by 1")

        app.updateQuality()
        assertEquals(10, app.items[0].quality, "Quality increases by 2 when below 10 days")
    }

    @Test
    fun checkQuality_BackstagePasses_whenLessThan5Days() {
        val sellIn = 15
        val quality = 3
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality))
        val app = GildedRose(items)

        while (app.items[0].sellIn > 5) {
            app.updateQuality()
        }

        assertEquals(18, app.items[0].quality, "Quality increases by 1 till 1O days and by 2 bellow 10 days")

        app.updateQuality()
        assertEquals(21, app.items[0].quality, "Quality increases by 3 when below 5 days")
    }

    @Test
    fun checkQuality_BackstagePasses_whenSellInDay() {
        val sellIn = 15
        val quality = 3
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality))
        val app = GildedRose(items)

        while (app.items[0].sellIn > 0) {
            app.updateQuality()
        }

        assertEquals(
            33,
            app.items[0].quality,
            "Quality increases by 1 till 1O days and by 2 bellow 10 days and by 3 when below 5 days"
        )

        app.updateQuality()
        assertEquals(0, app.items[0].quality, "Quality drops on sellIn Day")
    }

    @Test
    fun checkQuality_Conjured_whenQualityDecreasesTwiceAsFastAsNormal(){
        val sellIn = 4
        val quality = 20
        val items = arrayOf<Item>(Item("Conjured", sellIn, quality))
        val app = GildedRose(items)
        for (day in sellIn downTo 0) {
            app.updateQuality()
        }

        app.updateQuality()
        assertEquals(quality - 12, app.items[0].quality, "Quality when sellIn passed")
    }

    @Test
    fun checkQuality_Sulfuras_whenNeverAlters(){
        val sellIn = 4
        val quality = 80
        val items = arrayOf<Item>(Item("Sulfuras, Hand of Ragnaros", sellIn, quality))
        val app = GildedRose(items)
        for (day in sellIn downTo 0) {
            app.updateQuality()
        }

        app.updateQuality()
        assertEquals(quality , app.items[0].quality, "Quality always the same")
    }
}


