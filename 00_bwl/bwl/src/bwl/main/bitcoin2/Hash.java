package bwl.main.bitcoin2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

    public static String hashfunktion(String input){


        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        byte[] hashObject = md.digest(input.getBytes());

        StringBuffer finalHash = new StringBuffer();

        for(byte b : hashObject){
            finalHash.append(String.format("%02x",b & 0xff) );

        }

        return finalHash.toString();



    }



}

