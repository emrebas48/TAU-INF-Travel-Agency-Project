import java.util.Scanner;
import java.util.ArrayList;
import java.lang.*;
import java.util.Date;
import java.util.InputMismatchException;

public class Main {
  
  public static void main(String[] args) {

    Reisebuero rb = new Reisebuero();
    
    String id;    
    
    Scanner sc = new Scanner(System.in);
    
    int operation = 0;
    while (operation != 100) {
    
      System.out.println("\nWelche Operation moechten Sie durchfuehren?");
      System.out.println("  1-  Mitarbeiter hinzufuegen");
      System.out.println("  2-  Mitarbeiter auflisten");
      System.out.println("  3-  Mitarbeiter loeschen");
      System.out.println("  4-  Kunde hinzufuegen");
      System.out.println("  5-  Kunden auflisten");
      System.out.println("  6-  Kunde loeschen");
      System.out.println("  7-  Reisepaket hinzufuegen");
      System.out.println("  8-  Reisepakete auflisten");
      System.out.println("  9-  Aktuelle Reisepakete auflisten");
      System.out.println("  10- Reisepaket loeschen");
      System.out.println("  11- Reisepaket an Kunden verkaufen");
      System.out.println("  12- Reisepaket von Kunde auflisten");
      System.out.println("  100-Programm beenden");
      try{
      operation = sc.nextInt();
      switch (operation) {
          
        case 1:      //Mitarbeiter hinzufuegen
          System.out.println("Geben Sie die ID des Mitarbeiters ein");
          id = sc.next();
              
          try{
                Person.checkIfIdValid(id);
                System.out.println("Geben Sie den Namen ein");
                String name = sc.next();
      
                System.out.println("Geben Sie den Nachnamen ein");
                String nn = sc.next();
      
                System.out.println("Geben Sie das Gehalt ein");
                double g = sc.nextDouble();

                rb.addMitarbeiter(new Mitarbeiter(id,name,nn,g));
                
            
          }catch (InvalidIDException e){
              System.out.println(e.getMessage());
          }
        break;
          
          
        case 2:     // Mitarbeiter auflisten
            rb.printMitarbeiter();
        break;

          
        case 3:      //Mitarbeiter loeschen
            System.out.println("Geben Sie die ID des Mitarbeiters ein");
            id = sc.next();  
            rb.loeschenMitarbeiter(id);
        break;   
          
          
        case 4:  //Kunde hinzufuegen
          System.out.println("Geben Sie die ID des Kundes ein");
          id = sc.next();
          try{
            Person.checkIfIdValid(id);
            System.out.println("Geben Sie den Namen ein");
            String name = sc.next();
    
            System.out.println("Geben Sie den Nachnamen ein");
            String nn = sc.next();
    
            System.out.println("Geben sie den Kontostand ein");
            double kn = sc.nextDouble(); 

            rb.addKunde(new Kunde (id,name,nn,kn));
            
          }catch (InvalidIDException e){
              System.out.println(e.getMessage());
          }
          break;

        case 5:  // Kunden auflisten
            rb.printKunden(); 
        break;
          

        case 6:  // Kunden loeschen
            System.out.println("Geben Sie die ID der Kunde ein");
            id = sc.next();
            rb.loeschenKunde(id); 
        break;  
          

        case 7:    //Reisepaket hinzufuegen
          System.out.println("Geben Sie ein Destination ein");
          String d= sc.next();
          System.out.println("Geben Sie ein Startdatum ein (dd.mm.yyyy)");
          String sd= sc.next();
          System.out.println("Geben Sie ein Enddatum ein (dd.mm.yyyy)");
          String ed= sc.next();
          
          if(sd.length()==10  &&  ed.length()==10){
            
            try{
              int tag = Integer.parseInt(sd.substring(0,2));
              int monat = Integer.parseInt(sd.substring(3,5)) -1;
              int jahr = Integer.parseInt(sd.substring(6,10)) -1900;
              Date Startdatum = new Date(jahr,monat,tag);
    
              tag = Integer.parseInt(ed.substring(0,2));
              monat = Integer.parseInt(ed.substring(3,5)) -1;
              jahr = Integer.parseInt(ed.substring(6,10)) -1900;
              Date Enddatum = new Date(jahr,monat,tag);
  
              rb.addReisepaket(new Reisepaket(d,Startdatum,Enddatum));
              
            } catch( NumberFormatException e){
               System.out.println("Geben Sie gueltige Daten ein!");
            }
          }
            else{
            System.out.println("Geben Sie die Daten im angegebenen Format!!!"); 
          } 
        break;

          
        case 8:   //Reisepaketen auflisten
            rb.printAlleReisepakete();
        break;
          
          
        case 9:   //aktuelle reisepakete auflisten
            rb.printAktuelleReisepakete();
        break;    

          
        case 10:    //Reisepaket loeschen
            System.out.println("Geben Sie die Paket ID ein");
            int rib= sc.nextInt();
            rb.loeschenReisepaket(rib);
        break;

        
        case 11:   //Reisepaket an Kunden verkaufen  
          System.out.println("Geben Sie bitte die ID der Kunde ein");
          String kid = sc.next();
          
          System.out.println("Geben Sie eine Reisepaket ID ein:");
          String rid = sc.next();

          Kunde k = rb.getKunde(kid); 
          if( k==null ){
            System.out.println("Kunde mit dieser ID existiert nicht");  
          }

          Reisepaket rp = rb.getReisepaket(Integer.parseInt(rid));
          if(rp == null){
            System.out.println("Reisepaket mit dieser ID existiert nicht");
          }

          if( k != null && rp != null){
            rb.verkaufeReisepaket(kid, Integer.parseInt(rid));
          }
        break;


        case 12:     // Reisepakete von Kunde auflisten
          System.out.println("Geben Sie bitte die ID der Kunde ein");
          id = sc.next();
          Kunde k2 = rb.getKunde(id); 
          if( k2==null ){
              System.out.println("Kunde mit dieser ID existiert nicht");  
          }else{
              k2.printReisepakete();
          }
        break;  
          
      }
      } catch(InputMismatchException ime){
          if(operation<1 || operation>12){
              System.out.println("Geben Sie ein Zahl von Menu !!!"); 
          } 
      }
      
    }
  }
}