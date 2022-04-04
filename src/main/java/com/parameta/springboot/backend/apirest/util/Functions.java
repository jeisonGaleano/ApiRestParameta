package com.parameta.springboot.backend.apirest.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Functions {
	

    public static boolean validateAge(final String date) {
    	if (date != null && !date.isEmpty()) {
    		
    		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    		LocalDate dateBirthday = LocalDate.parse(date, formatter);
    		Period edad = Period.between(dateBirthday, LocalDate.now());
    		if(edad.getYears() > 18) {
    			return true;
    		}
    		return false;
    	}
		return false;
    }
    	
    public static boolean validateField(final String field) {
    	if (field != null && !field.isEmpty()) {
			return true;
    	}else {
    		return false;
    	}
    }

	public static String age(String date) {
		if (date != null && !date.isEmpty()) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDate dateBirthday = LocalDate.parse(date, formatter);
			Period edad = Period.between(dateBirthday, LocalDate.now());
			String result = edad.getYears() + " Años;" + edad.getMonths() + " Meses;" + edad.getDays() + " Dias.";
			return result ;
		}
		return null;
	}

    
    
    
}
