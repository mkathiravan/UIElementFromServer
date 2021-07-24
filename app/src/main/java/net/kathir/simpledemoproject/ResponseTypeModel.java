package net.kathir.simpledemoproject;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseTypeModel {


    @SerializedName("logo-url")
    public String logo_url;

    @SerializedName("heading-text")
    public String heading_text;

    public String statusMsg;

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public List<UIDataModel> getUidata() {
        return uidata;
    }

    public void setUidata(List<UIDataModel> uidata) {
        this.uidata = uidata;
    }

    @SerializedName("uidata")
    public List<UIDataModel> uidata;

    public String getLogo_url() {
        return logo_url;
    }

    public void setLogo_url(String logo_url) {
        this.logo_url = logo_url;
    }

    public String getHeading_text() {
        return heading_text;
    }

    public void setHeading_text(String heading_text) {
        this.heading_text = heading_text;
    }



}
