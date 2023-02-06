package domain.product.snack;

public class NanaCorn extends Snack {

    private final Integer price;
    private Integer stock;

    public NanaCorn(Integer price, Integer stock) {
        this.price = price;
        this.stock = stock;
    }

    @Override
    public String getName() {
        return "나나콘";
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
