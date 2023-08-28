package com.tripathi.gst.dto;

public class GstConfigurationCreateRequest {
    private String configName;
    private boolean isMultiGstConfig;
    private String createdBy;

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public boolean isMultiGstConfig() {
        return isMultiGstConfig;
    }

    public void setMultiGstConfig(boolean multiGstConfig) {
        isMultiGstConfig = multiGstConfig;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String updatedBy) {
        this.createdBy = updatedBy;
    }
}
