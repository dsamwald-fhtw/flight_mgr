package flight_mgr;

public class model {
	public void setCountrys(String dep, String ariv) {

	}

	public void setAirports(String dep, String ariv) {

	}

	public void setFlight(String flightnr) {

	}

	public Object getCountrys() {

	}

	public Object getAirports() {

	}

	public Object getFlights() {

	}


	public String[] get_available_Countrys() {
		String[] country = {"Austria", "USA", "Germany", "Netherlands", "Australia"};
		return country;
	}
	
	private String[] get_available_Airports_depature(String dep_country, String ariv_country) {
		String[] airports = {"VIE", "JFK", "ORD", "DEN", "IAD"};
		return airports;
	}
	
	private String[] get_available_Airports_arival(String dep_airport, String ariv_country) {
		String[] airports = {"VIE", "JFK", "ORD", "DEN", "IAD"};
		return airports;
	}
	
	private String[] get_available_Flights(String dep_airport, String ariv_airport) {
		String[] flights = {"1234", "4321", "ABCD", "DCBA", "0987"};
		return flights;
	}
}
