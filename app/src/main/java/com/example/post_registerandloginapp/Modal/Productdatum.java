
package com.example.post_registerandloginapp.Modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Productdatum {

    @SerializedName("ID")
    @Expose
    private String id;
    @SerializedName("UID")
    @Expose
    private String uid;
    @SerializedName("PRO_NAME")
    @Expose
    private String proName;
    @SerializedName("PRO_PRICE")
    @Expose
    private String proPrice;
    @SerializedName("PRO_DES")
    @Expose
    private String proDes;
    @SerializedName("PRO_IMAGE")
    @Expose
    private String proImage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProPrice() {
        return proPrice;
    }

    public void setProPrice(String proPrice) {
        this.proPrice = proPrice;
    }

    public String getProDes() {
        return proDes;
    }

    public void setProDes(String proDes) {
        this.proDes = proDes;
    }

    public String getProImage() {
        return proImage;
    }

    public void setProImage(String proImage) {
        this.proImage = proImage;
    }

    @Override
    public String toString() {
        return "Productdatum{" +
                "id='" + id + '\'' +
                ", uid='" + uid + '\'' +
                ", proName='" + proName + '\'' +
                ", proPrice='" + proPrice + '\'' +
                ", proDes='" + proDes + '\'' +
                ", proImage='" + proImage + '\'' +
                '}';
    }
}
