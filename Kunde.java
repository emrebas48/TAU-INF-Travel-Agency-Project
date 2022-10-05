import java.util.ArrayList;

public class Kunde extends Person{
  
  private double kontostand =0;
  private double rabatt =0;
  ArrayList gekaufte_reisepakete = new ArrayList();

  public Kunde(String id){
    super(id);
  }

  public Kunde(String id, String name, String nachname){
    super(id,name,nachname);
  }
  
  public Kunde(String id, String name, String nachname, double kontostand){
    super(id,name,nachname);
    this.kontostand=kontostand;
  }
  
  public Kunde(String id, double kontostand){
    super(id);
    this.kontostand = kontostand;
  }

  public Kunde(String id, double kontostand, double rabatt){
    super(id);
    this.kontostand = kontostand;
    this.rabatt = rabatt;
  }

  public void setKontostand(double kontostand){
    this.kontostand=kontostand;   
  }

  @Override
  public String  toString(){
    return getId() + " " + getName() + " " + getNachname() + " " + kontostand;
  }    

  public void addReisepaket(Reisepaket rp){
    gekaufte_reisepakete.add(rp);
  }

  public ArrayList getReisepakete(){
    return gekaufte_reisepakete;
  }

  public void printReisepakete(){
    for(int i=0;i<gekaufte_reisepakete.size();i++){
      System.out.println(gekaufte_reisepakete.get(i).toString());
    }
  }

  
}

