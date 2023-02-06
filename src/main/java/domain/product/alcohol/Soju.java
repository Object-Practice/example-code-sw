package domain.product.alcohol;

public class Soju extends Alcohol {

    private final Integer price;
    private Integer stock;

    public Soju(Integer price, Integer stock) {
        this.price = price;
        this.stock = stock;
    }

    @Override
    public String getName() {
        return "소주";
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
