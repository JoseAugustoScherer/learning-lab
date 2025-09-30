package org.example.entitie.enums;

/**
 * @author José Augusto Scherer - jose.a.scherer@gmail.com
 * @file MaritalStatus
 * @since 29/09/2025 - 23:11
 * --------------------
 * Possible options for marital status
 * --------------------
 */
public enum MaritalStatus {

    SINGLE               (1, "Single"),
    MARRIED              (2, "Married"),
    DIVORCED             (3, "Divorced"),
    WIDOWED              (4, "Widowed"),
    SEPARATED            (5, "Separated"),
    DOMESTIC_PARTNERSHIP (6, "Domestic partnership"),
    PREFER_NOT_TO_SAY    (7, "Prefer not to say");

    private final Integer code;
    private final String description;

    MaritalStatus(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static MaritalStatus getMaritalStatus(Integer code) {

        if ( code == null ){
            return null;
        }

        for ( MaritalStatus maritalStatus : MaritalStatus.values() ) {
            if ( maritalStatus.getCode().equals( code ) ) {
                return maritalStatus;
            }
        }

        throw new IllegalArgumentException( "No enum constant with code " + code );
    }
}
