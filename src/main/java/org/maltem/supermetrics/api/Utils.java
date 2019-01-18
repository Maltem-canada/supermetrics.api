package org.maltem.supermetrics.api;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public final class Utils {
	
	/**
	 * Takes an inputStream data and returns it as a String
	 * @param input InputStream
	 * @return String
	 */
	public static String inputStreamToString(InputStream input) {
		return new BufferedReader(new InputStreamReader(input))
		   .lines().collect(Collectors.joining("\n"));
	}
}
