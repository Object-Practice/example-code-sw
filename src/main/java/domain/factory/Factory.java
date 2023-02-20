package domain.factory;

import domain.customer.CustomerImpl;
import domain.product.items.Alcohol;
import domain.product.items.IceCream;
import domain.product.items.Snack;
import domain.purchase.Kiosk;
import domain.wallet.PayType;
import domain.wallet.Wallet;
import domain.wallet.WalletImpl;
import domain.wallet.idCard.IdCard;
import domain.wallet.idCard.IdCardImpl;

import java.time.LocalDate;

public class Factory {

    public static CustomerImpl createCustomer(String name, Wallet wallet){
        return new CustomerImpl(name, wallet);
    }

    public static WalletImpl createWallet(PayType payType, int money, IdCard idCard){
        return new WalletImpl(payType, money, idCard);
    }

    public static WalletImpl createWallet(PayType payType, int money){
        return new WalletImpl(payType, money, null);
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
