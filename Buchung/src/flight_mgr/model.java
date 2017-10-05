package flight_mgr;

public class model {
	//Country String Array
	private String[] countrys = {"","",""};
	//Airport String Arrays
	private String[] dep_airports = {"","",""};
	private String[] ariv_airports = {"","",""};
	//Flight String Array
	private String[] flightnrs = {"","",""};

	/**
	 * gets countrys from DB_Connection over controller
	 *
	 * @param countrys
	 */
	public void setCountrys(String[] countrys) {
		this.countrys = countrys;
		//System.out.println(countrys[0]);
	}

	/**
	 * gets airports from DB_Connection over controller
	 *
	 * @param dep
	 * @param ariv
	 */
	public void setAirports(String[] dep, String[] ariv) {
		this.dep_airports = dep;
		this.ariv_airports = ariv;
	}

	/**
	 * gets flights from DB_Connection over controller
	 *
	 * @param flightnrs
	 */
	public void setFlights(String[] flightnrs) {
		this.flightnrs = flightnrs;
	}

	/**
	 * Returns Countries array for JComboBoxes
	 *
	 * @return
	 */
	public String[] getCountrys() {
		return this.countrys;
	}

	/**
	 * Returns departure airports array for JComboBoxes
	 *
	 * @return
	 */
	public String[] get_dep_Airports() {
		return this.dep_airports;
	}

	/**
	 * Returns arival airports array for JComboBoxes
	 *
	 * @return
	 */
	public String[] get_ariv_Airports() {
		return this.ariv_airports;
	}

	/**
	 * Returns flights array for JComboBoxes
	 *
	 * @return
	 */
	public String[] getFlights() {
		return this.flightnrs;
	}
}
