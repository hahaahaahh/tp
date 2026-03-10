package seedu.address.model.order;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import seedu.address.model.ModelManager;
import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;

public class UniqueOrderListTest {
    @Test
    public void addOrder_orderAdded() {
        ModelManager model = new ModelManager();
        Person person = new PersonBuilder().build();

        Order order = new Order(
                new OrderId("1"),
                person,
                new Product("Laptop"),
                new Quantity("2"),
                new Price("1500"),
                OrderStatus.PENDING,
                new OrderDate(LocalDate.parse("2026-03-10"))
        );

        model.addOrder(order);

        assertTrue(model.hasOrder(order));
    }
}
