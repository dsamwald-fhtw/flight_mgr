package flight_mgr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class view extends JFrame {
	private model m;
	private controller c;
	
	public view(model m, controller c) {
		this.m = m;
		this.c = c;
	}
}
