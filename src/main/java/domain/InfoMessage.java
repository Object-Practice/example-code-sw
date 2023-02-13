package domain;


public enum InfoMessage {

    SUCCESS("결제가 완료 되었습니다"),
    NOT_ENOUGH_PRODUCT("재고가 부족합니다"),
    NOT_ENOUGH_MONEY("잔액이 부족합니다"),
    ID_CARD_NOT_EXIST("신분증이 필요합니다"),
    INVALID_ID_CARD("만 19세 이상이어야 합니다");

    private final String message;
    InfoMessage(String message) {
        this.message = message;
    }

    public String get(){
        return message;
    }
}
