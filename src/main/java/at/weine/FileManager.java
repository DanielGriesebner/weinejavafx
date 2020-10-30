package at.weine;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class FileManager {


    public static final File WEINE = new File("src/at/weine/model/weine.csv");
    private static FileManager instance = null;

    private List<Wein> weine;
    private int lastIndex;

    private FileManager() {
        try {
            WEINE.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        weine = importWeine();
        if (weine.get(0) != null) {
            lastIndex = weine.get(weine.size() - 1).returnId();
        } else {
            lastIndex = 0;
        }
    }

    public static FileManager getInstance() {
        if (instance == null) {
            instance = new FileManager();
        }
        return instance;
    }

    private List<Wein> importWeine() {
        List<Wein> l = null;
        try {
            l = Files.lines(WEINE.toPath()).map(s -> {
                String[] arr = s.split(";");
                if (arr.length < 14)
                    return null;
                return new Wein(Integer.parseInt(arr[0]), arr[1], arr[3], Boolean.getBoolean(arr[4]), getWeinart(arr[5]), arr[6], arr[7], arr[8], arr[9], arr[10], Double.parseDouble(arr[11]), Integer.parseInt(arr[12]), Double.parseDouble(arr[13]), Float.parseFloat(arr[14]));


            }).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return l;
    }

    private Weinart getWeinart(String weinart){
        switch (weinart.toLowerCase().trim()){
            case "rotwein":
                return Weinart.Rotwein;
            case "weisswein":
                return Weinart.Weisswein;
            case "rosewein":
                return Weinart.Rosewein;
            default:
                return getWeinart(weinart);
        }
    }



    public void exportWeine() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(WEINE))) {
            for (Wein wein : weine) {
                writer.write(wein.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void insertWein(String reebe, String land, String umbgebung, String weingut, String bezeichnung, String art, String jahrgang, double liter, double preis, int bestand) {
      //Wein wein = new Wein(++lastIndex, reebe, land, umbgebung, weingut, bezeichnung, art, jahrgang, liter, preis, bestand);
       //if (weine.contains(wein)) {
            //lastIndex--;
      //} else {
           // weine.add(wein);
        //}
    }

    public void weineToString(){
        weine.forEach(weini -> {
            System.out.println(weini.toCSV());
        });
    }

    public List<Wein> getWeine() {
        return weine;
    }


    public int getLastIndex() {
        return lastIndex;
    }
}
