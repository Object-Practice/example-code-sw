package domain.customer;

import domain.product.Product;
import domain.wallet.Wallet;

import java.util.Map;

public interface Customer {
    Wallet getWallet();
    void chooseItem(Product product);
    void showCart();
    String getCustomerName();
    Map<String, Integer> giveCart();
    Boolean checkBalance(int price);
}
