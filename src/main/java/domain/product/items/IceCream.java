package domain.product.items;

import domain.product.Product;
import domain.wallet.Wallet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static domain.product.ProductType.BALANCE;

public class IceCream implements Product {

    private final List<Object> itemInfo = Collections.synchronizedList(new ArrayList<>());

    public IceCream(String name, int price, int balance){
        itemInfo.add(name);
        itemInfo.add(price);
        itemInfo.add(balance);
    }

    @Override
    public void moveToCart() {
        itemInfo.set(BALANCE.toNumber(), (int)itemInfo.get(BALANCE.toNumber()) - 1);
    }

    @Override
    public List<Object> productInfo() {
        return itemInfo;
    }

    @Override
    public Boolean significant(Wallet wallet) {
        return true;
    }
}
