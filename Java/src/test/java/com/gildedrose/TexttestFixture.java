package com.gildedrose;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class TexttestFixture {
    public static void main(String[] args) {
        String baseline = getBaseline();
        System.out.println(baseline);
    }

    public static String getBaseline() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream=new PrintStream(out);
        printStream.println("OMGHAI!");
        Item[] items = new Item[] {
                new Common("+5 Dexterity Vest", 10, 20),
                new AgedBrie(2, 0), //
                new Common("Elixir of the Mongoose", 5, 7), //
                new Sulfuras(0, 80), //
                new Sulfuras(-1, 80),
                new BackstagePass(15, 20),
                new BackstagePass(10, 49),
                new BackstagePass(5, 49),
                new Conjured(3, 6) };

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
