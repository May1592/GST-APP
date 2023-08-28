package com.tripathi.gst.constant;

public interface GstStatus {
    enum GstConfigStatus
    {
        CREATED("CONFIG_CREATED"),
        IN_PROGRESS("CONFIG_IN_PROGRESS"),
        COMPLETED("CONFIG_COMPLETED");

        private String status;
        GstConfigStatus(String status)
        {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }
    }
}
