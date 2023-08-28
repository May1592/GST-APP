package com.tripathi.gst.controller;

import com.tripathi.gst.constant.UrlConstant;
import com.tripathi.gst.dto.GstConfigurationCreateRequest;
import com.tripathi.gst.dto.GstConfigurationUpdateRequest;
import com.tripathi.gst.dto.Response;
import com.tripathi.gst.service.GstConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = UrlConstant.CONFIG_URL)
public class GstConfigurationController {
    private GstConfigurationService gstConfigurationService;
    @Autowired
    public GstConfigurationController(GstConfigurationService gstConfigurationService)
    {
        this.gstConfigurationService = gstConfigurationService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> createConfig(@RequestBody GstConfigurationCreateRequest gstConfigurationCreateRequest)
    {
        return gstConfigurationService.createConfig(gstConfigurationCreateRequest);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getConfig()
    {
        return this.gstConfigurationService.getConfig();
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> updateConfig(@RequestBody GstConfigurationUpdateRequest gstConfigurationUpdateRequest)
    {
        return this.gstConfigurationService.updateConfig(gstConfigurationUpdateRequest);
    }

}
