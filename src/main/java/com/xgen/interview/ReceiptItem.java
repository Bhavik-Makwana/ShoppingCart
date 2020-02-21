package com.xgen.interview;

public class ReceiptItem {
    private String item;
    private Integer quantity;
    private Float price;

    public ReceiptItem(String item, Integer quantity, Float price) {
        this.item = item;
        this.quantity = quantity;
        this.price = price;
    }

    public String getItem() {
        return item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Float getPrice() {
        return price;
    }



}
