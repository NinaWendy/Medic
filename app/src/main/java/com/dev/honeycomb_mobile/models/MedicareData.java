package com.dev.honeycomb_mobile.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MedicareData  implements Serializable {
    @SerializedName("drugSupportsMedicare")
    @Expose
    private String drugSupportsMedicare;
    @SerializedName("notes")
    @Expose
    private String notes;
    @SerializedName("deductible")
    @Expose
    private String deductible;
    @SerializedName("typical")
    @Expose
    private String typical;
    @SerializedName("donutHole")
    @Expose
    private String donutHole;
    @SerializedName("outDonutHole")
    @Expose
    private String outDonutHole;
    @SerializedName("savingTips")
    @Expose
    private String savingTips;

    /**
     * No args constructor for use in serialization
     *
     */
    public MedicareData() {
    }

    /**
     *
     * @param notes
     * @param drugSupportsMedicare
     * @param donutHole
     * @param deductible
     * @param typical
     * @param outDonutHole
     * @param savingTips
     */
    public MedicareData(String drugSupportsMedicare, String notes, String deductible, String typical, String donutHole, String outDonutHole, String savingTips) {
        super();
        this.drugSupportsMedicare = drugSupportsMedicare;
        this.notes = notes;
        this.deductible = deductible;
        this.typical = typical;
        this.donutHole = donutHole;
        this.outDonutHole = outDonutHole;
        this.savingTips = savingTips;
    }

    public String getDrugSupportsMedicare() {
        return drugSupportsMedicare;
    }

    public void setDrugSupportsMedicare(String drugSupportsMedicare) {
        this.drugSupportsMedicare = drugSupportsMedicare;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDeductible() {
        return deductible;
    }

    public void setDeductible(String deductible) {
        this.deductible = deductible;
    }

    public String getTypical() {
        return typical;
    }

    public void setTypical(String typical) {
        this.typical = typical;
    }

    public String getDonutHole() {
        return donutHole;
    }

    public void setDonutHole(String donutHole) {
        this.donutHole = donutHole;
    }

    public String getOutDonutHole() {
        return outDonutHole;
    }

    public void setOutDonutHole(String outDonutHole) {
        this.outDonutHole = outDonutHole;
    }

    public String getSavingTips() {
        return savingTips;
    }

    public void setSavingTips(String savingTips) {
        this.savingTips = savingTips;
    }

}
