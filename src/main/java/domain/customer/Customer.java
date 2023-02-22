package domain.customer;

import domain.product.Product;
import domain.wallet.Payment;
import domain.wallet.Wallet;

import java.util.List;
import java.util.Map;

public interface Customer {
    Wallet getWallet();
    void chooseItem(List<Product> products);
    void showCart();
    String getCustomerName();
    Map<String, Integer> giveCart();
    Boolean checkBalance(Payment payment, int price);
}
