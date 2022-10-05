public class Mitarbeiter extends Person {

  private int mitarbeiter_id;
  private double gehalt;

  public Mitarbeiter(String id) {
    super(id);
  }

  public Mitarbeiter(String id, String name, String nachname,double gehalt){
    super(id,name,nachname);
    this.gehalt=gehalt;
  }

  public void setMitarbeiterId(int Mitarbeiter_id) {
    this.mitarbeiter_id = mitarbeiter_id;
  }

  public void setGehalt(double gehalt) {
    this.gehalt = gehalt;
  }

  public double getGehalt() {
    return this.gehalt;
  }

  public void setProfessor(String name,String nachname){
    setName(name);
    setNachname(nachname);
  }
      

  @Override
  public String  toString(){
    return super.getId() + "  " + super.getName() + "  " + super.getNachname() + "  Gehalt:" + getGehalt();
  }
  
}