package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            when (items[i].name) {
                agedBrie -> {
                    evaluateQualityForAgedBrie(items[i])
                }
                backstage -> {
                    evaluateQualityForBackstage(items[i])
                }
                sulfuras -> {
                }
                else -> {
                    evaluateQualityForRose(items[i])
                }
            }
        }
    }

    private fun evaluateQualityForRose(item: Item) {
        item.apply {
            if (!isQualityZero(quality)) {
                quality -= 1
            }
            sellIn -= 1
        }
    }

    private fun evaluateQualityForBackstage(item: Item) {
        item.apply {
            if (!isMaxQualityReached(quality)) {
                quality += 1

                if (sellIn < 11 && !isMaxQualityReached(quality)) {
                    quality += 1
                }

                if (sellIn < 6 && !isMaxQualityReached(quality)) {
                    quality += 1
                }
            }

            sellIn -= 1

            if (isSellInPassed(sellIn)) {
                quality = 0
            }
        }
    }

    private fun evaluateQualityForAgedBrie(item: Item) {
        item.apply {
            if (!isMaxQualityReached(quality)) {
                quality += 1
            }
            sellIn -= 1
        }
    }

    private fun isMaxQualityReached(quality: Int) = quality >= 50
    private fun isQualityZero(quality: Int) = quality == 0
    private fun isSellInPassed(sellInValue: Int) = sellInValue < 0

    companion object{
        private const val agedBrie = "Aged Brie"
        private const val backstage = "Backstage passes to a TAFKAL80ETC concert"
        private const val sulfuras = "Sulfuras, Hand of Ragnaros"
    }
}

