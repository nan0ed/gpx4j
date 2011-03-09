package org.casaca.gpx4j.core.driver.reader;

import java.io.File;
import java.io.InputStream;

import org.casaca.gpx4j.core.data.GpxDocument;
import org.casaca.gpx4j.core.exception.GpxFileNotFoundException;
import org.casaca.gpx4j.core.exception.GpxIOException;
import org.casaca.gpx4j.core.exception.GpxPropertiesException;
import org.casaca.gpx4j.core.exception.GpxReaderException;

public interface IGpxReader {
	public GpxDocument readGpxDocument(File input, boolean validateDocument)  throws GpxFileNotFoundException, GpxIOException, GpxReaderException;
	
	public GpxDocument readGpxDocument(File input) throws GpxFileNotFoundException, GpxIOException, GpxReaderException, GpxPropertiesException;
	
	public GpxDocument readGpxDocument(InputStream input, boolean validateDocument)  throws GpxIOException, GpxReaderException;
	
	public GpxDocument readGpxDocument(InputStream input) throws GpxIOException, GpxReaderException, GpxPropertiesException;
}