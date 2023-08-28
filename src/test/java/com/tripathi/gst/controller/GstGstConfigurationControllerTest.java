package com.tripathi.gst.controller;


import com.tripathi.gst.constant.UrlConstant;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class GstGstConfigurationControllerTest {
    @Autowired
    private MockMvc mockMvc;


    @Test
    void createConfig() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("configName","TestConfig1");
        jsonObject.put("isMultiAssetConfig",true);
        jsonObject.put("createdBy","MTUser");
        mockMvc.perform(MockMvcRequestBuilders.post(UrlConstant.CONFIG_URL).content(jsonObject.toString()).
                contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).
                andExpect(MockMvcResultMatchers.jsonPath("$.Data.configId").exists());
    }

    @Test
    void getConfig() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(UrlConstant.CONFIG_URL).contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }
}