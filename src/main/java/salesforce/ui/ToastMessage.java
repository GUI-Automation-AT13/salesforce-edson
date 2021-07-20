package salesforce.ui;

/**
 * Class for return a specific message text for Toast Message.
 */
public class ToastMessage {
    private String quickTextSuccessfulCreated = "Quick Text \"%s\" was created.";

    public String quickTextSuccessfulCreated(String quickTextName) {
        return String.format(quickTextSuccessfulCreated, quickTextName);
    }
}
