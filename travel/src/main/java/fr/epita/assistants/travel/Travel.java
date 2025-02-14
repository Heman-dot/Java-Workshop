package fr.epita.assistants.travel;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Travel {
    public static void travelTo(Country source, Country destination) {
        if (!source.travelTimes.containsKey(destination.countryName)) {
            System.out.println("No travel route available between these countries.");
            return;
        }

        int travelTime = source.travelTimes.get(destination.countryName);

        ZonedDateTime departureTime = ZonedDateTime.now(source.countryZone);
        ZonedDateTime arrivalTime = departureTime.plusHours(travelTime).withZoneSameInstant(destination.countryZone);

        DateTimeFormatter formatter = DateTimeFormatter.RFC_1123_DATE_TIME;

        System.out.println("Boarding in " + source.countryName + ", local date and time is: " + departureTime.format(formatter));
        System.out.println("Landing in " + destination.countryName + ", local date and time on arrival will be: " + arrivalTime.format(formatter));
    }
}