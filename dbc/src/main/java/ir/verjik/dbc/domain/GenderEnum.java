package ir.verjik.dbc.domain;

public enum GenderEnum {

    /**
     * MALE
     */
    MALE("MALE"),
    /**
     * FEMALE
     */
    FEMALE("FEMALE"),
    /**
     * Unknown
     */
    UNKNOWN("Unknown");

    private String meaning;

    public String getMeaning() {
        return meaning;
    }

    GenderEnum() {
    }

    GenderEnum(String meaning) {
        this.meaning = meaning;
    }
}
