package com.ml.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateConverter {

  /**
   * Example formats: 
   * 
   * dd.MM.yyyy <br>
   * yyyy-MM-dd HH:mm:ss <br>
   * HH:mm:ss <br>
   * dd <br>
   * 
   * @param format
   * @param date
   * @return
   */
  public static String convertDateToFormatSting(String format, Date date){
    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(format);
    DATE_FORMAT.setLenient(false);
    String dateAsString;

    synchronized(DATE_FORMAT){
      dateAsString = DATE_FORMAT.format(date);
    }
    return dateAsString;
  }
  
  public static Date produceDateFromFormat(String format, String value){
    
    Date date = null;
    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(format);
    DATE_FORMAT.setLenient(true);
    try{
      date = DATE_FORMAT.parse(value);
    }
    catch(Exception e){
      e.printStackTrace();
    }
    
    return date;
  }

  public static Date getStartDateOfDay(Date dayInBetween){
    
    Date date = null;
    
    String valueBeginningOfDay  = DateConverter.convertDateToFormatSting("dd.MM.yyyy", dayInBetween);
    date  = DateConverter.produceDateFromFormat("dd.MM.yyyy", valueBeginningOfDay);
    
    return date;
  }
  

  public static int convertDateToFormatInt(String format, Date date){

    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(format);
    DATE_FORMAT.setLenient(false);
    int dateAsint;
    
    synchronized(DATE_FORMAT){
      dateAsint = Integer.parseInt(DATE_FORMAT.format(date));
    }
    return dateAsint;
  }
  
  public static Date convertDateToString(String dateString){
    
    Date date = null;
    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    DATE_FORMAT.setLenient(true);
    try{
      date = DATE_FORMAT.parse(dateString);
    }
    catch(Exception e){
      e.printStackTrace();
    }
    
    return date;
  }

  
  public static String deliverAsStringDate(Date date){
    
    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
    DATE_FORMAT.setLenient(false);
    String dateAsString;

    synchronized(DATE_FORMAT){
      dateAsString = DATE_FORMAT.format(date);
    }
    return dateAsString;
  }
  
  public static String deliverAsStringDateyyyymmddHHmmss(Date date){
    
    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    DATE_FORMAT.setLenient(false);
    String dateAsString;

    synchronized(DATE_FORMAT){
      dateAsString = DATE_FORMAT.format(date);
    }
    return dateAsString;
  }

  public static String deliverAsStringDateyyyymmdd(Date date){
    
    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    DATE_FORMAT.setLenient(false);
    String dateAsString;

    synchronized(DATE_FORMAT){
      dateAsString = DATE_FORMAT.format(date);
    }
    return dateAsString;
  }

  public static String deliverAsStringDatehhmmss(Date date){
    
    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");
    DATE_FORMAT.setLenient(false);
    String dateAsString;

    synchronized(DATE_FORMAT){
      dateAsString = DATE_FORMAT.format(date);
    }
    return dateAsString;
  }

  public static String deliverAsStringDay(Date date){

    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd");
    DATE_FORMAT.setLenient(false);
    String dateAsString;
    
    synchronized(DATE_FORMAT){
      dateAsString = DATE_FORMAT.format(date);
    }
    return dateAsString;
  }
  
  public static String deliverAsStringHour(Date date){

    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("hh");
    DATE_FORMAT.setLenient(false);
    String dateAsString;
    
    synchronized(DATE_FORMAT){
      dateAsString = DATE_FORMAT.format(date);
    }
    return dateAsString;
  }

  public static String deliverAsStringMinute(Date date){

    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("mm");
    DATE_FORMAT.setLenient(false);
    String dateAsString;
    
    synchronized(DATE_FORMAT){
      dateAsString = DATE_FORMAT.format(date);
    }
    return dateAsString;
  }
  
  public static String deliverAsStringSecond(Date date){

    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("ss");
    DATE_FORMAT.setLenient(false);
    String dateAsString;
    
    synchronized(DATE_FORMAT){
      dateAsString = DATE_FORMAT.format(date);
    }
    return dateAsString;
  }

  public static int deliverAsIntDay(Date date){

    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd");
    DATE_FORMAT.setLenient(false);
    int dateAsint;
    
    synchronized(DATE_FORMAT){
      dateAsint = Integer.parseInt(DATE_FORMAT.format(date));
    }
    return dateAsint;
  }
  
  public static int deliverAsIntHour(Date date){

    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH");
    DATE_FORMAT.setLenient(false);
    int dateAsint;
    
    synchronized(DATE_FORMAT){
      dateAsint = Integer.parseInt(DATE_FORMAT.format(date));
    }
    return dateAsint;
  }

  public static int deliverAsIntMinute(Date date){

    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("mm");
    DATE_FORMAT.setLenient(false);
    int dateAsint;
    
    synchronized(DATE_FORMAT){
      dateAsint = Integer.parseInt(DATE_FORMAT.format(date));
    }
    return dateAsint;
  }

  public static int deliverAsIntSecond(Date date){

    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("ss");
    DATE_FORMAT.setLenient(false);
    int dateAsint;
    
    synchronized(DATE_FORMAT){
      dateAsint = Integer.parseInt(DATE_FORMAT.format(date));
    }
    return dateAsint;
  }
  
  public static Date calculateDateFromString(String day){
    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
    DATE_FORMAT.setLenient(false);
    Date result = null;
    
    synchronized(DATE_FORMAT){
      try {
        result = (DATE_FORMAT.parse(day));
      } catch (ParseException e) {
        e.printStackTrace();
      }
    }
    return result;
  }
  
  public static Date calculateDateFromStringHHddMMyyyy(String day){
    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH.dd.MM.yyyy");
    DATE_FORMAT.setLenient(false);
    Date result = null;
    
    synchronized(DATE_FORMAT){
      try {
        result = (DATE_FORMAT.parse(day));
      } catch (ParseException e) {
        e.printStackTrace();
      }
    }
    return result;
  }
  
  /**
   * Simple Date Format from java.text package.
   * "E yyyy.MM.dd 'at' hh:mm:ss a zzz"
   */
  public static String doSimpleDateFormat(String format, Calendar c) {
      SimpleDateFormat formatter = new SimpleDateFormat(format);
      return formatter.format(c.getTime());
  }

  /**
   * Date Arithmetic function. Adds the specified (signed) amount of time to 
   * the given time field, based on the calendar's rules.
   * The following examle:
   *   - Subtracts 2 years from the current time of the calendar
   *   - Adds 5 days from the current time of the calendar
   */
  public static Calendar doAdd(int days) {

      Calendar now = Calendar.getInstance();
      Calendar working;
      SimpleDateFormat formatter = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");

      working = (Calendar) now.clone();
      working.add(Calendar.DAY_OF_YEAR, + (days));
      
      return working;

  }

  public static long doDateDifferenceDays(Calendar startDate, Calendar endDate) {
  
      Date startDate1 = startDate.getTime();
      Date endDate1   = endDate.getTime();

      long diff = endDate1.getTime() - startDate1.getTime();

      return (diff / (1000L*60L*60L*24L));

  }
  
  public static int getYear(Calendar c){
    return c.get(Calendar.YEAR);
  }

  public static int getMonth(Calendar c){
    return c.get(Calendar.MONTH);
  }
  public static int getDayOfMonth(Calendar c){
    return c.get(Calendar.DAY_OF_MONTH);
  }
  public static int getDayOfWeek(Calendar c){
    return c.get(Calendar.DAY_OF_MONTH);
  }
  public static int getDayOFYear(Calendar c){
    return c.get(Calendar.DAY_OF_YEAR);
  }
  public static int getWeekOfYear(Calendar c){
    return c.get(Calendar.WEEK_OF_YEAR);
  }
  public static int getWeekOfMonth(Calendar c){
    return c.get(Calendar.WEEK_OF_MONTH);
  }
  public static int getHour(Calendar c){
    return c.get(Calendar.HOUR);
  }
  public static int getMinute(Calendar c){
    return c.get(Calendar.MINUTE);
  }
  public static int getSecond(Calendar c){
    return c.get(Calendar.SECOND);
  }

  public static void main(String args[]){
    System.out.println("date: " + deliverAsStringDatehhmmss(new Date()));
  }

}
