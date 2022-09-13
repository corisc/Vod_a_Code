package com.ml.utils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.is_teledata.mdg.push.PushCallback;
import com.is_teledata.mdg.push.PushObject;
import com.is_teledata.mdg.push.PushSession;
import com.is_teledata.mdg.push.SessionState;
import com.is_teledata.mdg.push.StateCallback;
import com.is_teledata.mdg.push.Subscription;

public class Dax implements PushCallback, StateCallback{
  

  private static int    pushCount  = 0;
  private double        daxKurs    = 0;
  private Kurs          kurs;
  public Kurs getKurs() {
    return kurs;
  }

  private PushSession   pushSession;
  private Helfer        helfer      = new Helfer();
  private String        onvista     = "";
  
  
  public Dax(){
    this(null, 0);
  }
  
  public Dax(String proxyHost, int proxyPort){
//    if(proxyHost != null){
//      System.setProperty( "http.proxyHost", proxyHost );
//      System.setProperty( "http.proxyPort", ""+proxyPort );
//      System.setProperty( "https.proxyHost", proxyHost );
//      System.setProperty( "https.proxyPort", ""+proxyPort );
//    }
//    // this.onvista = this.getMIS().trim(); lokal
//    this.onvista = BasicEnvConfiguration.DECIDE_MIS_VIA_WEB_OR_MASTER();
//    if(this.onvista.equals("nix")){
//      System.out.println("Passwort fuer die online Dax Kursversorgung konnte nicht geholt werden. Dies geht nur waehrend der Uebung.");
//      System.out.println("Die Kurse werden simuliert. Sie koennen normal weiterarbeitet, Der kurs ist 7000 und steigt pro Anfrage um einen Punkt.");
    this.onvista = "nix";  
    this.daxKurs = 9055;
      return;
//    }
//    
//    try
//    {
//
//      Setup.setStackTraceLevel( Level.ERROR);
//      Logger.getRoot().setLevel( Level.ERROR );
//      String logFile = "MDG_";
//      RollingFileAppender mdgFileAppender = new RollingFileAppender( logFile, RollingFileAppender.COUNTVAR_TWODIGIT, ".log", RollingFileAppender.CONDITION_CLOCKTIME );
//      Logger.getRoot().setAppender( mdgFileAppender );
//      
//      PushConfig pushConfig = PushConfig.getPushConfig();
//      this.pushSession = PushSession.getPushInstance( pushConfig, "10413", "id10413", this.onvista );
//      //System.out.println( "Method PushSession.getPushInstance() completed successfully." );
//
//      Subscription sub1 = new Subscription( "prices/quote?CODE_MARKET=_GER&ID_CURRENCY=EUR&ID_QUALITY_PRICE=4&ID_SELECTOR_NOTATION=1&ISIN=DE0008469008&VERSION=2", this);
//      //Subscription sub1 = new Subscription( "prices/quote?CODE_MARKET=_GER&ID_CURRENCY=EUR&ID_QUALITY_PRICE=4&ID_SELECTOR_NOTATION=1&ISIN=DE0001717049&VERSION=2", this);
//
//      pushSession.subscribe( sub1 );
//
//   }
//    catch ( Exception e )
//    {
//      e.printStackTrace();
//    }

  }

  public void close(){
    pushSession.close( true );
  }
  
  public double getQuoteDax() {
    this.helfer.warteMillis(500);
    if(onvista.equals("nix")){
      this.daxKurs = this.daxKurs + (double) (Math.random() * 2) - (double) (Math.random() * 2);
      BigDecimal myDec = new BigDecimal( this.daxKurs );
      myDec = myDec.setScale( 2, BigDecimal.ROUND_HALF_UP );
      this.daxKurs = myDec.doubleValue();
      return this.daxKurs; 
    }
    double kurs = daxKurs;
    return kurs;
  }

