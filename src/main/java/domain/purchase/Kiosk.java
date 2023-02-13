package domain.purchase;

import domain.InfoMessage;
import domain.customer.Customer;
import domain.wallet.PayType;
import domain.wallet.Payment;

import java.util.ArrayList;
import java.util.List;

public class Kiosk implements Purchase{

    private final List<Payment> purchaseInfo;

    public Kiosk(List<Payment> purchaseInfo) {
        this.purchaseInfo = purchaseInfo;
    }

    public Kiosk(){
        this.purchaseInfo = new ArrayList<>();
    }

    @Override
    public void purchaseAll(Customer customer) {

        int totalPrice = customer.giveCart().get("total");
        Payment userPaymentInfo = customer.getWallet().getPayment();
        if (!customer.checkBalance(totalPrice))
            System.out.println(customer.getCustomerName() +"의 "+ InfoMessage.NOT_ENOUGH_MONEY.get());
        else {
            System.out.println(customer.getCustomerName() + "의 " + InfoMessage.SUCCESS.get());
            purchaseInfo.add(new Payment(userPaymentInfo.getPayType(), totalPrice));
        }
        System.out.println("\t" + "결제금액 : " + totalPrice + "\n\t" + userPaymentInfo.toString());
    }

    @Override
    public void settlement() {
        int cardSales = 0;
        int cashSales = 0;
        for (Payment p : purchaseInfo){
            if (p.getPayType().equals(PayType.Cash))
                cashSales += p.getMoney();
            else if(p.getPayType().equals(PayType.Card))
                cardSales += p.getMoney();
        }
        System.out.println("키오스크 정산"
                + "\n\t카드 : " + cardSales
                + "\n\t현금 : " + cashSales);
    }
}
