package com.tripathi.gst.dto;

import com.tripathi.gst.entity.GstMapping;

import java.util.Set;
import java.util.UUID;

public class GstConfigurationUpdateResponse {
    private UUID configId;
    private Set<GstMapping> gstMappingMapping;

    public UUID getConfigId() {
        return configId;
    }

    public void setConfigId(UUID configId) {
        this.configId = configId;
    }

    public Set<GstMapping> getAssetMapping() {

        return gstMappingMapping;
    }

    public void setAssetMapping(Set<GstMapping> gstMappingMapping) {
        this.gstMappingMapping = gstMappingMapping;
    }
}
