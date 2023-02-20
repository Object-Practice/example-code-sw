import domain.customer.Customer;
import domain.product.Product;
import domain.purchase.Purchase;
import domain.wallet.PayType;

import java.time.LocalDate;

import static domain.factory.Factory.*;

public class ApplicationMain {

    public static void main(String[] args) {

        Customer tk = createCustomer("태경", createWallet(PayType.Cash, 1000,
                createIdCard(LocalDate.of(1997,1,1))));
        Customer jc = createCustomer("재찬", createWallet(PayType.Card, 1000,
                createIdCard(LocalDate.of(1998,1,1))));
        Customer sw = createCustomer("성원", createWallet(PayType.Cash, 500));

        Product nanaCorn = createSnack("나나콘", 500, 2);
        Product wildBody = createIceCream("와일드바디", 300, 2);
        Product soju = createAlcohol("소주", 200, 1);

        tk.chooseItem(nanaCorn);
        tk.chooseItem(nanaCorn);
        tk.chooseItem(wildBody);
        System.out.println();

        sw.chooseItem(soju);
        sw.chooseItem(wildBody);
        sw.chooseItem(nanaCorn);
        System.out.println();

        jc.chooseItem(soju);
        jc.chooseItem(wildBody);
        jc.chooseItem(nanaCorn);
        System.out.println();

        tk.showCart();
        sw.showCart();
        jc.showCart();
        System.out.println();

        Purchase kiosk = createKiosk();

        kiosk.purchaseAll(tk);
        kiosk.purchaseAll(sw);
        kiosk.purchaseAll(jc);
        System.out.println();

        kiosk.settlement();
    }
}