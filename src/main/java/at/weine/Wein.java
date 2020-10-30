package at.weine;

import javafx.scene.layout.VBox;

import java.util.Objects;

public class Wein extends VBox {

    private int id;

    private String reebsorte;
    private String qualitaetsbezeichnung;

    private boolean dac;

    private Weinart weinart;

    private String jahrgang;
    private String land;
    private String weingut;
    private String ort;
    private String umgebung;

    private double preis;
    private int bestand;
    private double liter;
    private float alkoholgehalt;

    public Wein(int id, String reebsorte, String qualitaetsbezeichnung, boolean dac, Weinart weinart, String jahrgang, String land, String weingut, String ort, String umgebung, double preis, int bestand, double liter, float alkoholgehalt) {
        this.id = id;
        this.reebsorte = reebsorte;
        this.qualitaetsbezeichnung = qualitaetsbezeichnung;
        this.dac = dac;
        this.weinart = weinart;
        this.jahrgang = jahrgang;
        this.land = land;
        this.weingut = weingut;
        this.ort = ort;
        this.umgebung = umgebung;
        this.preis = preis;
        this.bestand = bestand;
        this.liter = liter;
        this.alkoholgehalt = alkoholgehalt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wein wein = (Wein) o;
        return dac == wein.dac &&
                Double.compare(wein.preis, preis) == 0 &&
                bestand == wein.bestand &&
                Double.compare(wein.liter, liter) == 0 &&
                Objects.equals(reebsorte, wein.reebsorte) &&
                Objects.equals(qualitaetsbezeichnung, wein.qualitaetsbezeichnung) &&
                weinart == wein.weinart &&
                Objects.equals(jahrgang, wein.jahrgang) &&
                Objects.equals(weingut, wein.weingut) &&
                Objects.equals(ort, wein.ort) &&
                Objects.equals(umgebung, wein.umgebung);
    }

    @Override
    public int hashCode(){return id;}

    @Override
    public String toString() {
        return "Wein{" +
                "id=" + id +
                ", reebsorte='" + reebsorte + '\'' +
                ", qualitaetsbezeichnung='" + qualitaetsbezeichnung + '\'' +
                ", dac=" + dac +
                ", weinart=" + weinart +
                ", jahrgang='" + jahrgang + '\'' +
                ", land='" + land + '\'' +
                ", weingut='" + weingut + '\'' +
                ", ort='" + ort + '\'' +
                ", umgebung='" + umgebung + '\'' +
                ", preis=" + preis +
                ", bestand=" + bestand +
                ", liter=" + liter +
                '}';
    }

    public String toCSV(){
        return id + ";" + reebsorte + ";" + qualitaetsbezeichnung + ";" + dac + ";" + weinart + ";" + jahrgang + ";" + land + ";" + weingut + ";" + ort + ";" + umgebung +";" + preis + ";" + bestand + ";" + liter;
    }


    public int returnId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReebsorte() {
        return reebsorte;
    }

    public void setReebsorte(String reebsorte) {
        this.reebsorte = reebsorte;
    }

    public String getQualitaetsbezeichnung() {
        return qualitaetsbezeichnung;
    }

    public void setQualitaetsbezeichnung(String qualitaetsbezeichnung) {
        this.qualitaetsbezeichnung = qualitaetsbezeichnung;
    }

    public boolean isDac() {
        return dac;
    }

    public void setDac(boolean dac) {
        this.dac = dac;
    }

    public Weinart getWeinart() {
        return weinart;
    }

    public void setWeinart(Weinart weinart) {
        this.weinart = weinart;
    }

    public String getJahrgang() {
        return jahrgang;
    }

    public void setJahrgang(String jahrgang) {
        this.jahrgang = jahrgang;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getWeingut() {
        return weingut;
    }

    public void setWeingut(String weingut) {
        this.weingut = weingut;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getUmgebung() {
        return umgebung;
    }

    public void setUmgebung(String umgebung) {
        this.umgebung = umgebung;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public int getBestand() {
        return bestand;
    }

    public void setBestand(int bestand) {
        this.bestand = bestand;
    }

    public double getLiter() {
        return liter;
    }

    public void setLiter(double liter) {
        this.liter = liter;
    }
}
