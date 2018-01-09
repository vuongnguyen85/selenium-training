package Flights;

public class TestData {

        public class TripDetails {
        public static final String originCity = "london";
        public static final String destinationCity = "hong kong";
        public static final String departureDate = "07/07/2018";
        public static final String returnDate = "22/07/2018";
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
        public static final String cssOrigin = "#js-origin-input";
        public static final String cssDestination = "#js-destination-input";
        public static final String cssDepartureDate = "#js-depart-input";
    }
}

