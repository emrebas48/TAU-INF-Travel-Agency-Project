public interface ReisebueroSchnittstelle {

  public void addKunde(Kunde k);
  public void addMitarbeiter(Mitarbeiter m);
  public void addReisepaket(Reisepaket rp);

  public Kunde getKunde(String id);
  public Mitarbeiter getMitarbeiter(String id);
  public Reisepaket getReisepaket(int id);

  public void printKunden();
  public void printMitarbeiter();
  public void printAlleReisepakete();
  public void printAktuelleReisepakete();
  
  public int verkaufeReisepaket(String kunde_id, int rp_id);
}