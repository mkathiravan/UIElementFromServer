package net.kathir.simpledemoproject;

import com.google.gson.annotations.SerializedName;

public class UIDataModel {

    @SerializedName("uitype")
    public String uitype;

    @SerializedName("value")
    public String value;

    @SerializedName("key")
    public String key;

    @SerializedName("hint")
    public String hint;

    public String getUitype() {
        return uitype;
    }

    public void setUitype(String uitype) {
        this.uitype = uitype;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }
}
