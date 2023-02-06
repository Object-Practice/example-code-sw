package domain.product.iceCream;

public class WildBody extends IceCream {

    private final Integer price;
    private Integer stock;

    public WildBody(Integer price, Integer stock) {
        this.price = price;
        this.stock = stock;
    }

    @Override
    public String getName() {
        return "와일드바디";
    }

    @Override
    public Integer getPrice() {
        return price;
    }

    @Override
    public void sell() {
        --stock;
    }

    @Override
    public Integer getStock() {
        return stock;
    }

    @Override
    public Boolean checkStock() {
        return getStock() > 0;
    }
}
