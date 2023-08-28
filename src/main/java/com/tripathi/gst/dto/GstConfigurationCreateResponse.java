package com.tripathi.gst.dto;

import java.util.UUID;

public class GstConfigurationCreateResponse {
    private UUID configId;
    private Integer configNumber;

    public UUID getConfigId() {
        return configId;
    }

    public void setConfigId(UUID configId) {
        this.configId = configId;
    }

    public Integer getConfigNumber() {
        return configNumber;
    }

    public void setConfigNumber(Integer configNumber) {
        this.configNumber = configNumber;
    }
}
