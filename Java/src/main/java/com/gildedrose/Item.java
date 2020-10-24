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

    public void updateSellIn(){
        sellIn=sellIn-1;
    }
    public void updateQuality(){
        if(sellIn>0){
            if(quality>0){
                quality--;
            }
        }else{
            if(quality>0){
                quality=quality-2;
            }
        }
    }
}
