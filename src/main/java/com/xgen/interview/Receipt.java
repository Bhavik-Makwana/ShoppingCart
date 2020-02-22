package com.xgen.interview;



import java.util.ArrayList;
import java.util.Collections;

public class Receipt {
    ArrayList<ReceiptItem> items = new ArrayList<>();
    boolean priceFirst;
    int columnWidth;
    int columns;

    public Receipt(boolean priceFirst) {
        this.priceFirst = priceFirst;
        this.columnWidth = 10;
        this.columns = 3;
    }

    /**
     * Add an item to the arraylist containg ReceiptItem objects.
     * @param receiptItem object containing all properties associated with an
     *                    item on a receipt.
     */
    public void addItem(ReceiptItem receiptItem) {
        items.add(receiptItem);
    }

    /**
     * Calculate total cost of all items in the receipt.
     * @return total cost
     */
    public float getReceiptTotal() {
        return (float) items.stream().mapToDouble(i -> i.getPrice()).sum();
    }

    /**
     * override toString superclass to output receipt in desired format.
     * @return string version of receipt
     */
    public String toString() {
        float total = getReceiptTotal();
        String out = "";
        if (priceFirst)
            out += String.format("%3$" + columnWidth + "s%2$" + columnWidth + "s%1$" + columnWidth + "s\n", "Item", "Quantity", "Price");

        else
            out += String.format("%1$" + columnWidth + "s%2$" + columnWidth + "s%3$" + columnWidth + "s\n", "Item", "Quantity", "Price");

        for (ReceiptItem item : items) {
            String priceString = String.format("€%.2f", item.getPrice());
            if (priceFirst) {
                out += String.format("%3$" + columnWidth + "s%2$" + columnWidth + "d%1$" + columnWidth + "s\n",
                        item.getItem(),
                        item.getQuantity(),
                        priceString);
            } else {
                out += String.format("%1$" + columnWidth + "s%2$" + columnWidth + "d%3$" + columnWidth + "s\n",
                        item.getItem(),
                        item.getQuantity(),
                        priceString);
            }
        }
        String separator = String.join("", Collections.nCopies(columnWidth*columns,"-"));
        out += String.format("%s\n", separator);
        out += String.format("%"+ columnWidth*(columns-1) +"s €%.2f", "Total", total);
        return out;
    }
}
