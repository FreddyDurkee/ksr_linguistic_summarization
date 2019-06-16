package data;

import com.opencsv.CSVReader;
import lombok.Data;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

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

}
