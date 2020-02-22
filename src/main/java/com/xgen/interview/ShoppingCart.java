package com.xgen.interview;


import java.lang.reflect.Array;
import java.util.*;


/**
 * This is the current implementation of ShoppingCart.
 * Please write a replacement
 */
public class ShoppingCart implements IShoppingCart {
    TreeMap<String, Integer> contents = new TreeMap<>(); // treemap to display items in order of purchase
    Pricer pricer;
    Receipt receipt;
    boolean priceFirst;

    public ShoppingCart(Pricer pricer, boolean priceFirst) {
        this.pricer = pricer;
        this.priceFirst = priceFirst;
    }

    public boolean isPriceFirst() {
        return priceFirst;
    }

    public void setPriceFirst(boolean priceFirst) {
        this.priceFirst = priceFirst;
    }

    public static void main(String[] args) {
        Pricer p = new Pricer();
        ShoppingCart cart = new ShoppingCart(p, false);
//        cart.addItem("apple", 20);
//        cart.addItem("apple", 10);
//        cart.addItem("banana", 20);
        cart.printReceipt();
    }

    /**
     * Add the item to the basket. Check to see if the item is in the basket
     * already and if so, update it's total instead.
     * @param itemType - The item being scanned by the hardware
     * @param number - The amount of the item being purchased
     */
    public void addItem(String itemType, int number) {
        if (!contents.containsKey(itemType)) {
            contents.put(itemType, number);
        } else {
            int existing = contents.get(itemType);
            contents.put(itemType, existing + number);
        }
    }

    /**
     * Reset the shopping cart to an empty state.
     */
    public void emptyCart() {
        contents = new TreeMap<>();
    }

    /**
     * Calculate the total price of an item.
     * @param item item to calculate the price of
     * @return price of item in flot format
     */
    public float getTotalItemPrice(String item) {
        Integer price = pricer.getPrice(item) * contents.get(item);
        Float priceFloat = (float) price / 100;
        return priceFloat;
    }

    /**
     * Generate a receipt of all the items in the shopping cart. Goes
     * through all the items in the basket, calculates each items total and
     * stores it in a @ReceiptItem object which is then added to the @Receipt
     * object.
     */
    private void generateReceipt() {
        receipt = new Receipt(priceFirst);
        ReceiptItem receiptItem;
        for (Map.Entry<String, Integer> purchase : contents.entrySet()) {
            String key = purchase.getKey();
            Integer value = purchase.getValue();
            Float priceFloat = getTotalItemPrice(key);
            receiptItem = new ReceiptItem(key, value, priceFloat);
            receipt.addItem(receiptItem);
        }
    }

    /**
     * Call a method to generate and then print a receipt containing all the
     * items in the shopping cart.
     */
    public void printReceipt() {
        generateReceipt();
        System.out.println(receipt.toString());
    }


}
