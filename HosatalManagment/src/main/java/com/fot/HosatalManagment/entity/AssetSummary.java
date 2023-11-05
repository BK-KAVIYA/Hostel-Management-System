package com.fot.HosatalManagment.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "AssetSummary") // Replace 'your_table_name' with the actual table name
public class AssetSummary {


    @Id
    @Column(name = "RoomID") // Map to the "RoomID" column from the view
    private int roomID;

    @Column(name = "TotalAssets") // Map to the "TotalAssets" column from the view
    private long totalAssets;

    @Column(name = "BrokenAssets") // Map to the "BrokenAssets" column from the view
    private BigDecimal brokenAssets;

    @Column(name = "PercentageBroken") // Map to the "PercentageBroken" column from the view
    private BigDecimal percentageBroken;
    public AssetSummary() {
    }

    public AssetSummary(int roomID, long totalAssets, BigDecimal brokenAssets, BigDecimal percentageBroken) {
        this.roomID = roomID;
        this.totalAssets = totalAssets;
        this.brokenAssets = brokenAssets;
        this.percentageBroken = percentageBroken;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public long getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(long totalAssets) {
        this.totalAssets = totalAssets;
    }

    public BigDecimal getBrokenAssets() {
        return brokenAssets;
    }

    public void setBrokenAssets(BigDecimal brokenAssets) {
        this.brokenAssets = brokenAssets;
    }

    public BigDecimal getPercentageBroken() {
        return percentageBroken;
    }

    public void setPercentageBroken(BigDecimal percentageBroken) {
        this.percentageBroken = percentageBroken;
    }
}
