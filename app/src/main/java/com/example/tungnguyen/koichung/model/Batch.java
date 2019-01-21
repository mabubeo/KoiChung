package com.example.tungnguyen.koichung.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Batch implements Serializable {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("root")
    @Expose
    private String root;
    @SerializedName("dealer")
    @Expose
    private String dealer;
    @SerializedName("buyer")
    @Expose
    private String buyer;
    @SerializedName("privateNote")
    @Expose
    private String privateNote;
    @SerializedName("note")
    @Expose
    private String note;
    @SerializedName("createDate")
    @Expose
    private String createDate;
    @SerializedName("createDateV")
    @Expose
    private String createDateV;
    @SerializedName("isActive")
    @Expose
    private Integer isActive;

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getPrivateNote() {
        return privateNote;
    }

    public void setPrivateNote(String privateNote) {
        this.privateNote = privateNote;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateDateV() {
        return createDateV;
    }

    public void setCreateDateV(String createDateV) {
        this.createDateV = createDateV;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

}
