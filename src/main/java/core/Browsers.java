package core;

/**
 * This enum defines valid Browsers.
 */
public enum Browsers {
    CHROME("CHROME"),
    FIREFOX("FIREFOX"),
    EDGE("EDGE");

    private String responseCode;

    Browsers(String responseCode) {
        this.responseCode = responseCode;
    }

    public String value() {
        return responseCode;
    }
}