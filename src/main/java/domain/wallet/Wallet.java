package domain.wallet;

public class Wallet {

    private PayType payType;
    private Integer money;
    private IdCard idCard;

    public Wallet(PayType payType, Integer money, IdCard idCard) {
        this.payType = payType;
        this.money = money;
        this.idCard = idCard;
    }

    public Wallet(PayType payType, Integer money) {
        this.payType = payType;
        this.money = money;
        this.idCard = new IdCard();
    }

    public PayType getPayType(){
        return payType;
    }

    public int getMoney(){
        return money;
    }

    public void pay(int i){
        money -= i;
    }

    public IdCard getIdCard(){
        return idCard;
    }
}
