package flight_mgr;

import java.awt.event.*;

public class controller implements ActionListener {
	
	private model m;
	private view v;
	
	public controller() {
		this.m = new model();
		this.v = new view(this.m, this);
	}
	
}
