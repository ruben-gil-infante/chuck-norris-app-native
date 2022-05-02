package com.example.chuck_norris_app_native.feature.showPhrase.network.model;

import com.google.gson.annotations.SerializedName;

public class Phrase {
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("icon_url")
    private String iconUrl;
    @SerializedName("id")
    private String id;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("url")
    private String url;
    @SerializedName("value")
    private String value;

    public Phrase() {}

    public String getCreatedAt() { return createdAt; }

    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

    public String getIconUrl(String iconUrl) { return iconUrl; }

    public void setIconUrl(String iconUrl) { this.iconUrl = iconUrl; }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }

    public String getValue(){ return value; }

    public void setValue(String value){ this.value = value; }

}
