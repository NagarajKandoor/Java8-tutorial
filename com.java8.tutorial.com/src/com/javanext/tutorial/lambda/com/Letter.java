package com.javanext.tutorial.lambda.com;

/**
 * @author Nagaraj
 *
 */
public class Letter {

	public static String addHeader(String text) {
		return "From Nagaraj: " + text;
	}

	public static String addFooter(String text) {
		return text + " Kind regards";
	}

	public static String checkSpelling(String text) {
		return text.replaceAll("Nagaraj", "Nagaraj Kandoor");
	}
}
