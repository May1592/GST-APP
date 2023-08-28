package com.tripathi.gst.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="GST_CONFIGURATION")
@JsonIgnoreProperties(ignoreUnknown = true)
public class GstConfiguration {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "GST_CONFIG_ID")
    private UUID id;
    @Column(name = "GST_CONFIGURATION_NUMBER")
    private Integer gstConfigNumber;
    @Column(name = "GST_CONFIG_NAME")
    private String gstConfigName;
    @Column(name = "GST_CONFIG_STATUS")
    private String gstConfigStatus;
    @Column(name = "IS_MULTI_GST_CONFIG")
    private boolean isMultiGstConfig;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "CREATED_ON")
    private Date createdOn;
    @Column(name = "UPDATED_BY")
    private String updatedBy;
    @Column(name = "UPDATED_ON")
    private Date updatedOn;

    // Asset Mapping
    @OneToMany(mappedBy = "configuration",fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    Set<GstMapping> gstMappings;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getGstConfigNumber() {
        return gstConfigNumber;
    }

    public void setGstConfigNumber(Integer gstConfigNumber) {
        this.gstConfigNumber = gstConfigNumber;
    }

    public String getGstConfigName() {
        return gstConfigName;
    }

    public void setGstConfigName(String gstConfigName) {
        this.gstConfigName = gstConfigName;
    }

    public String getGstConfigStatus() {
        return gstConfigStatus;
    }

    public void setGstConfigStatus(String gstConfigStatus) {
        this.gstConfigStatus = gstConfigStatus;
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

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Set<GstMapping> getAssets() {
        return gstMappings;
    }

    public void setAssets(Set<GstMapping> gstMappings) {
        this.gstMappings = gstMappings;
    }
}
