package com.ml.utils;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mailer {
  
  public static final boolean SHOW_DEBUGS = false;
    
  public Mailer(){
  }
  
  public String sendMessage(String adress, String fromText, String subject, String message, String hostName, String hostIp, String userName, String userPwd){
    Properties props = System.getProperties();
    props.put(hostName, hostIp);
    props.put("mail.host", hostIp);

    String messageText = "";
    
    try{
  
      Session mailConnection = Session.getInstance(props, null);
      mailConnection.setDebug(Mailer.SHOW_DEBUGS);
      Address from = new InternetAddress(fromText);
      Address to = new InternetAddress(adress);

      Message msg = new MimeMessage(mailConnection);
      msg.setFrom(from);
      msg.setRecipient(Message.RecipientType.TO, to);
      msg.setSubject(subject);

      MimeMultipart mimeMultipart = new MimeMultipart();

      BodyPart body = new MimeBodyPart();
      body.setText(message);
      mimeMultipart.addBodyPart(body);
      
      msg.setContent(mimeMultipart);

      // root content
      msg.setContent(message, "text/html");
      Transport.send(msg);    
    }
      
    catch(Exception e){
      e.printStackTrace();
    }
    
    return messageText;

  }
}


