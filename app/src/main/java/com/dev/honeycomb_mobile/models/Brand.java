package com.dev.honeycomb_mobile.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Brand  implements Serializable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("formAndDosages")
    @Expose
    private List<FormAndDosage> formAndDosages = null;
    @SerializedName("mostCommonPricingKey")
    @Expose
    private String mostCommonPricingKey;
    @SerializedName("mostCommonImageUrl")
    @Expose
    private String mostCommonImageUrl;
    @SerializedName("mostCommonDefaultQty")
    @Expose
    private Integer mostCommonDefaultQty;

    /**
     * No args constructor for use in serialization
     *
     */
    public Brand() {
    }

    /**
     *
     * @param mostCommonDefaultQty
     * @param mostCommonImageUrl
     * @param name
     * @param formAndDosages
     * @param mostCommonPricingKey
     */
    public Brand(String name, List<FormAndDosage> formAndDosages, String mostCommonPricingKey, String mostCommonImageUrl, Integer mostCommonDefaultQty) {
        super();
        this.name = name;
        this.formAndDosages = formAndDosages;
        this.mostCommonPricingKey = mostCommonPricingKey;
        this.mostCommonImageUrl = mostCommonImageUrl;
        this.mostCommonDefaultQty = mostCommonDefaultQty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FormAndDosage> getFormAndDosages() {
        return formAndDosages;
    }

    public void setFormAndDosages(List<FormAndDosage> formAndDosages) {
        this.formAndDosages = formAndDosages;
    }

    public String getMostCommonPricingKey() {
        return mostCommonPricingKey;
    }

    public void setMostCommonPricingKey(String mostCommonPricingKey) {
        this.mostCommonPricingKey = mostCommonPricingKey;
    }

    public String getMostCommonImageUrl() {
        return mostCommonImageUrl;
    }

    public void setMostCommonImageUrl(String mostCommonImageUrl) {
        this.mostCommonImageUrl = mostCommonImageUrl;
    }

    public Integer getMostCommonDefaultQty() {
        return mostCommonDefaultQty;
    }

    public void setMostCommonDefaultQty(Integer mostCommonDefaultQty) {
        this.mostCommonDefaultQty = mostCommonDefaultQty;
    }
}
