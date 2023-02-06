package domain.purchase;

import domain.Customer;
import domain.product.Product;
import domain.wallet.IdCard;
import domain.wallet.PayType;

import java.util.List;

public class Kiosk {

    private Integer card = 0;
    private Integer cash = 0;

    public String order(Customer customer, Product product) {

        int price = product.getPrice();

        if (customer.checkEnoughMoney(price)) return ("잔액부족");
        else if (!product.checkStock()) return ("재고부족");

        sell(customer, product);

        return "구매 성공";
    }

    public String order(Customer customer, Product product, IdCard idCard) {

        if(idCard.checkAge())
            return order(customer, product);
        return ("구매 불가");
    }

    public void showInfo(List<Product> products) {
        for (Product p : products)
            System.out.println(p.getName()+"의 재고 : "+p.getStock() + "개");
        System.out.println("카드 매출 : " + card + " 현금 매출 : "+ cash);
    }

    public void sell(Customer customer, Product product){
        product.sell();
        if (customer.pay(product).equals(PayType.Cash))
            cash+= product.getPrice();
        else
            card+= product.getPrice();
    }
}
