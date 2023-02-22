package domain.wallet.idCard;

import java.time.LocalDate;

public record IdCardImpl(LocalDate birthDate) implements IdCard {

    @Override
    public Boolean checkId() {
        return isAdult();
    }

    private boolean isAdult() {
        return LocalDate.now().getYear() - birthDate.getYear() > 19;
    }
}
