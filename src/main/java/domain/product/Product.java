package domain.product;

public interface Product {

    String getName();
    Integer getPrice();
    Integer getStock();
    Boolean checkStock();
    void sell();
}
