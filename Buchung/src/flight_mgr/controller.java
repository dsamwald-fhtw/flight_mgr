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
		this.setCountries();
		this.v = new view(this.m, this);

	}

	/**
	 * actionPerformed method to react if submit was clicked
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		if (this.v.isButtonSubmitCountry(e)){
			this.setAirports(this.v.get_dep_Country(),this.v.get_ariv_Country());
			this.v.airports();
		}
		if (this.v.isButtonSubmitAirport(e)){
			this.setFlight(this.v.get_dep_Airport(),this.v.get_ariv_Airport());
			this.v.flights();
		}
		if (this.v.isButtonSubmitFlight(e)){
			this.v.passenger();
		}
		if (this.v.isButtonSavePassenger(e)){
			this.db.addPassenger(this.v.get_vname(), this.v.get_nname(), this.v.get_Flight(), this.v.get_rownr(), this.v.get_seatpos());
			this.v.dispose();
		}
		if (this.v.isButtonAddPassenger(e)){
			this.db.addPassenger(this.v.get_vname(), this.v.get_nname(), this.v.get_Flight(), this.v.get_rownr(), this.v.get_seatpos());
		}
		if (this.v.isButtonExitPassenger(e)){
			this.v.dispose();
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
		this.m.setFlights(this.db.get_Flights(dep, ariv));
	}
}
