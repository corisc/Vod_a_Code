package bwl.oo.paket5;

/**
 *   http://www.plantuml.com/plantuml/uml/bLZDZjis4BxpAGYVupIv1AWH5Da0JGDasoowXnm3sfh8h2NQ8AaQy2dla0VePT6-GKzxgjuaJzAX-ACX9Tl9NbQS-MOuVvoPtLV62csxjc6RHXZ3RuMgm1o4RaGBol90_bKgQIpeW-uVZAm8nmjeg2NeJjMH_BeRoCBcX3z16z6spGGvLUpfLXJ0dL2d1dHnp_prUDidF27TrA3bPfkK_-uEeCFf7fImuViNC61FyO0wgvfIxZ1Q8CFXPbt3NbSAB0JA1x5jTXga8T4fGXWjX9FKEmAZOlTML7Ry5jOOGBxj7tIywHPTDesmdJwWQ_iAM76Fx5g6FsL25sh1bzN-g9O_ySNpnLncL_pOFsmRosPuJeIAb-bVyRLiAh2iP9I2Ou6ikDbivMPdqHPRDn8g3DAOVGHFvM8L95DpyfdBfbQM30T-wIMNH7Aca5PyjrTMxniqM4T5CxZ1b6Lto2nnVdsFWfTEmNAY8FFzxDqDVB8pGSzkdrG91Zq9OiNKiDjhKF1nJD579-FjCA36OCQSBRMijvVagIT1msKOAfecbNGKTidAikwdqjCEDLz6So_bSWfy90OJOkFvPW7VcwwaU426pfLb0Nd1TjBAqEp-0K7Q_h06V7iOAMFIMn3sUmNznJx2eKffuopOvoAv1XbSg67jebz33Ue4wAO2nL9dpUuP-YjXZT48_TN_eeonrqvvlkyw15-qcGHv71DJ1YoT1UIRGj84Y1-9IT_rVETCzkMpO1xhmUawFxFuujdJfqNeYEWPL2gAYtndzbmFYSuDSNNFNDgJvLAn46Da9KqHiyK2V2kwWpL3CiPOFVlw-U_eNlYcKTSqx3f58c7Bs74MNK9KfeVTvVFkw-SlPImk0LmmpW2A4C4CxlBOmS2LSz-PJufdZbscUfBB-7Mj9kBNk1W8yERZ2otxHrQ453dqUrS81btYfyxrMwIAph19aaWHaSM6JxhScPvEokUCelDlaSIBCJevtskRdL_yoB5sqBK6_O7f5kDHw1v74B_rBLJX07PkLr5trWn_m_gOez-qrc1Bj8oLUn2H68a9Fbs0FAMDFU8S8EZ225mRuHZsIhhyyjVzeyPwVN9LXD_fFLhWXAw3xmzxRPrRIEFl-aTbx63OvTNa6wqQ1OX9wSeh8eL15rR6Uva6z2oVZir9FrtnF-08if4rXEGqlfHca5AXLdm5bZz_WPslVzpi69jTzOUwcUMCjHQMbeWUZpULnWq0__GOjXGaaDgFStyLflgwssn7sd__823RBB3I55UTvbMdiIsCJyU5Too4r2vg2Bi8Fu9xVOKwrrb5kuPcxFF1_7IYnjAH7N1nFuXlAvqwl5-Fvv-bEkvnHz4dt0jyslns40GfeS36cJVWuY77H6gitnRyW_KJT4L79LbCN2dr__P_GKOBbbFI1xU_WiPNxYxBEFZTOFgpaawhCUP-4C6MfhD0Cj9pY-h2ynknsQv1kwMElSBcv_xnmFu7
 * 
 * 
 * 
 * 
   public String getXXX(){
    return this.oneName1;
  }
  
  public int getXXX(){
    return this.oneNumber1;
  }
  

 * 
 * 
 * 
 * 
 * @author leue.markus
 *
 */

public class Start {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    Wahlleiter wahlleiter1 = new Wahlleiter("Thomas", "Wahl1");
    Wahlleiter wahlleiter2 = new Wahlleiter("Thomas", "Wahl2");
    Wahlleiter wahlleiter3 = new Wahlleiter("Thomas", "Wahl3");
    Wahlleiter wahlleiter4 = new Wahlleiter("Thomas", "Wahl4");
    Wahlleiter wahlleiter5 = new Wahlleiter("Thomas", "Wahl5");

    Wahlkreis w1 = new Wahlkreis(100, "Wahli1", 9000000, wahlleiter1);
    Wahlkreis w2 = new Wahlkreis(100, "Wahli2", 9000000, wahlleiter2);
    Wahlkreis w3 = new Wahlkreis(100, "Wahli3", 9000000, wahlleiter3);
    Wahlkreis w4 = new Wahlkreis(100, "Wahli4", 9000000, wahlleiter4);
    Wahlkreis w5 = new Wahlkreis(100, "Wahli5", 9000000, wahlleiter5);

    Bezirk bezirk1 = new Bezirk("Schwaben", 1066, 2600000);
    Bezirk bezirk2 = new Bezirk("Allgaeu", 1077, 450000);
    Bezirk bezirk3 = new Bezirk("Noerdlingen", 1176, 1700000);
    Bezirk bezirk4 = new Bezirk("Donau Ries", 1209, 1300000);
    Bezirk bezirk5 = new Bezirk("Altoetting", 905, 550000);
    
    
    
    
    
    
    Buergermeister buergermeisterMuenchen = new Buergermeister("Michael", "Reiter");
    
    Stadt hauptstadtBayern = new Stadt("Muenchen", 1400000, buergermeisterMuenchen);
    
    Bundesland bayern = new Bundesland("Bayern", hauptstadtBayern);
    
    
    
    
    Bundestag2 b2 = new Bundestag2();
    Abgeordneter a1 = new Abgeordneter("Markus", "Leue", 111);
    
    b2.abgeordnetenHinzufuegen(a1);
    System.out.println(""+ b2.findeAbgeordneten("Markus", "Leue").getVorname());
    System.out.println(""+ b2.findeAbgeordneten(111).getVorname());
    
    
    //System.out.println(""+l.holeWahlkreis(100).getWahlleiter().getNachname());
    

  }

}
