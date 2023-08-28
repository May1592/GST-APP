package com.tripathi.gst.controller;

import com.tripathi.gst.dto.TestDto;
import com.tripathi.gst.exception.UserException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/")
    public ResponseEntity<TestDto> test() throws UserException
    {
        TestDto testDto = new TestDto();
        throw new UserException("rod-7001","record not found");
        //return ResponseEntity.of(null);
    }






    }


