package org.example.entitie.enums;

/**
 * @author José Augusto Scherer - jose.a.scherer@gmail.com
 * @file Gender
 * @since 29/09/2025 - 23:07
 * --------------------
 * Possible options for gender status
 * --------------------
 */
public enum Gender {

    MALE              ( 1, "Male" ),
    FEMALE            ( 2, "Female" ),
    NON_BINARY        ( 3, "Non-binary" ),
    TRANSGENDER       ( 4, "Transgender" ),
    OTHER             ( 5, "Other" ),
    PREFER_NOT_TO_SAY ( 6, "Prefer not to say" );

    private final Integer code;
    private final String description;

    Gender(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static Gender getGender(Integer code) {

        if (code == null) {
            return null;
        }

        for (Gender gender : Gender.values()) {
            if (gender.getCode().equals(code)) {
                return gender;
            }
        }
        throw new IllegalArgumentException( "No enum constant with code " + code );
    }
}
