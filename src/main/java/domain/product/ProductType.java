package domain.product;

public enum ProductType {
    NAME(0), PRICE(1), BALANCE(2);
    private final int num;

    ProductType(int num){
        this.num = num;
    }
    public int toNumber(){
        return num;
    }
}
