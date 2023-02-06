package domain;

import domain.product.Product;
import domain.wallet.PayType;
import domain.wallet.Wallet;

public class Customer {

    private final String name;
    private Wallet wallet;
    private String product;

    public Customer(String name, Wallet wallet) {
        this.name = name;
        this.wallet = wallet;
    }

    public String getName(){
        return name;
    }

    public Wallet checkWallet(){
        return wallet;
    }

    public boolean checkEnoughMoney(Integer price) {
        return wallet.getMoney() < price;
    }

    public PayType pay(Product product) {
        checkWallet().pay(product.getPrice());
        this.product = product.getName();
        return checkWallet().getPayType();
    }

    public void showInfo() {
        System.out.println(name + "의 "
                + wallet.getPayType() + " 잔액은 "
                + wallet.getMoney() + "원 이고 "
                + product + "을(를) 구매");
    }
}
