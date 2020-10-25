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
    void passOneDay() {
        updateQuality();
        updateSellIn();

        if (isExpired()) {
            updateQualityAfterExpiration();
        }
    }

    protected void updateQuality() {
        updateQualityWhenBiggerThan0();
    }


    protected void updateQualityAfterExpiration() {
        updateQualityWhenBiggerThan0();
    }

    protected void updateSellIn() {
        sellIn--;
    }

    protected boolean isExpired() {
        return sellIn < 0;
    }

    private void updateQualityWhenBiggerThan0() {
        if (quality > 0) {
            quality--;
        }
    }
}
