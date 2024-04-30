package com.dev.honeycomb_mobile.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Data  implements Serializable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("indexed")
    @Expose
    private Boolean indexed;
    @SerializedName("brandOrGeneric")
    @Expose
    private String brandOrGeneric;
    @SerializedName("brand")
    @Expose
    private Brand brand;
    @SerializedName("generic")
    @Expose
    private Generic generic;
    @SerializedName("medicare")
    @Expose
    private Medicare medicare;

    /**
     * No args constructor for use in serialization
     *
     */
    public Data() {
    }

    /**
     *
     * @param indexed
     * @param brandOrGeneric
     * @param name
     * @param brand
     * @param slug
     * @param generic
     * @param medicare
     */
    public Data(String name, String slug, Boolean indexed, String brandOrGeneric, Brand brand, Generic generic, Medicare medicare) {
        super();
        this.name = name;
        this.slug = slug;
        this.indexed = indexed;
        this.brandOrGeneric = brandOrGeneric;
        this.brand = brand;
        this.generic = generic;
        this.medicare = medicare;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Boolean getIndexed() {
        return indexed;
    }

    public void setIndexed(Boolean indexed) {
        this.indexed = indexed;
    }

    public String getBrandOrGeneric() {
        return brandOrGeneric;
    }

    public void setBrandOrGeneric(String brandOrGeneric) {
        this.brandOrGeneric = brandOrGeneric;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Generic getGeneric() {
        return generic;
    }

    public void setGeneric(Generic generic) {
        this.generic = generic;
    }

    public Medicare getMedicare() {
        return medicare;
    }

    public void setMedicare(Medicare medicare) {
        this.medicare = medicare;
    }

}
