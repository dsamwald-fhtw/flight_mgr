package flight_mgr;

import javax.swing.*;

public class mgr {
	
	public static void main(String[] args) {		
		String[] dbms_login = user_pass();
		String departure_country = departure_country(available_Countrys());
		String arival_country = arival_country(available_Countrys());
		String depature_airport = departure_airport_select(available_Airports_depature(departure_country, arival_country));
		String arival_airport = arival_airport_select(available_Airports_arival(depature_airport));
		
	}
	
	/**
	 * @author dsamwald
	 * @version 2017-09-30
	 * 
	 * Fragt das passwort und den usernamen vom nutzer ab
	 */
	public static String[] user_pass() {
		
		JLabel label_login = new JLabel("Username:");
		JTextField login = new JTextField();
		 
		JLabel label_password = new JLabel("Password:");
		JPasswordField password = new JPasswordField();

		Object[] array = { label_login,  login, label_password, password };
		 
		int res = JOptionPane.showConfirmDialog(null, array, "Login", 
		        JOptionPane.OK_CANCEL_OPTION,
		        JOptionPane.PLAIN_MESSAGE);
		 
		if (res == JOptionPane.OK_OPTION) {
		    String[] userpass = {login.getText().trim() ,new String(password.getPassword())};
			return userpass;
		}else {
			return null;
		}
	}
	
	/**
	 * @author dsamwald
	 * @version 30.09.2017
	 * 
	 * Abflugland wird abgefragt
	 */
	public static String departure_country(String[] countrys) {
		String input = (String) JOptionPane.showInputDialog(null, "Bitte w�hlen Sie das Abflugland aus.",
		        "Abflugland", JOptionPane.QUESTION_MESSAGE, null, countrys, countrys[1]);
			return input;
	}
	
	/**
	 * @author dsamwald
	 * @version 30.09.2017
	 * 
	 * Zielland wird abgefragt
	 */
	public static String arival_country(String[] countrys) {
		String input = (String) JOptionPane.showInputDialog(null, "Bitte w�hlen Sie das Zielland aus.",
		        "Zielland", JOptionPane.QUESTION_MESSAGE, null, countrys, countrys[1]);
			return input;
	}
	
	/**
	 * @author dsamwald
	 * @version 30.09.2017
	 *
	 * Methode zur auswahl des gew�nschten Abflughafens
	 */
	public static String departure_airport_select (String[] airports) {
	    String input = (String) JOptionPane.showInputDialog(null, "Bitte w�hlen Sie den Abflughafen aus.",
	        "Abflughafen", JOptionPane.QUESTION_MESSAGE, null, airports, airports[1]);
		return input;
	}
	
	/**
	 * @author dsamwald
	 * @version 30.09.2017
	 *
	 * Methode zur auswahl des gew�nschten Zielflughafens
	 */
	public static String arival_airport_select (String[] airports) {
	    String input = (String) JOptionPane.showInputDialog(null, "Bitte w�hlen Sie den Zielflughafen aus.",
	        "Zielflughafen", JOptionPane.QUESTION_MESSAGE, null, airports, airports[1]);
		return input;
	}
	
	/**
	 * @author dsamwald
	 * @version 30.09.2017
	 * 
	 * Ruft alle verf�gbaren L�nder aus der DB ab
	 */
	public static String[] available_Countrys() {
		String[] country = {"Austria", "USA", "Germany", "Netherlands", "Australia"};
		return country;
	}
	
	/**
	 * @author dsamwald
	 * @version 30.09.2017
	 *
	 * String Array soll mit den m�glichen flugh�fen aus der DB gef�llt werden
	 */
	private static String[] available_Airports_depature(String dep_country, String ariv_country) {
		String[] airports = {"VIE", "JFK", "ORD", "DEN", "IAD"};
		return airports;
	}
	
	/**
	 * @author dsamwald
	 * @version 30.09.2017
	 *
	 * String Array soll mit den m�glichen flugh�fen gef�llt werden die zum abflug passen
	 */
	private static String[] available_Airports_arival(String dep_airport) {
		String[] airports = {"VIE", "JFK", "ORD", "DEN", "IAD"};
		return airports;
	}
	
	/**
	 * @author dsamwald
	 * @version 30.09.2017
	 *
	 * String Array soll mit den verf�gbaren Fl�gen zwischen Abflughafen und Zielflughafen gef�llt werden
	 */
	private static String[] available_Flights() {
		String[] flights = {"1234", "4321", "ABCD", "DCBA", "0987"};
		return flights;
	}
	
	
	
}
