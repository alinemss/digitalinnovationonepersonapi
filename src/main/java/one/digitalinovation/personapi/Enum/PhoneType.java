package one.digitalinovation.personapi.Enum;

import lombok.AllArgsConstructor;

import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {
    HOME("Home"),
    MOBILE("Mobile"),
    COMMERCIAL("Commercial");

    PhoneType(String description) {

    }
}
