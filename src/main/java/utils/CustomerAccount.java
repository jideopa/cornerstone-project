package utils;

import lombok.Getter;

@Getter
public enum CustomerAccount {
    EXISTING_Customer("jide.test@gmail.com","rkzKaA3JAG3iyjP");

    private String emailAddress;
    private String password;

    CustomerAccount(String emailAddress, String password) {
        this.emailAddress = emailAddress;
        this.password = password;
    }
}
