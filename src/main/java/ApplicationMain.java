import domain.customer.Customer;
import domain.product.Product;
import domain.purchase.Purchase;

import java.time.LocalDate;
import java.util.List;

import static domain.factory.Factory.*;
import static domain.wallet.PayType.Card;
import static domain.wallet.PayType.Cash;

public class ApplicationMain {

    public static void main(String[] args) {

        Customer tk = createCustomer("태경",
                createWallet(List.of(
                    createPay("현대카드", Card, 1500),
                    createPay("신한카드", Card, 1000),
                    createPay("현금", Cash, 1000)),
                createIdCard(LocalDate.of(1997,1,1))
                ));
        Customer jc = createCustomer("재찬",
                createWallet(List.of(
                    createPay("롯데카드", Card, 1000),
                    createPay("삼성카드", Card, 1500),
                    createPay("현금", Cash, 1000)),
                createIdCard(LocalDate.of(1998,1,1))
                ));
        Customer sw = createCustomer("성원",
                createWallet(List.of(
                    createPay("우리카드", Card, 1000),
                    createPay("삼성카드", Card, 1000),
                    createPay("현금", Cash, 1000))));

        Product nanaCorn = createSnack("나나콘", 500, 3);
        Product wildBody = createIceCream("와일드바디", 300, 4);
        Product soju = createAlcohol("소주", 200, 1);

        Purchase kiosk = createKiosk();

        tk.chooseItem(List.of(nanaCorn, nanaCorn, wildBody, soju));br();
        sw.chooseItem(List.of(soju, nanaCorn));br();
        jc.chooseItem(List.of(soju, wildBody, nanaCorn));br();

        checkCustomerCart(tk, jc, sw);br();

        kiosk.purchaseAll(tk, "현대카드");
        kiosk.purchaseAll(sw, "삼성카드");
        kiosk.purchaseAll(jc, "현금");

        kiosk.settlement();
    }

    private static void checkCustomerCart(Customer tk, Customer jc, Customer sw) {
        tk.showCart();
        sw.showCart();
        jc.showCart();
    }

    public static void br(){
        System.out.println();
    }
}