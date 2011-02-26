package org.casaca.gpx4j.core.logging;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.casaca.gpx4j.core.exception.GpxFileNotFoundException;
import org.casaca.gpx4j.core.exception.GpxIOException;



public class Logger {

	private org.apache.log4j.Logger logger4j;
	
	protected Logger(String name) {
		this.logger4j = org.apache.log4j.Logger.getLogger(name);
	}
	
	@SuppressWarnings("unchecked")
	protected Logger(Class clazz){
		this.logger4j = org.apache.log4j.Logger.getLogger(clazz);
	}
	
	private static Logger logger = null;
	
	public static Logger getLogger(String name) throws GpxIOException{
		if(logger == null){
			Properties p = new Properties();
			try {
				p.load(Logger.class.getResourceAsStream("log4j.properties"));
				PropertyConfigurator.configure(p);
			} catch (IOException e) {
				throw new GpxIOException("Error loading default log properties");
			}
		}
		
		return new Logger(name);
	}
	
	public static Logger getLogger(String name, String propertiesFilePath) throws GpxFileNotFoundException, GpxIOException{
		if(logger == null){
			Properties p = new Properties();
			File file = new File(propertiesFilePath);
			if(!file.exists()) throw new GpxFileNotFoundException("Properties file \""+propertiesFilePath+"\" not exists");
			try {
				p.load(new FileInputStream(file));
				PropertyConfigurator.configure(p);
			} catch (FileNotFoundException e) {
				try {
					p.load(Logger.class.getResourceAsStream("log4j.properties"));
				} catch (IOException e1) {
					throw new GpxIOException("Fatal error loading the user-passed properties and the default properties.");
				}
				throw new GpxFileNotFoundException("Properties file \""+propertiesFilePath+"\" not exists. Using default properties\n"+e.getMessage());
			} catch (IOException e) {
				throw new GpxIOException("Error loading the properties. Using default properties.\n", e);
			}
		}
		
		return new Logger(name);
	}
	
	@SuppressWarnings("unchecked")
	public static Logger getLogger(Class clazz) throws GpxIOException{
		if(logger == null){
			Properties p = new Properties();
			try {
				p.load(Logger.class.getResourceAsStream("log4j.properties"));
				PropertyConfigurator.configure(p);
			} catch (IOException e) {
				throw new GpxIOException("Error loading default log properties");
			}
		}
		
		return new Logger(clazz);
	}
	
	@SuppressWarnings("unchecked")
	public static Logger getLogger(Class clazz, String propertiesFilePath) throws GpxIOException, GpxFileNotFoundException {
		if(logger == null){
			Properties p = new Properties();
			File file = new File(propertiesFilePath);
			if(!file.exists()) throw new GpxFileNotFoundException("Properties file \""+propertiesFilePath+"\" not exists");
			try{
				p.load(new FileInputStream(file));
				PropertyConfigurator.configure(p);
			} catch (FileNotFoundException e) {
				try {
					p.load(Logger.class.getResourceAsStream("log4j.properties"));
				} catch (IOException e1) {
					throw new GpxIOException("Fatal error loading the user-passed properties and the default properties.");
				}
				throw new GpxFileNotFoundException("Properties file \""+propertiesFilePath+"\" not exists. Using default properties\n"+e.getMessage());
			} catch (IOException e) {
				throw new GpxIOException("Error loading the properties. Using default properties.\n", e);
			}
		}
		
		return new Logger(clazz);
	}
	
	public void info(String message){
		this.logger4j.info(message);
	}
	
	public void info(String message, Throwable t){
		this.logger4j.info(message, t);
	}
	
	public void debug(String message){
		this.logger4j.debug(message);
	}
	
	public void debug(String message, Throwable t){
		this.logger4j.debug(message, t);
	}
	
	public void warn(String message){
		this.logger4j.warn(message);
	}
	
	public void warn(String message, Throwable t){
		this.logger4j.warn(message, t);
	}
	
	public void error(String message){
		this.logger4j.error(message);
	}
	
	public void error(String message, Throwable t){
		this.logger4j.error(message, t);
	}
}