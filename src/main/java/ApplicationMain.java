import domain.customer.Customer;
import domain.customer.CustomerImpl;
import domain.product.Product;
import domain.product.items.Alcohol;
import domain.product.items.Snack;
import domain.product.items.IceCream;
import domain.purchase.Kiosk;
import domain.purchase.Purchase;
import domain.wallet.*;
import domain.wallet.idCard.IdCardImpl;

import java.time.LocalDate;

public class ApplicationMain {

    public static void main(String[] args) {

        Customer tk = new CustomerImpl("태경", new WalletImpl(PayType.Cash, 1000,
                new IdCardImpl(LocalDate.of(1997,1,1))));
        Customer jc = new CustomerImpl("재찬", new WalletImpl(PayType.Card, 1000,
                new IdCardImpl(LocalDate.of(1998,1,1))));
        Customer sw = new CustomerImpl("성원", new WalletImpl(PayType.Cash, 500));

        Product nanaCorn = new Snack("나나콘", 500, 2);
        Product wildBody = new IceCream("와일드바디", 300, 2);
        Product soju = new Alcohol("소주", 200, 1);

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

        Purchase kiosk = new Kiosk();

        kiosk.purchaseAll(tk);
        kiosk.purchaseAll(sw);
        kiosk.purchaseAll(jc);
        System.out.println();

        kiosk.settlement();
    }
}