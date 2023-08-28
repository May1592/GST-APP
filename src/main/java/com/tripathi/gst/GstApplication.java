package com.tripathi.gst;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication
public class GstApplication implements ApplicationRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(GstApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(GstApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		LOGGER.info("GST application started with args {}",args.toString());

	}

}
