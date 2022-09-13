package com.ml.utils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.conf.BasicEnvConfiguration;
import com.is_teledata.log.Level;
import com.is_teledata.log.Logger;
import com.is_teledata.log.RollingFileAppender;
import com.is_teledata.log.Setup;
import com.is_teledata.mdg.push.PushCallback;
import com.is_teledata.mdg.push.PushConfig;
import com.is_teledata.mdg.push.PushObject;
import com.is_teledata.mdg.push.PushSession;
import com.is_teledata.mdg.push.SessionState;
import com.is_teledata.mdg.push.StateCallback;
import com.is_teledata.mdg.push.Subscription;
//import com.sun.xml.internal.ws.encoding.soap.SOAP12Constants;

public class NewsServer implements PushCallback, StateCallback{
  

  private static int    pushCount  = 0;
  private String        nachricht    = "nichts";

  private PushSession   pushSession;
  private Helfer        helfer      = new Helfer();
  private String        onvista     = "";
  
  
  public NewsServer(){
    this(null, 0);
  }
  
  public NewsServer(String proxyHost, int proxyPort){
    if(proxyHost != null){
      System.setProperty( "http.proxyHost", proxyHost );
      System.setProperty( "http.proxyPort", ""+proxyPort );
      System.setProperty( "https.proxyHost", proxyHost );
      System.setProperty( "https.proxyPort", ""+proxyPort );
    }
    this.onvista = BasicEnvConfiguration.DECIDE_MIS_VIA_WEB_OR_MASTER();
    if(this.onvista.equals("nix")){
      System.out.println("Passwort fuer die online Newsversorgung konnte nicht geholt werden. Dies geht nur waehrend der Uebung.");
      return;
    }
    
    try
    {

      Setup.setStackTraceLevel( Level.ERROR);
      Logger.getRoot().setLevel( Level.ERROR );
      String logFile = "MDG_";
      RollingFileAppender mdgFileAppender = new RollingFileAppender( logFile, RollingFileAppender.COUNTVAR_TWODIGIT, ".log", RollingFileAppender.CONDITION_CLOCKTIME );
      Logger.getRoot().setAppender( mdgFileAppender );
      
      PushConfig pushConfig = PushConfig.getPushConfig();
      this.pushSession = PushSession.getPushInstance( pushConfig, "10413", "id10413", this.onvista );
      //System.out.println( "Method PushSession.getPushInstance() completed successfully." );

      Subscription sub1 = new Subscription( "news/search_list?ID_TYPE_ARTICLE=2&VERSION=2", this);
      //Subscription sub1 = new Subscription( "prices/quote?CODE_MARKET=_GER&ID_CURRENCY=EUR&ID_QUALITY_PRICE=4&ID_SELECTOR_NOTATION=1&ISIN=DE0001717049&VERSION=2", this);

      pushSession.subscribe( sub1 );

   }
    catch ( Exception e )
    {
      e.printStackTrace();
    }

  }

  public void close(){
    pushSession.close( true );
  }
  
  public String getNachricht() {
    this.helfer.warteMillis(500);
    if(onvista.equals("nix")){
      this.nachricht = "leer";
      return this.nachricht; 
    }
    return this.nachricht;
  }

  @SuppressWarnings( "unused" )
  public synchronized void callback( PushObject pushObject, Subscription subscription )
  {
    SimpleDateFormat sdf = new SimpleDateFormat( "dd.MM.yyyy HH:mm:ss" );
    
    if ( pushObject.hasData() )
    {
      //String roh = pushObject.toDebugString();
      //System.out.println(""+roh);
      try{
        this.nachricht = pushObject.getStringValue( 1, "HEADLINE" );
        //System.out.println(""+this.nachricht);
        //this.daxKurs = Double.parseDouble(pushObject.getRawValue( 0, "PRICE" ));
        //this.kurs    = new Kurs(sdf.format( new Date() ), this.daxKurs );
      }
      catch(Exception e){
        this.nachricht = "nichts";
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
  
  private void zeigeDaten(PushObject pushObject){
    String[] datatypes = {
        "TIME_LOW",
        "ID_EXCHANGE",
        "SOURCE_ASK",
        "DATE_LOW",
        "VOLUME_BID",
        "DATE_HIGH_PRICE_1_YEAR",
        "HIGH_PRICE_1_YEAR",
        "DATETIME_LOW_PRICE_1_YEAR",
        "DATETIME_BID",
        "ID_TYPE_PRICE_PREVIOUS_LAST",
        "ASK",
        "ID_TYPE_PRICE_ASK",
        "CODE_CONTRIBUTOR",
        "ID_DELIVERY",
        "DATE_PREVIOUS_LAST",
        "PERFORMANCE_1_YEAR_PCT",
        "ID_NOTATION",
        "FIRST",
        "DATETIME_HIGH_PRICE_1_YEAR",
        "TIME_HIGH",
        "LOW_PRICE_1_YEAR",
        "MONEY_BID",
        "CODE_EXCHANGE",
        "TIME_FIRST",
        "NUMBER_ORDERS_ASK",
        "ID_TIMEZONE",
        "DATE_FIRST",
        "TOTAL_MONEY",
        "LOW",
        "ID_TYPE_PRICE_LOW",
        "ID_QUALITY_PRICE",
        "PERFORMANCE",
        "ID_QUALITY_PRICE_BID_ASK",
        "TIME_BID",
        "ID_SALES_PRODUCT_BID_ASK",
        "ID_INSTRUMENT",
        "PREVIOUS_LAST",
        "VOLUME_ASK",
        "ID_TYPE_PRICE_HIGH",
        "DATE_BID",
        "TIME_PREVIOUS_LAST",
        "MONEY",
        "DATETIME_ASK",
        "PERFORMANCE_1_YEAR",
        "ID_TYPE_INSTRUMENT",
        "PERFORMANCE_PCT",
        "ID_TYPE_PRICE_FIRST",
        "DATETIME_FIRST",
        "ID_TYPE_PRICE",
        "PRICE",
        "CODE_TOOL",
        "CODE_QUALITY_PRICE",
        "ID_CONTRIBUTOR",
        "ADDENDUM",
        "DATETIME_HIGH",
        "TIME_PRICE",
        "MONEY_ASK",
        "DATE_PRICE",
        "ID_TYPE_PRICE_TOTALS",
        "DATE_LOW_PRICE_1_YEAR",
        "SOURCE_BID",
        "DATETIME_LOW",
        "HIGH",
        "TOTAL_VOLUME",
        "SOURCE_PRICE",
        "BID",
        "VOLUME_4_WEEKS",
        "ID_TYPE_PRICE_BID",
        "DATE_HIGH",
        "ID_CURRENCY",
        "TIME_ASK",
        "ID_SALES_PRODUCT",
        "TIME_LOW_PRICE_1_YEAR",
        "DATE_ASK",
        "CODE_QUALITY_PRICE_BID_ASK",
        "NUMBER_PRICES",
        "DATETIME_PRICE",
        "CODE_TRADING",
        "DATETIME_PREVIOUS_LAST",
        "TIME_HIGH_PRICE_1_YEAR",
        "ID_UNIT_PRICE",
        "NUMBER_ORDERS_BID",
        "ID_TRADING_SCHEDULE",
        "ID_DELIVERY_BID_ASK",
        "VOLUME",
        "ISO_CURRENCY",
        "AMOUNT"
    };
    for(String d : datatypes){
      System.out.println(d + " - " + pushObject.getRawValue(d));
    }
  }

  
  public static void main(String args[]){
    NewsServer n = new NewsServer("proxy.elaxy.org",3128);
    
  }

}

