package com.tripathi.gst.repository;

import com.tripathi.gst.entity.GstConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GstConfigurationRepository extends JpaRepository<GstConfiguration, UUID> {
    @Query(value = "select nextval('{h-schema}SEQ_GST_CONFIG_NUMBER')", nativeQuery = true)
    Integer getNextConfigNumber();
}
