package com.logging.slf4j;


import java.io.IOException;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Driver {

	public static void main(String[] args) throws SecurityException, IOException {

		
		final Logger logger = LoggerFactory.getLogger(com.logging.slf4j.Driver.class);
		logger.error("SLF4J: Error Message");
		logger.info("SLF4J: info message");
		logger.warn("SLF4J: warning message");
		logger.debug("SLF4J: Debug Message");
		logger.trace("SLF4J: Trace");

		
	}

}
