package domain.customer;

import domain.InfoMessage;
import domain.product.Product;
import static domain.product.ProductType.*;
import domain.wallet.Wallet;

import java.util.HashMap;
import java.util.Map;

public class CustomerImpl implements Customer{

    private final String name;
    private final Wallet wallet;
    private final Map<String, Integer> shoppingCart;

    public CustomerImpl(String name, Wallet wallet) {
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart = new HashMap<>();
        shoppingCart.put("total", 0);
    }

    @Override
    public Wallet getWallet(){
        return wallet;
    }

    @Override
    public void chooseItem(Product item) {

        var itemInfo = item.productInfo();
        if (!item.significant(wallet))
            System.out.println(name + "이 구매 할 수 없는 품목 : " + itemInfo.get(NAME.toNumber()));
        else if ((int)itemInfo.get(BALANCE.toNumber()) < 1)
            System.out.println(itemInfo.get(NAME.toNumber()) + " " +InfoMessage.NOT_ENOUGH_PRODUCT.get());
        else {
            putCart(item);
            shoppingCart.replace("total", shoppingCart.get("total") + (int)itemInfo.get(PRICE.toNumber()));
            System.out.println(this.name + "이 카트에 담은 물건 : " + itemInfo.get(NAME.toNumber()));
        }
    }

    private void putCart(Product item) {
        String itemName = (String) item.productInfo().get(NAME.toNumber());
        if (shoppingCart.containsKey(itemName))
            shoppingCart.replace(itemName, shoppingCart.get(itemName) + 1);
        else
            shoppingCart.put(itemName, 1);
        item.moveToCart();
    }

    @Override
    public void showCart() {
        System.out.print(this.name + "의 장바구니 : ");
        for (String name : shoppingCart.keySet()){
            if (name.equals("total")) continue;
            System.out.print(name + " " + shoppingCart.get(name) + "개 ");
        }
        System.out.println();
    }

    @Override
    public String getCustomerName() {
        return name;
    }

    @Override
    public Map<String, Integer> giveCart() {
        return shoppingCart;
    }

    @Override
    public Boolean checkBalance(int price) {
        if (wallet.compareTo(price)) {
            wallet.getPayment().buy(price);
            return true;
        }
        else return false;
    }
}
