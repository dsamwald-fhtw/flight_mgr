package flight_mgr;

import javax.swing.*;

public class mgr {
	public static void main(String[] args) {
		departure_select(available_Airports_depature());
		arival_select(available_Airports_arival());
	}
	
	public static String departure_select (String[] airports) {
	    String input = (String) JOptionPane.showInputDialog(null, "Bitte w�hlen Sie den Abflughafen aus.",
	        "Abflughafen", JOptionPane.QUESTION_MESSAGE, null, airports, airports[1]);
		return input;
	}
	
	public static String arival_select (String[] airports) {
	    String input = (String) JOptionPane.showInputDialog(null, "Bitte w�hlen Sie den Zielflughafen aus.",
	        "Zielflughafen", JOptionPane.QUESTION_MESSAGE, null, airports, airports[1]);
		return input;
	}
	
	private static String[] available_Airports_depature() {
		/**
		 * String Array soll mit den m�glichen flugh�fen aus der DB gef�llt werden
		 */
		String[] airports = {"VIE", "JFK", "ORD", "DEN", "IAD"};
		return airports;
	}
	
	private static String[] available_Airports_arival() {
		/**
		 * String Array soll mit den m�glichen flugh�fen gef�llt werden die zum abflug passen
		 */
		String[] airports = {"VIE", "JFK", "ORD", "DEN", "IAD"};
		return airports;
	}
	
	private static String[] available_Flights() {
		/**
		 * String Array soll mit den verf�gbaren Fl�gen zwischen Abflughafen und Zielflughafen gef�llt werden
		 */
	}
}
