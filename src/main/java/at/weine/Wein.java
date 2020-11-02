package at.weine;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.lang.reflect.WildcardType;
import java.util.Objects;

public class Wein extends VBox {

    private final double WIDTH = 400d;
    private final double HEIGHT = 600d;

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

    private Image image;

    public Wein(int id, String reebsorte, String qualitaetsbezeichnung, boolean dac, Weinart weinart, String jahrgang, String land, String weingut, String ort, String umgebung, double preis, int bestand, double liter, float alkoholgehalt, Image image) {
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
        this.image = image;
        super.setMaxWidth(WIDTH);
        super.setMaxHeight(HEIGHT);

        createGUI();
    }

    public void createGUI(){
        //super.setPadding(new Insets(2));
        super.setStyle("-fx-background-color: lightgrey;");

        createHeader();
        createImage();
        createBestandGUI();
    }

    private void createHeader(){
        HBox hbox = new HBox();
        hbox.setPrefHeight(60d);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPrefWidth(WIDTH);
        hbox.setMaxWidth(WIDTH);
        hbox.setSpacing(2d);

        double width = WIDTH/4;
        String cssID = "header";
        TextField reebsorte = makeTextField(this.reebsorte, width, cssID);
        TextField quali = makeTextField(qualitaetsbezeichnung, width, cssID);
        TextField art = makeTextField(weinart.toString(), width+20, cssID);
        TextField jahrgang = makeTextField(this.jahrgang, width-20, cssID);

        hbox.getChildren().addAll(reebsorte, quali, art, jahrgang);
        super.getChildren().add(hbox);
    }

    private void createImage(){
        HBox hbox = new HBox();
        hbox.setMaxWidth(WIDTH);
        hbox.setAlignment(Pos.CENTER);
        hbox.setMaxHeight(300d);
        ImageView imgv = new ImageView(image);
        imgv.setFitWidth(WIDTH);
        imgv.setFitHeight(300d);
        hbox.getChildren().add(imgv);
        super.getChildren().add(hbox);
    }

    private TextField makeTextField(String text, double width, String id){
        TextField field = new TextField(text);
        field.setMaxWidth(width);
        field.setBackground(Background.EMPTY);
        field.setEditable(false);
        field.setId(id);
        return field;
    }

    private void createBestandGUI(){
        HBox overall = new HBox();
        overall.setPrefWidth(WIDTH);
        overall.setPrefHeight(40d);
        overall.setPadding(new Insets(2));
        //overall.setAlignment(Pos.);

        HBox rightbox = new HBox();
        rightbox.setAlignment(Pos.CENTER);
        rightbox.setPrefWidth(WIDTH/2);
        rightbox.setSpacing(5d);

        HBox leftbox = new HBox();
        leftbox.setAlignment(Pos.CENTER);
        leftbox.setPrefWidth(WIDTH/2);


        TextField differenz = new TextField("");
        differenz.setPrefWidth(50d);

        TextField field = makeTextField(this.bestand + " Flaschen", WIDTH/2, "aktuellerBestand");
        field.setId("bestand");

        Button plus = new Button("+");
        plus.setId("plus");

        overall.setSpacing(5d);
        Button minus = new Button("-");
        minus.setId("minus");

        minus.setOnAction(actionEvent -> {
            int zahl = 0;
            try {
                zahl = differenz.getText().trim().isEmpty() ? -1 : Integer.parseInt(differenz.getText().trim()) * -1;
                differenz.clear();
            }catch (NumberFormatException exception){
                differenz.clear();
            }
            changeBestand(zahl);

            field.setText(bestand + " Flaschen");
        });



        plus.setOnAction(actionEvent -> {
            int zahl = 0;
            try {
                zahl = differenz.getText().trim().isEmpty() ? 1 : Integer.parseInt(differenz.getText().trim());
                differenz.clear();
            }catch (NumberFormatException exception){
                differenz.clear();
            }
            changeBestand(zahl);

            field.setText(bestand + " Flaschen");
        });
        rightbox.getChildren().addAll(minus,plus,differenz);
        leftbox.getChildren().add(field);
        overall.getChildren().addAll(rightbox, leftbox);
        super.getChildren().add(overall);
    }

    @Override
    public String toString() {
        return "Wein{" +
                "WIDTH=" + WIDTH +
                ", HEIGHT=" + HEIGHT +
                ", id=" + id +
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
                ", alkoholgehalt=" + alkoholgehalt +
                ", image=" + image +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wein wein = (Wein) o;
        return dac == wein.dac &&
                Double.compare(wein.preis, preis) == 0 &&
                Double.compare(wein.liter, liter) == 0 &&
                Float.compare(wein.alkoholgehalt, alkoholgehalt) == 0 &&
                Objects.equals(reebsorte, wein.reebsorte) &&
                Objects.equals(qualitaetsbezeichnung, wein.qualitaetsbezeichnung) &&
                weinart == wein.weinart &&
                Objects.equals(jahrgang, wein.jahrgang) &&
                Objects.equals(land, wein.land) &&
                Objects.equals(weingut, wein.weingut) &&
                Objects.equals(ort, wein.ort) &&
                Objects.equals(umgebung, wein.umgebung);
    }


    public String toCSV(){
        return id + ";" + reebsorte + ";" + qualitaetsbezeichnung + ";" + dac + ";" + weinart + ";" + jahrgang + ";" + land + ";" + weingut + ";" + ort + ";" + umgebung +";" + preis + ";" + bestand + ";" + liter + ";" + alkoholgehalt + ";" + image.getUrl();
    }


    public void changeBestand(int differenz){
        if(bestand + differenz >= 0)
            bestand += differenz;
        else
            bestand = 0;
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
