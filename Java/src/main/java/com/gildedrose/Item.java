package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    protected boolean isSulfuras() {
        return false;
    }

    protected boolean isBackstagePass() {
        return false;
    }

    protected boolean isAgedBrie() {
        return false;
    }

    protected boolean isCommon() {
        return false;
    }

    protected boolean isConjured() {
        return false;
    }

    void passOneDay() {
        updateQuality();
        updateSellIn();

        if (isExpired()) {
            updateQualityAfterExpiration();
        }
    }

    protected void updateQuality() {
        if (quality > 0) {
            quality--;
        }
    }

    protected void updateQualityAfterExpiration() {
        if (quality > 0) {
            quality--;
        }
    }

    protected void updateSellIn() {
        sellIn--;
    }

    protected boolean isExpired() {
        return sellIn < 0;
    }
}
