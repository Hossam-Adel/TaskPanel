package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateConvertor {
	/**
	 * this method converts unix date format to date format dd-mm-yyy
	 * @author Hossam
	 *this method gets parameter long and returns String
	 */
   public static String convertunix(long unixdate){
	   
	   
	   Date date = new Date(unixdate*1000L);
	  // System.out.println("UNIXdate is>> "+unixdate+" Date >> "+date.toString());
	   SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy"); // the format of your date
	   String formattedDate = sdf.format(date);
	   return formattedDate;
   }
  
}
