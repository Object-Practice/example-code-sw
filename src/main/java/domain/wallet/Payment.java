package domain.wallet;

public interface Payment {

    PayType getPayType();
    String getPaymentName();
    int getMoney();
    void buy(int price);
    String toString();
}
