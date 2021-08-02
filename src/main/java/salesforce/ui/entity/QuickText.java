package salesforce.ui.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents Quick text entity of salesforce.
 */
public class QuickText {

    public Attributes attributes;
    @JsonProperty("Id")
    public String id;
    @JsonProperty("OwnerId")
    public String ownerId;
    @JsonProperty("IsDeleted")
    public boolean isDeleted;
    @JsonProperty("Name")
    public String name;
    @JsonProperty("CreatedDate")
    public String createdDate;
    @JsonProperty("CreatedById")
    public String createdById;
    @JsonProperty("LastModifiedDate")
    public String lastModifiedDate;
    @JsonProperty("LastModifiedById")
    public String lastModifiedById;
    @JsonProperty("SystemModstamp")
    public String systemModstamp;
    @JsonProperty("LastViewedDate")
    public String lastViewedDate;
    @JsonProperty("LastReferencedDate")
    public String lastReferencedDate;
    @JsonProperty("Message")
    public String message;
    @JsonProperty("Category")
    public String category;
    @JsonProperty("Channel")
    public String channel;
    @JsonProperty("IsInsertable")
    public Boolean isInsertable;
    @JsonProperty("SourceType")
    public String sourceType;
    @JsonProperty("Related To")
    public String relatedTo;
    @JsonProperty("Field")
    public String field;

    public String getRelatedTo() {
        return relatedTo;
    }

    public void setRelatedTo(String relatedTo) {
        this.relatedTo = relatedTo;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedById() {
        return createdById;
    }

    public void setCreatedById(String createdById) {
        this.createdById = createdById;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedById() {
        return lastModifiedById;
    }

    public void setLastModifiedById(String lastModifiedById) {
        this.lastModifiedById = lastModifiedById;
    }

    public String getSystemModstamp() {
        return systemModstamp;
    }

    public void setSystemModstamp(String systemModstamp) {
        this.systemModstamp = systemModstamp;
    }

    public String getLastViewedDate() {
        return lastViewedDate;
    }

    public void setLastViewedDate(String lastViewedDate) {
        this.lastViewedDate = lastViewedDate;
    }

    public String getLastReferencedDate() {
        return lastReferencedDate;
    }

    public void setLastReferencedDate(String lastReferencedDate) {
        this.lastReferencedDate = lastReferencedDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Boolean getInsertable() {
        return isInsertable;
    }

    public void setInsertable(Boolean insertable) {
        isInsertable = insertable;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

}
