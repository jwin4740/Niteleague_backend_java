package com.winkle.Niteleague;




import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class NiteleagueApplicationTests {


	public static void main(String[] args) {
		System.out.println(makeEmail("James Winkle"));
		System.out.println(generateDOB());
	}

	private static String generateDOB(){
		GregorianCalendar gc = new GregorianCalendar();
		int year = randBetween(1955, 2008);
		gc.set(gc.YEAR, year);
		int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
		gc.set(gc.DAY_OF_YEAR, dayOfYear);
		String month = String.valueOf(gc.get(gc.MONTH) + 1);
		String day = String.valueOf(gc.get(gc.DAY_OF_MONTH));
		if (gc.get(gc.DAY_OF_MONTH) < 10){
			day = "0" + String.valueOf(gc.get(gc.DAY_OF_MONTH));
		}
		if (gc.get(gc.MONTH) + 1 < 10){
			month = "0" + String.valueOf(gc.get(gc.MONTH) + 1);
		}
		return month + "/" + day + "/" + gc.get(gc.YEAR);
	}
	private static int randBetween(int start, int end) {
		return start + (int)Math.round(Math.random() * (end - start));
	}


	private static String makeEmail(String name){
		String[] arr = {"@gmail.com", "@yahoo.com", "@hotmail.com"};
		Random r = new Random();
		return name + arr[r.nextInt(3)];

	}




}
