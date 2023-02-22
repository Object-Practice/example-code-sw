package domain.purchase;

import domain.InfoMessage;
import domain.customer.Customer;
import domain.wallet.PayType;
import domain.wallet.Payment;

import java.util.ArrayList;
import java.util.List;

import static domain.factory.Factory.createPay;

public class Kiosk implements Purchase{

    private final List<Payment> purchaseInfo;

    public Kiosk(){
        this.purchaseInfo = new ArrayList<>();
    }

    @Override
    public void purchaseAll(Customer customer, String name) {

        int totalPrice = customer.giveCart().get("total");
        Payment userPaymentInfo = customer.getWallet().findByName(name);
        if (!customer.checkBalance(userPaymentInfo, totalPrice))
            printNotEnoughMoney(customer, userPaymentInfo.getPaymentName());
        else {
            printSuccess(customer, userPaymentInfo.getPaymentName());
            addPurchaseHistory(name, totalPrice, userPaymentInfo);
        }
        printPurchaseResult(totalPrice, userPaymentInfo);
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
        printSettlementResult(cardSales, cashSales);
    }

    private void printSettlementResult(int cardSales, int cashSales) {
        System.out.println("키오스크 정산"
                + "\n\t카드 : " + cardSales
                + "\n\t현금 : " + cashSales);
    }

    private void printPurchaseResult(int totalPrice, Payment userPaymentInfo) {
        System.out.println(userPaymentInfo.getPaymentName()+"\t" + "결제금액 : " + totalPrice + "\n\t" + userPaymentInfo.toString());
    }

    private void addPurchaseHistory(String name, int totalPrice, Payment userPaymentInfo) {
        purchaseInfo.add(createPay(name, userPaymentInfo.getPayType(), totalPrice));
    }

    private void printSuccess(Customer customer, String name) {
        System.out.println(customer.getCustomerName() + "의 " + name +" "+ InfoMessage.SUCCESS.get());
    }

    private void printNotEnoughMoney(Customer customer, String name) {
        System.out.println(customer.getCustomerName() +"의 "+ name +" "+ InfoMessage.NOT_ENOUGH_MONEY.get());
    }
}
