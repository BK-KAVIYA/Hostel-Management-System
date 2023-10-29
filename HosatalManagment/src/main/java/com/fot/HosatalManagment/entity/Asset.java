package com.fot.HosatalManagment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Asset {
    @Id
    private String asset_id;
    private String type;
    private String status;
    private String category;
    private int target_id;

    public Asset() {
    }

    public Asset(String type, String status, String category, int target_id) {
        this.type = type;
        this.status = status;
        this.category = category;
        this.target_id = target_id;
    }

    public Asset(String asset_id, String type, String status, String category, int target_id) {
        this.asset_id = asset_id;
        this.type = type;
        this.status = status;
        this.category = category;
        this.target_id = target_id;
    }

    public String getAsset_id() {
        return asset_id;
    }

    public void setAsset_id(String asset_id) {
        this.asset_id = asset_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getTarget_id() {
        return target_id;
    }

    public void setTarget_id(int target_id) {
        this.target_id = target_id;
    }
}