  @SuppressWarnings( "unused" )
  public synchronized void callback( PushObject pushObject, Subscription subscription )
  {
    SimpleDateFormat sdf = new SimpleDateFormat( "dd.MM.yyyy HH:mm:ss" );

    if ( pushObject.hasData() )
    {
      // System.out.println("v: "+ pushObject.getName());
      try{
        this.daxKurs = Double.parseDouble(pushObject.getRawValue( 0, "PRICE" ));
        this.kurs    = new Kurs(sdf.format( new Date() ), this.daxKurs );
      }
      catch(Exception e){
        this.daxKurs = -9999;
      }
      //System.out.println("p: " + this.daxKurs);
//      System.out.println( sdf.format( new Date() ) + ": " + "Got Push: " + pushObject.getName()
//          + " " + "Event: " + pushObject.getUpdateEvent() + " " + "Rows: "
//          + pushObject.getNumberOfRows() );
//
//      if ( pushObject.getName().compareTo( "news/search_list" ) == 0 )
//      {
//        if ( pushCount == 0 )
//        {
//          for ( int i = 1; i < pushObject.getNumberOfRows(); i++ )
//          {
//            Calendar dateTimeNews = getCalendarValue( pushObject, i, "DATE_NEWS", "TIME_NEWS" );
//
//            System.out.println( i + ": Date/Time: "
//                + ( dateTimeNews != null ? sdf.format( dateTimeNews.getTime() ) : "n/a" ) + " - "
//                + pushObject.getStringValue( i, "HEADLINE" ) );
//          }
//        }
//        else
//        {
//          Calendar dateTimeNews = getCalendarValue( pushObject, 1, "DATE_NEWS", "TIME_NEWS" );
//
//          System.out.println( "Date/Time: "
//              + ( dateTimeNews != null ? sdf.format( dateTimeNews.getTime() ) : "n/a" ) + " - "
//              + pushObject.getStringValue( 1, "HEADLINE" ) );
//        }
//      }
//      else if ( pushObject.getName().compareTo( "prices/times_and_sales_list" ) == 0 )
//      {
//        Calendar dateTimePrice = pushObject.getCalendarValue( 1, "DATETIME_PRICE" );
//
//        System.out.println( "Date/Time: "
//            + ( dateTimePrice != null ? sdf.format( dateTimePrice.getTime() ) : "n/a" )
//            + " - Price: " + pushObject.getFloatValue( 1, "PRICE" ) + ", Volume: "
//            + pushObject.getFloatValue( 1, "VOLUME" ) );
//      }
//      else if ( pushObject.getName().compareTo( "prices/order_book_list" ) == 0 )
//      {
//        for ( int i = 1; i < pushObject.getNumberOfRows(); i++ )
//        {
//          Calendar dateTimeAsk = pushObject.getCalendarValue( i, "DATETIME_ASK" );
//          Calendar dateTimeBid = pushObject.getCalendarValue( i, "DATETIME_BID" );
//          BigDecimal askPrice = getBigDecimalValue( pushObject, i, "ASK" );
//          BigDecimal bidPrice = getBigDecimalValue( pushObject, i, "BID" );
//          BigDecimal volumeAsk = getBigDecimalValue( pushObject, i, "VOLUME_ASK" );
//          BigDecimal volumeBid = getBigDecimalValue( pushObject, i, "VOLUME_BID" );
//          Integer numberOrdersAsk = pushObject.getIntValue( i, "NUMBER_ORDERS_ASK" );
//          Integer numberOrdersBid = pushObject.getIntValue( i, "NUMBER_ORDERS_BID" );
//
//          System.out.println( i + ": DateTimeAsk:"
//              + ( dateTimeAsk != null ? sdf.format( dateTimeAsk.getTime() ) : "n/a" )
//              + ",AskPrice:" + askPrice + ",VolumeAsk:" + volumeAsk + ",NumberOrdersAsk:"
//              + numberOrdersAsk + ",DateTimeBid:"
//              + ( dateTimeBid != null ? sdf.format( dateTimeBid.getTime() ) : "n/a" )
//              + ",BidPrice:" + bidPrice + ",VolumeBid:" + volumeBid + ",NumberOrdersBid:"
//              + numberOrdersBid );
//        }
//      }
//    }
//    else
//    {
//      System.out.println( sdf.format( new Date() ) + ": " + "Invalid PushObject: HTTP Error Code: "
//          + pushObject.getHttpErrorCode() + ", HTTP Error Message: "
//          + pushObject.getHttpErrorMessage() + ", Status Code: " + pushObject.getStatusCode()
//          + ", Status Message: " + pushObject.getStatusMessage() + ", OP_EVENTS: "
//          + pushObject.getOperationEvents() + " - " + Thread.currentThread() );
//      System.out.println( "PushObject: " + pushObject.toLongString() );
    }

    pushCount++;
  }

  @SuppressWarnings( "unused" )
  public void callback( PushSession pushSession, SessionState sessionState )
  {
    SimpleDateFormat sdf = new SimpleDateFormat( "dd.MM.yyyy HH:mm:ss" );

    System.out.println( sdf.format( new Date() ) + ": Session State: "
        + sessionState.getStatusString() + ", Message: " + sessionState.getMessage() + ", Reason: "
        + sessionState.getReason() );
  }

  private Calendar getCalendarValue( PushObject pushObject, int row, String dateAttributeName, String timeAttributeName )
  {
    Calendar date = pushObject.getCalendarValue( row, dateAttributeName );
    Calendar time = pushObject.getCalendarValue( row, timeAttributeName );

    if ( date == null && time == null )
    {
      return null;
    }

    if ( date != null && time != null )
    {
      if ( date.getTimeZone().hasSameRules( time.getTimeZone() ) )
      {
        Calendar calendar = new GregorianCalendar( time.getTimeZone() );
        calendar.set( Calendar.DAY_OF_MONTH, date.get( Calendar.DAY_OF_MONTH ) );
        calendar.set( Calendar.MONTH, date.get( Calendar.MONTH ) );
        calendar.set( Calendar.YEAR, date.get( Calendar.YEAR ) );
        calendar.set( Calendar.HOUR_OF_DAY, time.get( Calendar.HOUR_OF_DAY ) );
        calendar.set( Calendar.MINUTE, time.get( Calendar.MINUTE ) );
        calendar.set( Calendar.SECOND, time.get( Calendar.SECOND ) );

        return calendar;
      }

      return null;
    }

    return null;
  }
  
  BigDecimal getBigDecimalValue( PushObject pushObject, int row, String attributeName )
  {
    String rawValue = pushObject.getRawValue( row, attributeName );

    if ( rawValue != null && rawValue.trim().length() > 0 )
    {
      try
      {
        return new BigDecimal( rawValue );
      }
      catch ( NumberFormatException e )
      {
        return null;
      }
    }

    return null;
  }
}

