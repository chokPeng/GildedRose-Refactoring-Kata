package com.gildedrose;public class BackstagePass extends Item {    public BackstagePass( int sellIn, int quality) {        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);    }    @Override    public void updateQuality() {        if(sellIn>0){            if(sellIn>10){                if(quality<50){                    quality++;                }            }else if (sellIn>5){                if(quality>48){                    quality=50;                }else {                    quality=quality+2;                }            }else {                if(quality>47){                    quality=50;                }else {                    quality=quality+3;                }            }        }else {            quality=0;        }    }}