package domain.wallet;

public class Payment {
    private final PayType payType;
    private int money;

    public Payment(PayType payType, int money) {
        this.payType = payType;
        this.money = money;
    }

    public PayType getPayType() {
        return payType;
    }

    public int getMoney() {
        return money;
    }

    public void buy(int price){
        money -= price;
    }

    public String toString(){
        return "잔액 : " + payType.toString() + " " + money + "원";
    }
}
