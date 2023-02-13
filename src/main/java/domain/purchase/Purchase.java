package domain.purchase;

import domain.customer.Customer;

public interface Purchase {
    void purchaseAll(Customer customer);
    void settlement();
}
