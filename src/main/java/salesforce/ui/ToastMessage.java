package salesforce.ui;

/**
 * Class for return a specific message text for Toast Message.
 */
public class ToastMessage {
    private String quickTextSuccessfulCreated = "Quick Text \"%s\" was created.";

    /**
     * Obtains the text value of a popup.
     *
     * @param quickTextName the text of find.
     * @return a string with the value.
     */
    public String quickTextSuccessfulCreated(String quickTextName) {
        return String.format(quickTextSuccessfulCreated, quickTextName);
    }
}
