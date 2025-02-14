package fr.epita.assistants.travel;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class Country {
    public String countryName;
    public ZoneId countryZone;
    public Map<String, Integer> travelTimes;

    public Country(String countryName, String countryZone, String inputFilePath) {
        this.countryName = countryName;
        this.countryZone = ZoneId.of(countryZone);
        this.travelTimes = initTravelTimes(inputFilePath);
    }

    public Map<String, Integer> initTravelTimes(String inputFilePath) {
        Map<String, Integer> travelMap = new HashMap<>();

        if (!Files.exists(Paths.get(inputFilePath))) {
            return travelMap;
        }

        try (CSVReader reader = new CSVReader(new FileReader(inputFilePath))) {
            for (String[] line : reader.readAll()) {
                if (line.length == 3) {
                    String countryA = line[0].trim();
                    String countryB = line[1].trim();
                    String timeStr = line[2].trim();
                    if(!timeStr.matches("\\d+")){
                        continue;
                    }
                    int time = Integer.parseInt(timeStr);

                    if (countryA.equalsIgnoreCase(this.countryName)) {
                        travelMap.put(countryB, time);
                    } else if (countryB.equalsIgnoreCase(this.countryName)) {
                        travelMap.put(countryA, time);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return travelMap;
    }
}


