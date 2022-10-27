package vendorMachine.machine.row;

import java.util.ArrayDeque;
import java.util.Queue;

public class Row {
    private Queue<Product> products;
    private String name;
    private int price;
    private int capacity;
    private Product storedProduct;

    public Row(String name, int price, Product product, int capacity) {
        this.storedProduct = product;
        this.name = name;
        this.price = price;
        this.capacity = capacity;
        this.products = new ArrayDeque<>();
        for (int i = 0; i < capacity; i++) {
            products.add(product);
        }
    }

    public void fillRow() {
        final int size = capacity - products.size();
        for (int i = 0; i < size; i++) {
            products.add(storedProduct);
        }
    }

    public Product next() {
        return products.isEmpty() ? null :products.poll();
    }

    public void setProducts(Queue<Product> products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price > 0)
            this.price = price;
    }

    public int getRestProducts() {
        return products.size();
    }

    @Override
    public String toString() {
        return "{row=" + name +
                "; product=" + storedProduct.getName() +
                "; price=" + price +
                "; amount=" + getRestProducts() + "}";
    }
}

