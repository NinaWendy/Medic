package com.dev.honeycomb_mobile.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FormAndDosage__1 implements Serializable {
    @SerializedName("form")
    @Expose
    private String form;
    @SerializedName("pricingUrlKey")
    @Expose
    private String pricingUrlKey;
    @SerializedName("defaultQty")
    @Expose
    private Integer defaultQty;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("strength")
    @Expose
    private String strength;

    /**
     * No args constructor for use in serialization
     *
     */
    public FormAndDosage__1() {
    }

    /**
     *
     * @param form
     * @param strength
     * @param defaultQty
     * @param imageUrl
     * @param pricingUrlKey
     */
    public FormAndDosage__1(String form, String pricingUrlKey, Integer defaultQty, String imageUrl, String strength) {
        super();
        this.form = form;
        this.pricingUrlKey = pricingUrlKey;
        this.defaultQty = defaultQty;
        this.imageUrl = imageUrl;
        this.strength = strength;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getPricingUrlKey() {
        return pricingUrlKey;
    }

    public void setPricingUrlKey(String pricingUrlKey) {
        this.pricingUrlKey = pricingUrlKey;
    }

    public Integer getDefaultQty() {
        return defaultQty;
    }

    public void setDefaultQty(Integer defaultQty) {
        this.defaultQty = defaultQty;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

}
