package com.ml.connection;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class Publisher {

  
  private Session     session;
  private ChannelSftp channel;
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    new Publisher().dateiBereitstellen("", 1);

  }
  
  public void dateiBereitstellen(String xml, int nummer){
    try{ SFtpWrapper sftpWrapper = new SFtpWrapper( "root", "EidR,dmi01", "mleue.de", 22 ) ;
      String meinText = "aaaaaaaaaaaaaaa";
      String charEncoding     = "UTF-8";
      String localSftpSubdir  = "c:\\0_ml\\0_ml_muell\\";
      String remoteSftpSubdir = "/opt/ml";
      String localFilePathB   = localSftpSubdir  + "01_ml.png";
      String remoteFilePathC  = remoteSftpSubdir + "01_ml.png";
          ByteArrayInputStream is = new ByteArrayInputStream( meinText.getBytes( charEncoding ) ) ; 
         sftpWrapper.createRemoteFile( is, remoteFilePathC );
      
      sftpWrapper.uploadFile(   localFilePathB, remoteFilePathC );
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
  
  

}

