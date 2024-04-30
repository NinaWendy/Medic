package com.dev.honeycomb_mobile.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DrugList implements Serializable {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("drugContentAccess")
    @Expose
    private Boolean drugContentAccess;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data data;

    /**
     * No args constructor for use in serialization
     *
     */
    public DrugList() {
    }

    /**
     *
     * @param data
     * @param drugContentAccess
     * @param message
     * @param status
     */
    public DrugList(String status, Boolean drugContentAccess, String message, Data data) {
        super();
        this.status = status;
        this.drugContentAccess = drugContentAccess;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getDrugContentAccess() {
        return drugContentAccess;
    }

    public void setDrugContentAccess(Boolean drugContentAccess) {
        this.drugContentAccess = drugContentAccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
