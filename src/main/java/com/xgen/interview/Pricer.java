package com.xgen.interview;

import java.util.HashMap;


/**
 * A stub implementation - for this exercise, you may disregard that this is incomplete.
 */
public class Pricer {
    HashMap<String, Integer> pricingDatabase = new HashMap<>(); // stub

    public Pricer() {
        pricingDatabase.put("apple", 100);
        pricingDatabase.put("banana", 200);
        pricingDatabase.put("cake", 200);
    }

    /**
     * Returns the price of the item passed, in Euro-cent. Eg. if an item costs €1, this will return 100
     * If itemType is an unknown string, store policy is that the item is free.
     * @param itemType item to get price of
     * @return items price in Euro-cent
     */
    public Integer getPrice(String itemType) {
        if (!pricingDatabase.containsKey(itemType)) {
            return 0;
        }
        return pricingDatabase.get(itemType);
    }

}
