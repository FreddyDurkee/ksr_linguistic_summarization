package data;


import au.com.bytecode.opencsv.CSVReader;
import fuzzyLogic.Attribute;
import lombok.Data;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class FootballerRepository {

    private List<Footballer> footballers = new ArrayList<>();

    public void loadFromCSV(String filePath){

        try {
            FileReader filereader = new FileReader(filePath);
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord = csvReader.readNext(); // header in file to trash

            while ((nextRecord = csvReader.readNext()) != null) {
                footballers.add(new Footballer(
                        Integer.valueOf(nextRecord[0]),
                        nextRecord[1],
                        Integer.valueOf(nextRecord[2]),
                        Integer.valueOf(nextRecord[3]),
                        Integer.valueOf(nextRecord[4]),
                        Double.valueOf(nextRecord[5]),
                        Double.valueOf(nextRecord[6]),
                        Integer.valueOf(nextRecord[7]),
                        Integer.valueOf(nextRecord[8]),
                        Integer.valueOf(nextRecord[9]),
                        Integer.valueOf(nextRecord[10]),
                        Integer.valueOf(nextRecord[11])
                ));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadFromList(List<Footballer> footballers) {
        this.footballers = footballers;
    }

    private List<Double> getAllAges(){
        return footballers.stream().map(v -> v.getAge()).collect(Collectors.toList());
    }

    private List<Double> getAllPotentials(){
        return footballers.stream().map(v -> v.getPotential()).collect(Collectors.toList());
    }

    private List<Double> getAllValues(){
        return footballers.stream().map(v -> v.getValue()).collect(Collectors.toList());
    }

    private List<Double> getAllHeights(){
        return footballers.stream().map(v -> v.getHeight()).collect(Collectors.toList());
    }

    private List<Double> getAllWeights(){
        return footballers.stream().map(v -> v.getWeight()).collect(Collectors.toList());
    }

    private List<Double> getAllSpeeds(){
        return footballers.stream().map(v -> v.getSpeed()).collect(Collectors.toList());
    }

    private List<Double> getAllStaminas(){
        return footballers.stream().map(v -> v.getStamina()).collect(Collectors.toList());
    }

    private List<Double> getAllStrengths(){
        return footballers.stream().map(v -> v.getStrength()).collect(Collectors.toList());
    }

    private List<Double> getAllBalances(){
        return footballers.stream().map(v -> v.getBalance()).collect(Collectors.toList());
    }
    private List<Double> getAllAgilities(){
        return footballers.stream().map(v -> v.getAgility()).collect(Collectors.toList());
    }

    public List<Double> get(Attribute attribute) {
        switch (attribute) {
            case AGE:
                return getAllAges();
            case VALUE:
                return getAllValues();
            case HEIGHT:
                return getAllHeights();
            case WEIGHT:
                return getAllWeights();
            case POTENTIAL:
                return getAllPotentials();
            default:
                throw new IllegalArgumentException("Unknown Attribute type.");
        }
    }
}
