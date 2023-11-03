package com.example.webHomeExcercise4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@SpringBootApplication
public class WebHomeExcercise4Application {

	public static void main(String[] args) {
		SpringApplication.run(WebHomeExcercise4Application.class, args);
	}


	public static java.sql.Date generateDate(String dateString) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date utilDate = null;
		java.sql.Date sqlDate = null;

		try {
			utilDate = dateFormat.parse(dateString);
			sqlDate = new java.sql.Date(utilDate.getTime());
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		return sqlDate;
	}
}
