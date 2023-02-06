package domain.wallet;

import java.time.LocalDate;

public class IdCard {
    private LocalDate birth;

    public IdCard(LocalDate localDate){
        this.birth = localDate;
    }

    public IdCard(){
        this.birth = LocalDate.now();
    }

    public Boolean checkAge(){
        return (LocalDate.now().getYear() - birth.getYear() + 1) > 20;
    }
}
