package com.xgen.interview;

import com.xgen.interview.Pricer;
import com.xgen.interview.ShoppingCart;
import org.junit.BeforeClass;
import org.junit.Test;
import com.xgen.*;
import org.junit.runner.RunWith;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ShoppingCartTest {
    static ShoppingCart sc;

    @BeforeClass
    public static void onlyOnce() {
       sc = new ShoppingCart(new Pricer(), false);
    }

    @Test
    public void canAddAnItem() {
        sc.emptyCart();
        sc.addItem("apple", 1);

        assertEquals((long) 1, (long) sc.contents.get("apple"));
    }

    @Test
    public void canAddMoreThanOneItem() {
        sc.emptyCart();
        sc.addItem("apple", 2);

        assertEquals((long) 2, (long) sc.contents.get("apple"));
    }

    @Test
    public void canAddSameItemMoreThanOneTime() {
        sc.emptyCart();
        sc.addItem("apple", 2);
        sc.addItem("apple", 6);

        assertEquals((long) 8, (long) sc.contents.get("apple"));
    }

    @Test
    public void canAddDifferentItems() {
        sc.emptyCart();
        sc.addItem("apple", 2);
        sc.addItem("banana", 1);

        // correct item
        assertTrue(sc.contents.containsKey("apple"));
        assertTrue(sc.contents.containsKey("banana"));
        // correct quantity
        assertEquals((long) 1, (long) sc.contents.get("banana"));
        assertEquals((long) 2, (long) sc.contents.get("apple"));
        // correct price
        assertEquals(2.00, sc.getTotalItemPrice("banana"), 2);
        assertEquals(4.00, sc.getTotalItemPrice("apple"), 2);
    }

        @Test
    public void doesntExplodeOnMysteryItem() {
        sc.emptyCart();
        sc.addItem("crisps", 2);
        assertEquals((long) 2, (long) sc.contents.get("crisps"));
        assertEquals(0.00, sc.getTotalItemPrice("crisps"), 2);


    }

    @Test
    public void receiptPrintsAsExpected() {
        sc.emptyCart();
        sc.addItem("apple", 30);
        sc.addItem("banana", 20);
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));

        sc.printReceipt();
        assertEquals(String.format("      Item  Quantity     Price\n" +
                "     apple        30    €30.00\n" +
                "    banana        20    €40.00\n" +
                "------------------------------\n" +
                "               Total €70.00\n"), myOut.toString());
    }

    @Test
    public void receiptPrintsAsExpectedWithPriceFirst() {
        sc.emptyCart();
        sc.setPriceFirst(true);
        sc.addItem("apple", 30);
        sc.addItem("banana", 20);
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));

        sc.printReceipt();
        assertEquals(String.format("     Price  Quantity      Item\n" +
                "    €30.00        30     apple\n" +
                "    €40.00        20    banana\n" +
                "------------------------------\n" +
                "               Total €70.00\n"), myOut.toString());
    }

    @Test
    public void canPriceFirstBeToggledCorrectly() {
        sc.emptyCart();
        sc.setPriceFirst(true);
        sc.addItem("apple", 30);
        sc.addItem("banana", 20);
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));

        sc.printReceipt();
        assertEquals(String.format("     Price  Quantity      Item\n" +
                "    €30.00        30     apple\n" +
                "    €40.00        20    banana\n" +
                "------------------------------\n" +
                "               Total €70.00\n"), myOut.toString());
        if (sc.isPriceFirst())
            sc.setPriceFirst(false);

        myOut.reset();
        System.setOut(new PrintStream(myOut));

        sc.printReceipt();
        assertEquals(String.format("      Item  Quantity     Price\n" +
                "     apple        30    €30.00\n" +
                "    banana        20    €40.00\n" +
                "------------------------------\n" +
                "               Total €70.00\n"), myOut.toString());
    }
}