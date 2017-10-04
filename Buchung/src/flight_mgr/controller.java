package flight_mgr;

import java.awt.event.*;

public class controller implements ActionListener {

	private model m;
	private view v;
	private DB_Connection db;

	/**
	 * Constructor of controller
	 */
	public controller() {
		//Creates DB_Connection, model and view class
		this.db = new DB_Connection();
		this.m = new model();
		this.v = new view(this.m, this);
		//sets countries for the first time
		this.setCountries();
	}

	/**
	 * actionPerformed method to react if submit was clicked
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		if (this.v.isButtonSubmitCountry(e)){

		}
		if (this.v.isButtonSubmitAirport(e)){

		}
		if (this.v.isButtonSubmitFlight(e)){

		}
	}

	/**
	 * Sets countries in model
	 */
	private void setCountries(){
		this.m.setCountrys(this.db.getCountrys());
	}

	/**
	 * Sets airports in model in dependence of departure- and arival country
	 *
	 * @param dep
	 * @param ariv
	 */
	private void setAirports(String dep, String ariv){
		this.m.setAirports(this.db.getAirports(dep),this.db.getAirports(ariv));
	}

	/**
	 * Sets flights in model in dependence of the airports
	 *
	 * @param dep
	 * @param ariv
	 */
	private void setFlight(String dep, String ariv){
		this.m.setFlights(this.db.getFlights(dep, ariv));
	}
}
