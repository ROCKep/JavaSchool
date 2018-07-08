package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Order {
    private final List<Item> items;

    public Order() {
        items = new ArrayList<>();
    }

    public Order(Item... items) {
        this();
        for (Item item : items) {
            addItem(Optional.ofNullable(item));
        }
    }

    public void addItem(Optional<Item> item) {
        item.ifPresent(items::add);
    }

    public void printItems() {
        for (Item item : items) {
            System.out.println(item.getName());
        }
    }
}
