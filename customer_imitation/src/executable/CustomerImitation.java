package executable;

import entities.*;

import java.util.Optional;

public class CustomerImitation {

    public static void main(String[] args) {
        Order order = new Order(
                new Item("item1"),
                null,
                new Item("item3")
        );
        order.addItem(Optional.of(new Item("item4")));
        order.addItem(Optional.empty());

        order.printItems();
    }
}
