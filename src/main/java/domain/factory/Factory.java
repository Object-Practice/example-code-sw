package domain.factory;

import domain.customer.CustomerImpl;
import domain.product.items.Alcohol;
import domain.product.items.IceCream;
import domain.product.items.Snack;
import domain.purchase.Kiosk;
import domain.wallet.*;
import domain.wallet.idCard.IdCard;
import domain.wallet.idCard.IdCardImpl;

import java.time.LocalDate;
import java.util.List;

public class Factory {

    public static CustomerImpl createCustomer(String name, Wallet wallet){
        return new CustomerImpl(name, wallet);
    }

    public static WalletImpl createWallet(List<Payment> payments, IdCard idCard){
        return new WalletImpl(payments, idCard);
    }

    public static WalletImpl createWallet(List<Payment> payments){
        return new WalletImpl(payments, null);
    }

    public static Payment createPay(String name, PayType payType, int price){
        return new PaymentImpl(name, payType, price);
    }

    public static IdCardImpl createIdCard(LocalDate birthDate){
        return new IdCardImpl(birthDate);
    }

    public static Snack createSnack(String name, int price, int balance){
        return new Snack(name, price, balance);
    }

    public static IceCream createIceCream(String name, int price, int balance){
        return new IceCream(name, price, balance);
    }

    public static Alcohol createAlcohol(String name, int price, int balance){
        return new Alcohol(name, price, balance);
    }

    public static Kiosk createKiosk(){
        return new Kiosk();
    }
}
