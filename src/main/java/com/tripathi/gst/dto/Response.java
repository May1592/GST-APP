package com.tripathi.gst.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonPOJOBuilder(withPrefix = "")
public class Response {
    @JsonProperty("Data")
    private Object object;
    private String status;

    /*public Response(Object object, String status) {
        this.object = object;
        this.status = status;
    }
    public Response()
    {

    }*/

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
