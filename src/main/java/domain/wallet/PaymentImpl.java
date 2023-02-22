package domain.wallet;

public class PaymentImpl implements Payment{
    private final String paymentName;
    private final PayType payType;
    private int money;

    public PaymentImpl(String paymentName, PayType payType, int money) {
        this.paymentName = paymentName;
        this.payType = payType;
        this.money = money;
    }

    @Override
    public PayType getPayType() {
        return payType;
    }

    @Override
    public String getPaymentName(){
        return paymentName;
    }
    @Override
    public int getMoney() {
        return money;
    }
    @Override
    public void buy(int price){
        money -= price;
    }
    @Override
    public String toString(){
        return balanceString();
    }

    private String balanceString() {
        return "잔액 : " + payType.toString() + " " + money + "원";
    }
}
