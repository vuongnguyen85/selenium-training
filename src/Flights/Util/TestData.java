package Flights.Util;

public class TestData {

        public class TripDetails {
        public static final String originCity = "london";
        public static final String destinationCity = "Reykjavik";
        public static final String departureDate = "06/04/2018";
        public static final String returnDate = "09/04/2018";
        public static final int noOfAdults = 2; // can't be 0, default selects 1
        public static final int noOfChildrens = 0;
        }

    public class ExpediaData {
            public static final String firstOptionDestination = "(.//*[@id='aria-option-0'])[1]/parent::li";
            public static final String firstOptionDeparture = ".//*[@id='aria-option-0']/parent::li";
            public static final String FlightTab = "#tab-flight-tab-hp";
            public static final String DepatureDate = "#flight-departing-hp-flight";
            public static final String ReturnDate = "#flight-returning-hp-flight";
            public static final String Origin = "#flight-origin-hp-flight";
            public static final String Destination = "#flight-destination-hp-flight";
            public static final String CloseCalendar = "[class='datepicker-close-btn close btn-text']";
            public static final String SubmitButton = "[class='btn-primary btn-action gcw-submit']";
            public static final String EmiratesFilter = "#airlineRowContainer_EK";
    }

    public class SkyScannerData {
        public static final String OriginCityField = "#js-origin-input";
        public static final String DestinationCityField = "#js-destination-input";
        public static final String DepartureDateField = "#js-depart-input";
        public static final String TravellersField = "#js-trad-cabin-class-travellers-toggle";
        public static final String IncrementAdultsButton = "[class='increment adults']";
        public static final String NextArrowOnReturnCalendar = "(.//*[@class='calendar-info-bar datepicker_clearfix'])[2]/button[2]";
        public static final String SearchButton = "[class='fss-bpk-button fss-bpk-button--large js-search-button']";
    }
}

