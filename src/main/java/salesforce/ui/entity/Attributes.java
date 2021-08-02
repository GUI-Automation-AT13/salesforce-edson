package salesforce.ui.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Represents attribute entity of salesforce.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Attributes {
    private String type;
    private String url;

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }
}
