package model.enums;

/**
 * Created by admin on 29.04.2017.
 */
public enum ActiveRole {
    СONFIRMED,
    NOT_CONFIRMED;

    private String value;

    public static ActiveRole getEnum(String value) {
        for (ActiveRole v : values())
            if (v.getValue().equalsIgnoreCase(value)) return v;
        throw new IllegalArgumentException();
    }

    public String getValue() {
        return value;
    }
}
