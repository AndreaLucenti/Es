import java.util.ArrayList;

public class Agenda {
  private String[] giorni = {"1", "2", "3", "4","5","6","7"};
  private String[] ore = {"8","9","10","11","12","13","14","15","16","17"};
  private int giornoP = 0;
  private int oraP = 0;
  private ArrayList<Prenotazione> prenotazione;

  public Agenda() {
    this.prenotazione = new ArrayList<Prenotazione>();
  }

  public void addPrenotazione(Prenotazione pren){
    prenotazione.add(pren);
  }
  public String setOra(){
    if(oraP == 10){
      oraP = 0;
      return ore[oraP++];
    }
    else {
      return ore[oraP++];
    }
  }

  public String setGiorno(){
    if (oraP == 10){
      return giorni[giornoP++];
    }
    else {
      return giorni[giornoP];
    }
  }
  @Override
  public String toString() {
    String out="";
    for (int i = 0; i < prenotazione.size(); i++){
      out += prenotazione.get(i).toString();
    }
    return "Prenotazioni:"+"\n"+out;
  }
}
