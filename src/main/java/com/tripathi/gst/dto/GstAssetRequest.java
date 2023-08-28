package com.tripathi.gst.dto;

import java.util.UUID;

public class GstAssetRequest {
    private String name;
    private UUID assetId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getAssetId() {
        return assetId;
    }

    public void setAssetId(UUID assetId) {
        this.assetId = assetId;
    }
}
