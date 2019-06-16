package data;

import com.opencsv.CSVReader;
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
                        Double.valueOf(nextRecord[2]),
                        Double.valueOf(nextRecord[3]),
                        Double.valueOf(nextRecord[4]),
                        Double.valueOf(nextRecord[5]),
                        Double.valueOf(nextRecord[6]),
                        Double.valueOf(nextRecord[7]),
                        Double.valueOf(nextRecord[8]),
                        Double.valueOf(nextRecord[9]),
                        Double.valueOf(nextRecord[10]),
                        Double.valueOf(nextRecord[11])
                ));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Double> getAllAges(){
        return footballers.stream().map(v -> v.getAge()).collect(Collectors.toList());
    }

    public List<Double> getAllPotentials(){
        return footballers.stream().map(v -> v.getPotential()).collect(Collectors.toList());
    }

    public List<Double> getAllValues(){
        return footballers.stream().map(v -> v.getValue()).collect(Collectors.toList());
    }

    public List<Double> getAllHeights(){
        return footballers.stream().map(v -> v.getHeight()).collect(Collectors.toList());
    }

    public List<Double> getAllWeights(){
        return footballers.stream().map(v -> v.getWeight()).collect(Collectors.toList());
    }

    public List<Double> getAllSpeeds(){
        return footballers.stream().map(v -> v.getSpeed()).collect(Collectors.toList());
    }

    public List<Double> getAllStaminas(){
        return footballers.stream().map(v -> v.getStamina()).collect(Collectors.toList());
    }

    public List<Double> getAllStrengths(){
        return footballers.stream().map(v -> v.getStrength()).collect(Collectors.toList());
    }

    public List<Double> getAllBalances(){
        return footballers.stream().map(v -> v.getBalance()).collect(Collectors.toList());
    }
    public List<Double> getAllAgilities(){
        return footballers.stream().map(v -> v.getAgility()).collect(Collectors.toList());
    }

}
