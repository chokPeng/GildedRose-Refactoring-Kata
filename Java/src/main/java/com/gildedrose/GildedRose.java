package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Boolean isSulfuras = items[i].name.equals("Sulfuras, Hand of Ragnaros");
            if (isSulfuras) {
                continue;
            }

            items[i].sellIn = items[i].sellIn - 1;

            Boolean isAgedBrie = items[i].name.equals("Aged Brie");
            if (isAgedBrie) {
                items[i].quality = handleAgedBrie(items[i].sellIn, items[i].quality);
                continue;
            }

            Boolean isBackstreetPasses = items[i].name.equals("Backstage passes to a TAFKAL80ETC concert");
            if (isBackstreetPasses) {
                if (items[i].sellIn <= 0) {
                    items[i].quality = 0;
                } else {
                    items[i].quality = handleBackstreetPasses(items[i].sellIn, items[i].quality);
                }
                continue;
            }

            Boolean isConjured = items[i].name.equals("Conjured Mana Cake");
            if (isConjured) {
                if (items[i].sellIn <= 0) {
                    items[i].quality = handleConjured(items[i].name, items[i].quality);
                }
                items[i].quality = handleConjured(items[i].name, items[i].quality);
                continue;
            }

            //普通物品
            if (items[i].sellIn <= 0) {
                items[i].quality = handleOrdinaryGoods(items[i].name, items[i].quality);
            }
            items[i].quality = handleOrdinaryGoods(items[i].name, items[i].quality);
            continue;
        }
    }

    private int handleOrdinaryGoods(String name, int quality) {
        if (quality <= 0) {
            return 0;
        }
        return quality - 1;
    }

    private int handleConjured(String name, int quality) {
        if (quality <= 0) {
            return 0;
        }
        return quality - 2 > 0 ? quality - 2 : 0;
    }

    private int handleAgedBrie(int sellIn, int quality) {
        if (quality >= 50) {
            return quality;
        }
        return quality + 1;
    }

    private int handleBackstreetPasses(int sellIn, int quality) {
        if (quality >= 50) {
            return quality;
        }
        quality = quality + 1;
        //10>=sellIn>5,则+2(之前已经+1，这里只需+1）
        if (11 > sellIn && quality < 50) {
            quality = quality + 1;
        }
        //5>=sellIn>0,则+3(之前已经+2，这里只需+1）
        if (sellIn < 6 && quality < 50) {
            quality = quality + 1;
        }
        return quality;
    }
}