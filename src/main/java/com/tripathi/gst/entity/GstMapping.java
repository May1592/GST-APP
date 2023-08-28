package com.tripathi.gst.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="GST_MAPPING")
@JsonIgnoreProperties(ignoreUnknown = true)
public class GstMapping {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "GST_MAPPING_ID")
    private UUID id;
    @Column(name = "GST_DEFINITION")
    private String assetName;
    @Column(name = "MAPPED_DATE")
    private Date mappedDate;
    @Column(name = "APPROVED_DATE")
    private Date approvedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONFIG_ID")
    private GstConfiguration gstConfiguration;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public GstConfiguration getConfiguration() {
        return gstConfiguration;
    }

    public void setConfiguration(GstConfiguration gstConfiguration) {
        this.gstConfiguration = gstConfiguration;
    }

    public Date getMappedDate() {
        return mappedDate;
    }

    public void setMappedDate(Date mappedDate) {
        this.mappedDate = mappedDate;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }
}
