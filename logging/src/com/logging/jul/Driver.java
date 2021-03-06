package com.logging.jul;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Driver {

	public static void main(String[] args) throws SecurityException, IOException {
		
		
		ClassLoader cl = Driver.class.getClassLoader();
		InputStream configFile = cl.getResourceAsStream("logging.properties");
		LogManager.getLogManager().readConfiguration(configFile);
		Logger logger = Logger.getLogger("main.java.util");

		logger.severe("info message for logger");
		logger.warning("info message for logger");
		logger.info("info message for logger");
		logger.config("info message for logger");
		logger.fine("info message for logger");
		logger.finer("info message for logger");
		logger.finest("info message for logger");

	}

}
