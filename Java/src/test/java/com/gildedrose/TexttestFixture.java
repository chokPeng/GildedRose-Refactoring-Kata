package com.gildedrose;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TexttestFixture {
    public static void main(String[] args) {
//        PrintStream out = System.out;
        String baseline = getBaseline();
        System.out.println(baseline);
    }

    public static String getBaseline() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream=new PrintStream(out);
        printStream.println("OMGHAI!");

        Item[] items = new Item[] {
//                new Item("+5 Dexterity Vest", 10, 20), //
                Item.createCommon("+5 Dexterity Vest", 10, 20),
                Item.createAgedBrie(2, 0), //
                Item.createCommon("Elixir of the Mongoose", 5, 7), //
                Item.createSulfuras(0, 80), //
                Item.createSulfuras(-1, 80),
                Item.createBackstagePass(15, 20),
                Item.createBackstagePass(10, 49),
                Item.createBackstagePass(5, 49),
                Item.createConjured(3, 6) };

        GildedRose app = new GildedRose(items);

        int days = 10;


        for (int i = 0; i < days; i++) {
            printStream.println("-------- day " + i + " --------");
            printStream.println("name, sellIn, quality");
            for (Item item : items) {
                printStream.println(item);
            }
            printStream.println();
            app.passOneDay();
        }
        return out.toString();
    }

}
