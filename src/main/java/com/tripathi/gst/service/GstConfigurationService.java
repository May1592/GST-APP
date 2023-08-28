package com.tripathi.gst.service;

import com.tripathi.gst.dto.*;
import com.tripathi.gst.entity.GstMapping;
import com.tripathi.gst.repository.GstConfigurationRepository;
import com.tripathi.gst.constant.GstStatus;
import com.tripathi.gst.entity.GstConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class GstConfigurationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GstConfigurationService.class);

    private GstConfigurationRepository gstConfigurationRepository;

    @Autowired
    GstConfigurationService(GstConfigurationRepository gstConfigurationRepository)
    {
        this.gstConfigurationRepository = gstConfigurationRepository;
    }

    public ResponseEntity<Response> createConfig(GstConfigurationCreateRequest gstConfigurationCreateRequest)
    {
        LOGGER.info("New Create Config Request {}", gstConfigurationCreateRequest);
        GstConfiguration gstConfiguration = this.buildConfigEntity(gstConfigurationCreateRequest);
        this.gstConfigurationRepository.saveAndFlush(gstConfiguration);
        GstConfigurationCreateResponse gstConfigurationCreateResponse = new GstConfigurationCreateResponse();
        gstConfigurationCreateResponse.setConfigId(gstConfiguration.getId());
        gstConfigurationCreateResponse.setConfigNumber(gstConfiguration.getGstConfigNumber());
        return new ResponseEntity<>(buildResponse(HttpStatus.CREATED.toString(), gstConfigurationCreateResponse), HttpStatus.CREATED);

    }

    private GstConfiguration buildConfigEntity(GstConfigurationCreateRequest gstConfigurationCreateRequest)
    {
        GstConfiguration gstConfiguration = new GstConfiguration();
        gstConfiguration.setGstConfigName(gstConfigurationCreateRequest.getConfigName());
        gstConfiguration.setGstConfigNumber(this.gstConfigurationRepository.getNextConfigNumber());
        gstConfiguration.setGstConfigStatus(GstStatus.GstConfigStatus.CREATED.getStatus());
        gstConfiguration.setMultiGstConfig(gstConfigurationCreateRequest.isMultiGstConfig());
        gstConfiguration.setCreatedBy(gstConfigurationCreateRequest.getCreatedBy());
        gstConfiguration.setCreatedOn(new Date());
        gstConfiguration.setUpdatedBy(gstConfigurationCreateRequest.getCreatedBy());
        gstConfiguration.setUpdatedOn(new Date());
        return gstConfiguration;
    }

    public ResponseEntity<Response> getConfig()
    {
        LOGGER.info("New get Config Request");
        List<GstConfigurationCreateResponse> gstConfigurationCreateResponseList = new ArrayList<>();
        List<GstConfiguration> gstConfigurationList = this.gstConfigurationRepository.findAll();
        gstConfigurationList.forEach(gstConfiguration -> {
            GstConfigurationCreateResponse gstConfigurationCreateResponse = new GstConfigurationCreateResponse();
            gstConfigurationCreateResponse.setConfigNumber(gstConfiguration.getGstConfigNumber());
            gstConfigurationCreateResponse.setConfigId(gstConfiguration.getId());
            gstConfigurationCreateResponseList.add(gstConfigurationCreateResponse);

        });

        return new ResponseEntity<>(buildResponse(HttpStatus.OK.toString(), gstConfigurationCreateResponseList),HttpStatus.OK);

    }
    @Transactional
    public ResponseEntity<Response> updateConfig(GstConfigurationUpdateRequest gstConfigurationUpdateRequest)
    {
        LOGGER.info("New Update Config Request: {} ", gstConfigurationUpdateRequest.getConfigId());
        Optional<GstConfiguration> optionalConfiguration = this.gstConfigurationRepository.findById(gstConfigurationUpdateRequest.getConfigId());
        optionalConfiguration.ifPresent(gstConfiguration -> associateAsset(gstConfiguration, gstConfigurationUpdateRequest));
        GstConfigurationUpdateResponse gstConfigurationUpdateResponse = new GstConfigurationUpdateResponse();
        gstConfigurationUpdateResponse.setConfigId(optionalConfiguration.get().getId());
        gstConfigurationUpdateResponse.setAssetMapping(gstConfigurationUpdateResponse.getAssetMapping());
        return new ResponseEntity<>(buildResponse(HttpStatus.OK.toString(), gstConfigurationUpdateResponse),HttpStatus.OK);
    }

    private void associateAsset(GstConfiguration gstConfiguration, GstConfigurationUpdateRequest gstConfigurationUpdateRequest)
    {
        Set<GstMapping> gstMappings = new HashSet<>();
        gstConfigurationUpdateRequest.getAssetRequestSet().forEach(assetRequest -> {
            GstMapping gstMapping = new GstMapping();
            gstMapping.setId(UUID.randomUUID());
            gstMapping.setAssetName(assetRequest.getName());
            gstMapping.setMappedDate(new Date());
            gstMapping.setApprovedDate(new Date());
            gstMappings.add(gstMapping);
        });
        gstConfiguration.getAssets().clear();
        gstConfiguration.getAssets().addAll(gstMappings);
        this.gstConfigurationRepository.saveAndFlush(gstConfiguration);

    }

    private Response buildResponse(String status , Object object)
    {
        Response response = new Response();
        response.setStatus(status);
        response.setObject(object);
        return response;
    }
}
