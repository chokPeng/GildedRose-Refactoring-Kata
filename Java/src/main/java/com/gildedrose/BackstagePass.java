package com.gildedrose;public class BackstagePass extends Item {    public BackstagePass(int sellIn, int quality) {        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);    }    @Override    protected void updateQualityAfterExpiration() {        quality = 0;    }    @Override    protected void updateQuality() {        if (quality >= 50) {            return;        }        increaseQuality();        if (sellIn < 11) {            increaseQuality();        }        if (sellIn < 6) {            increaseQuality();        }    }}