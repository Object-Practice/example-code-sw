package domain.product;

import domain.wallet.Wallet;

import java.util.List;

public interface Product {
     void moveToCart();
     List<Object> productInfo();
     Boolean significant(Wallet wallet);
}
