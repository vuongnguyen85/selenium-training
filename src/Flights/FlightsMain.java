package Flights;

import Flights.Skyscanner.Skyscanner;
import Flights.Skyscanner.SkyscannerComponents;
import java.text.ParseException;


public class FlightsMain {
    public static void main(String[] args) throws InterruptedException, ParseException{
        Skyscanner skyscanner = new Skyscanner();
        SkyscannerComponents SSComponent = new SkyscannerComponents();

        //-----------------
        //run on Skyscanner
        skyscanner.runOnSkyscanner();

        //Additional filters on Skyscanner
        //SSComponent.clearAllAirlineFilters();
        //SSComponent.filterByAirline("Emirates");
        //SSComponent.filterByAirline("Qatar");

        //-----------------
        //run on Expedia


        //-----------------
        //run on Ryanair

    }
}
