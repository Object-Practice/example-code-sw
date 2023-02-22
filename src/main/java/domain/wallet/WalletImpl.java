package domain.wallet;

import domain.wallet.idCard.IdCard;

import java.util.List;

public class WalletImpl implements Wallet{

    private final List<Payment> payments;
    private final IdCard idCard;

    public WalletImpl(List<Payment> payments, IdCard idCard) {
        this.payments = payments;
        this.idCard = idCard;
    }

    @Override
    public Payment findByName(String name) {
        for (Payment p:payments)
            if(name.equals(p.getPaymentName()))
                return p;
        return null;
    }

    @Override
    public Boolean compareTo(Payment payment, int price) {
        Payment pay = findByName(payment.getPaymentName());
        return isEnoughMoney(pay, price);
    }

    @Override
    public Boolean checkIdCard() {
        return idCard != null && idCard.checkId();
    }

    private boolean isEnoughMoney(Payment payment, int price) {
        return payment.getMoney() - price >= 0;
    }
}
