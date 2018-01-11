package Flights.Util;

public class TestData {

        public class TripDetails {
        public static final String originCity = "london";
        public static final String destinationCity = "venice";
        public static final String departureDate = "06/04/2018";
        public static final String returnDate = "09/04/2018";
        public static final int noOfAdults = 2; // can't be 0, default selects 1
        public static final int noOfChildrens = 0;
        }

    public class ExpediaData {
            public static final String xPathfirstOptionDestination = "(.//*[@id='aria-option-0'])[1]/parent::li";
            public static final String xPathfirstOptionDeparture = ".//*[@id='aria-option-0']/parent::li";
            public static final String cssFlightTab = "#tab-flight-tab-hp";
            public static final String cssDepatureDate = "#flight-departing-hp-flight";
            public static final String cssReturnDate = "#flight-returning-hp-flight";
            public static final String cssOrigin = "#flight-origin-hp-flight";
            public static final String cssDestination = "#flight-destination-hp-flight";
            public static final String cssCloseDates = "[class='datepicker-close-btn close btn-text']";
            public static final String cssSubmit = "[class='btn-primary btn-action gcw-submit']";
            public static final String cssEmiratesFilter = "#airlineRowContainer_EK";
    }

    public class SkyScannerData {
        public static final String SSOrigin = "#js-origin-input";
        public static final String SSDestination = "#js-destination-input";
        public static final String SSDepartureDate = "#js-depart-input";
        public static final String SSTravellers = "#js-trad-cabin-class-travellers-toggle";
        public static final String SSIncrementAdults = "[class='increment adults']";
        public static final String SSNextArrowOnReturnCalendar = "(.//*[@class='calendar-info-bar datepicker_clearfix'])[2]/button[2]";

    }
}

