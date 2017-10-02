package flight_mgr;

import java.awt.event.*;

public class controller implements ActionListener {
	
	private model m;
	private view v;
	
	public controller() {
		this.m = new model();
		this.v = new view(this.m, this);
	}


	public void actionPerformed(ActionEvent e) {
		if (this.v.isButtonSubmitCountry(e)) this.m.setCountrys(this.v.get_dep_country(),this.v.get_ariv_country());
		if (this.v.isButtonSubmitAirport(e)) this.m.setAirports(this.v.get_dep_airport(),this.v.get_ariv_airport());
		if (this.v.isButtonSubmitFlight(e)) this.m.setFlight(this.v.getFlight());
	}
	
}
