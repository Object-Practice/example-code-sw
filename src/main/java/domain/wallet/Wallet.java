package domain.wallet;

public interface Wallet {
    Payment findByName(String name);
    Boolean compareTo(Payment payment, int price);
    Boolean checkIdCard();
}
