package models;

/**
 * Created by zeljko94 on 11.11.2016..
 */
public class Raspored {
    private int id;
    private String nastavnik;
    private String predmet;
    private String ucionica;

    public Raspored(int id, String nastavnik, String predmet, String ucionica, String datum_od, String datum_do) {
        this.id = id;
        this.nastavnik = nastavnik;
        this.predmet = predmet;
        this.ucionica = ucionica;
        this.datum_od = datum_od;
        this.datum_do = datum_do;
    }

    public String getUcionica() {

        return ucionica;
    }

    public void setUcionica(String ucionica) {
        this.ucionica = ucionica;
    }

    private String datum_od;
    private String datum_do;



    public String getNastavnik() {

        return nastavnik;
    }

    public void setNastavnik(String nastavnik) {
        this.nastavnik = nastavnik;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPredmet() {
        return predmet;
    }

    public void setPredmet(String predmet) {
        this.predmet = predmet;
    }

    public String getDatum_od() {
        return datum_od;
    }

    public void setDatum_od(String datum_od) {
        this.datum_od = datum_od;
    }

    public String getDatum_do() {
        return datum_do;
    }

    public void setDatum_do(String datum_do) {
        this.datum_do = datum_do;
    }
}
