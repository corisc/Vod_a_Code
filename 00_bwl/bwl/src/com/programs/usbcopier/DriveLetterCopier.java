package com.programs.usbcopier;

import java.io.File;

import javax.swing.filechooser.FileSystemView;

import com.programs.usbcopier.copy.RoboCopy;
import com.programs.usbcopier.copy.TestCheckEvent;

public class DriveLetterCopier {

  private String nameOfDrives;
  private String zielVerzeichnis;
  private String quellenVerzeichnis;
  
  public static void main(String[] args) {
    //new DriveLetterCopier("STORE N GO", "c:/bwl", "");
    new DriveLetterCopier("STICK", "c:/0_ml/0_ml_muell/00_stick", "");
  }

  public DriveLetterCopier(String nameOfDrives, String quellenVerzeichnis, String zielVerzeichnis) {
    super();
    this.nameOfDrives = nameOfDrives;
    this.zielVerzeichnis = zielVerzeichnis;
    this.quellenVerzeichnis = quellenVerzeichnis;
    
    TestCheckEvent testCheckEvent = new TestCheckEvent();
    // String s = "DEFGHIJKLMNOPQRSTUVWXYZ";
    String s = "EFGHIJKLNOPRSTUVWXZ";
    for(char a : s.toCharArray()){
    File fd = new File(a + ":/");
      if(fd.exists()){
        String name = FileSystemView.getFileSystemView().getSystemDisplayName(fd);
        if(name.indexOf(nameOfDrives) > -1){
          System.out.println("found " + a);
          RoboCopy roboCopy = new RoboCopy(testCheckEvent, quellenVerzeichnis, a+":"+zielVerzeichnis);
          roboCopy.call();
          System.out.println("done " + a);
        }
      }
    }
  }
}

