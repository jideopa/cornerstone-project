package pojos;

import lombok.Getter;

@Getter
public class CreditCard {
    private String creditCardNumber;
    private String NameOnCard;
    private String expiration;

    private String cvv;

    public CreditCard() {
        this.creditCardNumber = "4111 1111 1111 1111";
        NameOnCard = "Jide test";
        this.expiration = "10/25";
        this.cvv = "350";
    }
}
