package com.tripathi.gst.dto;

import java.util.Set;
import java.util.UUID;

public class GstConfigurationUpdateRequest {
    private UUID configId;
    private String taskType;
    private String updatedBy;
    private Set<GstAssetRequest> gstAssetRequestSet;

    public UUID getConfigId() {
        return configId;
    }

    public void setConfigId(UUID configId) {
        this.configId = configId;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Set<GstAssetRequest> getAssetRequestSet() {
        return gstAssetRequestSet;
    }

    public void setAssetRequestSet(Set<GstAssetRequest> gstAssetRequestSet) {
        this.gstAssetRequestSet = gstAssetRequestSet;
    }
}
