import java.util.Date;
  
public class Reisepaket{
  private int Paket_ID;
  private Date Startdatum;
  private Date Enddatum;
  private String Destination;
  private int Tage;

  public Reisepaket(int Paket_ID){
    this.Paket_ID=Paket_ID;
  }

    public Reisepaket(String Destination, Date Startdatum, Date Enddatum){
    this.Destination=Destination;
    this.Startdatum=Startdatum;
    this.Enddatum=Enddatum;
  }
  
  public Reisepaket(int Paket_ID, String Destination, Date Startdatum, Date Enddatum){
    this.Paket_ID=Paket_ID;
    this.Destination=Destination;
    this.Startdatum=Startdatum;
    this.Enddatum=Enddatum;
  }


  public void setPaket_ID(int Paket_ID){
    this.Paket_ID=Paket_ID;
  }
  public void setStartdatum(Date Startdatum){
    this.Startdatum=Startdatum;
  }
  
  public void setEnddatum(Date Enddatum){
    this.Enddatum=Enddatum;
  }
  public void setDestination(String Destination){
    this.Destination=Destination;
  }
  public void setTage(int Tage){
    this.Tage=Tage;
  }

  
  public int getPaket_ID(){
    return Paket_ID;
  }
 
  public String getDestination(){
    return Destination;
  }
  public Date getStartdatum(){
    return Startdatum;
  }
  public Date getEnddatum(){
    return Enddatum;
  }
  
  @Override
  public String toString(){
    return (Paket_ID+": nach "+Destination +", "+ Startdatum.getDate()+"."+(Startdatum.getMonth()+1)+"."+(Startdatum.getYear()+1900)+ " ---> "+ Enddatum.getDate()+"."+(Enddatum.getMonth()+1)+"."+(Enddatum.getYear()+1900));
  }


   public boolean equals(Object obj){  // karsilastirma
    if(obj instanceof Reisepaket){
      Reisepaket rp =(Reisepaket) obj;
      if(Paket_ID == rp.getPaket_ID()){
        return true;
      }
    }
    return false;
  }

}