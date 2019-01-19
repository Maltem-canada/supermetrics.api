package org.maltem.supermetrics.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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
	
	/**
	 * 
	 * @return
	 */
	public static String getTodayDate(ZoneId zoneId) {
		return Consts.API_SDF.format(Date.from(LocalDate.now().atStartOfDay(zoneId).toInstant()));
	}
}
