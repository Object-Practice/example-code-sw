package domain.wallet;

public interface Wallet {
    Payment getPayment();
    Boolean compareTo(int price);
    Boolean checkIdCard();
}
