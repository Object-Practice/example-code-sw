import domain.Customer;
import domain.product.Product;
import domain.purchase.Kiosk;
import domain.wallet.IdCard;
import domain.wallet.PayType;
import domain.wallet.Wallet;
import domain.product.alcohol.Alcohol;
import domain.product.iceCream.IceCream;
import domain.product.snack.Snack;
import domain.product.alcohol.Soju;
import domain.product.iceCream.WildBody;
import domain.product.snack.NanaCorn;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ApplicationMain {

    public static void main(String[] args) {
        IceCream iceCream = new WildBody(300, 1);
        Snack snack = new NanaCorn(500, 1);
        Alcohol alcohol = new Soju(200, 1);

        Customer tk = new Customer("태경", new Wallet(PayType.Cash, 500, new IdCard(LocalDate.of(1997,1,1))));
        Customer jc = new Customer("재찬", new Wallet(PayType.Card, 1000, new IdCard(LocalDate.of(1998,1,1))));
        Customer sw = new Customer("성원", new Wallet(PayType.Cash, 500));

        Kiosk kiosk = new Kiosk();

        System.out.println("TK는 과자를 구매한다 : " + kiosk.order(tk, snack));
        System.out.println("TK는 아이스크림을 구매한다 : " + kiosk.order(tk, iceCream) + ", expected : 실패");
        indent();

        System.out.println("SW는 술을 구매한다 : " + kiosk.order(sw, alcohol, requestIdCard(sw)) + ", expected : 실패");
        System.out.println("SW는 아이스크림을 구매한다 : " + kiosk.order(sw, iceCream));
        System.out.println("SW는 과자를 구매한다 : " + kiosk.order(sw, snack) + ", expected : 실패");
        indent();

        System.out.println("JC는 술을 구매한다 : " + kiosk.order(jc, alcohol, requestIdCard(jc)));
        System.out.println("JC는 아이스크림을 구매한다 : " + kiosk.order(jc, iceCream) + ", expected : 실패");
        System.out.println("JC는 과자를 구매한다 : " + kiosk.order(jc, snack) + ", expected : 실패");
        indent();

        List<Product> products = new ArrayList<>();
        products.add(iceCream);
        products.add(snack);
        products.add(alcohol);


        kiosk.showInfo(products);indent();
        tk.showInfo();
        jc.showInfo();
        sw.showInfo();
    }

    public static IdCard requestIdCard(Customer customer){
        return customer.checkWallet().getIdCard();
    }

    public static void indent(){
        System.out.println();
    }
}