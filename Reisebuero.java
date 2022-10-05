import java.util.ArrayList;
import java.util.Date;

public class Reisebuero implements ReisebueroSchnittstelle{

  private ArrayList<Mitarbeiter> mitarbeiter = new ArrayList();
  private ArrayList<Kunde> kunden = new ArrayList();
  private ArrayList<Reisepaket> reisepaketen = new ArrayList();
  private int rp_counter = 0;


  public void addKunde(Kunde k){
    kunden.add(k);
  }

  public void addMitarbeiter(Mitarbeiter m){
    mitarbeiter.add(m);
  }

  public void addReisepaket(Reisepaket rp){
    rp.setPaket_ID(rp_counter+1);
    rp_counter++; 
    reisepaketen.add(rp);
  }
  
  public void loeschenKunde(String id){
    for(int i=0;i<kunden.size();i++){
      Kunde k1 = (Kunde) kunden.get(i);
      Kunde k = (Kunde) k1; 
      if(k1.getId().equals(id) == true ){
        kunden.remove(i);       
      }
    }
  }
  
  public void loeschenMitarbeiter(String id){
          //personen.remove( new Mitarbeiter(id) );
          // 1. Arraylistden ID ye göre Mitarbeiteri bulmk icin
          for(int i=0;i<mitarbeiter.size();i++){
              Mitarbeiter m1 = mitarbeiter.get(i);
                  Mitarbeiter m = (Mitarbeiter) m1;              
                  if(m1.getId().equals(id) == true ){
                      mitarbeiter.remove(i);       //mitarbeiteri silmek icin
                  }
          }
  }
  
  public void loeschenReisepaket(int rp_counter){
    for(int i=0;i<reisepaketen.size();i++){
      Reisepaket r2 = reisepaketen.get(i);
      Reisepaket r1 = (Reisepaket) r2; 
      if(r2.getPaket_ID()== rp_counter){
        reisepaketen.remove(i);       
      }
    }
  }

  public void setReisepaketcounter(int rp_counter){
    this.rp_counter=rp_counter;
  }
  
  public int getReisepaketCounter(){
    return rp_counter;
  }
    
  
  public Kunde getKunde(String id){
    int i = kunden.indexOf(new Kunde(id));
    if(i == -1){
      return null;
    } else{  
      return kunden.get(i);
    }
     
  }

  public Mitarbeiter getMitarbeiter(String id){
    int ii = mitarbeiter.indexOf(new Mitarbeiter(id));
    if(ii == -1){
      return null;
    } else{  
      return mitarbeiter.get(ii);
    }
  }

  public Reisepaket getReisepaket(int id){
    int j = reisepaketen.indexOf(new Reisepaket(id));
    if(j == -1){
      return null;
    } else{  
      return reisepaketen.get(j);
    }
     
    
  }

  public void printKunden(){
      for(int i=0; i<kunden.size() ; i++){
        System.out.println(kunden.get(i));
      }
  }

  public void printMitarbeiter(){
      for(int i=0; i<mitarbeiter.size() ; i++){
        System.out.println(mitarbeiter.get(i));
      }  
  }

  public void printAlleReisepakete(){
      for(int i=0; i<reisepaketen.size() ; i++){ 
        System.out.println(reisepaketen.get(i));
      }
  }

  public void printAktuelleReisepakete(){
      Date bugun = new Date();
      for(int i=0; i<reisepaketen.size() ; i++){
        Reisepaket re = reisepaketen.get(i);  
        // eger  startdatum bugünden sonra ise
        if(bugun.before(re.getStartdatum()) == true){
            System.out.println(re);
        }
      } 
  }
  // kunde ve rp varsa kundeye rp'yi verir, 0 geri verir
  // kunde mevcut degilse -1 verir
  // rp mevcut degilse -2 verir
  public int verkaufeReisepaket(String kunde_id, int rp_id){
      int kontrol1 = kunden.indexOf(new Kunde(kunde_id));
      if(kontrol1 != -1){
          int kontrol2 = reisepaketen.indexOf(new Reisepaket(rp_id));
              if(kontrol2 != -1){
              kunden.get(kontrol1).addReisepaket(reisepaketen.get(kontrol2));
              }
        }
  return 0;
  }

}
  