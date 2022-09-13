package com.ml.connection;

import java.io.OutputStream;
import java.io.OutputStreamWriter;

import com.conf.BasicEnvConfiguration;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class XMLPublish {

  public static void main(String args[]) {
    
    String result = "<VERKAUF>" + "\n" + "<MANTEL>" + "\n"
    + "<PREIS>163</PREIS>" + "\n" + "<ANZAHL>43</ANZAHL>" + "\n"
    + "</MANTEL>" + "\n" + "<HOSEN>" + "\n" + "<PREIS>87</PREIS>" + "\n"
    + "<ANZAHL>73</ANZAHL>" + "\n" + "</HOSEN>" + "\n" + "</VERKAUF>"
    + "\n";
    new XMLPublish().publish(result, 10, "leue");
  }

  public XMLPublish() {

  }

  public void publish(String xml, int kanalNummer, String xmlBezeichner) {
    Session session = null;
    try {
      try {

        JSch jsch = new JSch();
        session = jsch.getSession(BasicEnvConfiguration.publisherUser,
            "85.214.207.250");
        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);

        session.setPassword(new Integer(BasicEnvConfiguration.calculate())
            .toString());
        session.connect();
      } catch (Exception e) {
        System.out
            .println("Es ist bereits beim Versuch eine Verbindung aufzubauen ein Fehler aufgetreten. Entweder ist die IP Adresse des Servers falsch oder der Server ist von diesem Rechner aus nicht erreichbar (Firewall) oder keine Internetverbindung");
      }

      ChannelSftp sftpChannel = null;
      try {

        sftpChannel = (ChannelSftp) session.openChannel("sftp");
        sftpChannel.connect();

        OutputStream out = sftpChannel
            .put("/opt/ml/tomcat_3/webapps/bwl/" + kanalNummer + "/" + xmlBezeichner + ".xml");

        OutputStreamWriter writer = new OutputStreamWriter(out);
        writer.write(xml);
        writer.flush();
        writer.close();
      } catch (Exception ex) {
        ex.printStackTrace();
      } finally {
        sftpChannel.disconnect();
      }
    } finally {
      session.disconnect();
    }

  }
}
