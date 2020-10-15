package com.gildedrose;import org.junit.jupiter.api.Test;import static org.junit.jupiter.api.Assertions.*;class CommonTest {    @Test    void should_quality_equals_0_and_sellIn_decr_by_1_when_update_given_in_expired_and_quality_equals_0() {        Item item = new Common("ss",-1, 0);        item.updateSellIn();        item.updateQuality();        assert (item.quality == 0);        assert (item.sellIn == -2);    }    @Test    void should_quality_equals_0_and_sellIn_decr_by_1_when_update_given_in_expired_and_quality_between_0_1() {        Item item = new Common("ss",-1, 1);        item.updateSellIn();        item.updateQuality();        assert (item.quality == 0);        assert (item.sellIn == -2);    }    @Test    void should_quality_decr_by_2_and_sellIn_decr_by_1_when_update_given_in_expired_and_quality_above_2() {        Item item = new Common("ss",-1, 3);        item.updateSellIn();        item.updateQuality();        assert (item.quality == 1);        assert (item.sellIn == -2);    }}