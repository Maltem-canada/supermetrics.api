package org.maltem.supermetrics.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CsvWriter {

	/**
	 * Creates a CSV containing specified data separated by specified separator
	 * @param data data to be writen
	 * @param separator separator to be used (,  ; - / etc)
	 * @param fileName name of the file 
	 * @throws FileNotFoundException 
	 */
	public void createCsv(String data, String separator, String fileName) throws FileNotFoundException {
		//TODO Add file location 
		
		// Encode in the files which separator is used
		String separatorEncoding = String.format("SEP=%s \n", separator);
		StringBuilder sb = new StringBuilder(separatorEncoding) ; 
 	   	sb.append(data); 
 	   	
 	   	// CSV Creation
 	   	PrintWriter pw = new PrintWriter(new File(fileName));
	   	
	   	pw.write(sb.toString());
	   	pw.close();
	}
}
