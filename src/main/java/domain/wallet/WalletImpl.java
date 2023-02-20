package domain.wallet;

import domain.wallet.idCard.IdCard;

public class WalletImpl implements Wallet{

    private final Payment payment;
    private final IdCard idCard;

    public WalletImpl(PayType payType, int money, IdCard idCard) {
        this.payment = new Payment(payType, money);
        this.idCard = idCard;
    }

    @Override
    public Payment getPayment() {
        return payment;
    }

    @Override
    public Boolean compareTo(int price) {
        return isEnoughMoney(price);
    }

    @Override
    public Boolean checkIdCard() {
        return idCard != null && idCard.checkId();
    }

    private boolean isEnoughMoney(int price) {
        return payment.getMoney() - price >= 0;
    }
}
