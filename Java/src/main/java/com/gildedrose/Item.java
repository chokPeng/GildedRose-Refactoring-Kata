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
    protected void updateSellIn(){
        sellIn=sellIn-1;
    }

    public boolean isSulfuras() {
        return name.equals("Sulfuras, Hand of Ragnaros");
    }

    public boolean isBackstagePass() {
        return name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    public boolean isAgedBrie() {
        return name.equals("Aged Brie");
    }


    void passOneDay() {
        updateQuality();
        updateSe();

        if (isExpired()) {
            updateQualityAfterExpiration();
        }
    }

    protected void updateQuality() {
        if (!isAgedBrie()
                && !isBackstagePass()) {
            if (quality > 0) {
                if (!isSulfuras()) {
                    quality--;
                }
            }
        } else {
            if (quality < 50) {
                quality++;

                if (isBackstagePass()) {
                    if (sellIn < 11) {
                        if (quality < 50) {
                            quality++;
                        }
                    }

                    if (sellIn < 6) {
                        if (quality < 50) {
                            quality++;
                        }
                    }
                }
            }
        }
    }

    private void updateQualityAfterExpiration() {
        if (!isAgedBrie()) {
            if (!isBackstagePass()) {
                if (quality > 0) {
                    if (!isSulfuras()) {
                        quality--;
                    }
                }
            } else {
                quality = 0;
            }
        } else {
            if (quality < 50) {
                quality++;
            }
        }
    }

    private void updateSe() {
        if (!isSulfuras()) {
            sellIn--;
        }
    }

    private boolean isExpired() {
        return sellIn < 0;
    }
}
