package flight_mgr;

import sun.util.resources.Bundles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class view extends JFrame {
    /**
     * Declaration of model and controller objects
     */
    private model m;
	private controller c;
    /**
     * Declaration of used JPanels
     */
	private JPanel select_country;
	private JPanel select_airport;
	private JPanel select_flight;
    /**
     * Declaration of Placeholder-container
     */
	private Container c1;
	private Container c2;
	private Container c3;
    /**
     * Declaration of used JLabels
     */
	private JLabel country_label;
	private JLabel country_dep_label;
	private JLabel country_ariv_label;

	private JLabel airport_label;
	private JLabel airport_dep_label;
	private JLabel airport_ariv_label;

	private JLabel flight_label;
    /**
     * Declaration of used Dropdowns
     */
	private JComboBox<Object> select_dep_country;
	private JComboBox<Object> select_ariv_country;

	private JComboBox<Object> select_dep_airport;
	private JComboBox<Object> select_ariv_airport;

	private JComboBox<Object> select_flightnr;
    /**
     * Declaration of used Database Streams
     */
	private Object[] countrys;
	private Object[] airports;
	private Object[] flights;
    /**
     * Declaration of used Submit Buttons
     */
	private JButton submit_country;
    private JButton submit_airport;
    private JButton submit_flight;

    /**
     * Constructor of view
     *
     * @param m model
     * @param c controller
     */
	public view(model m, controller c) {
		this.m = m;
		this.c = c;

        /**
         * Initialisation of Placeholder-containers
         */
		this.c1 = new Container();
		this.c2 = new Container();
        this.c3 = new Container();

        /**
         * JPanel for country selection
         */
        this.select_country = new JPanel();
        // GridLayout chosen for select_flight
		this.select_country.setLayout( new GridLayout(3,3,10,0) );
		// Labels for Country Selection
		this.country_label = new JLabel("Bitte wählen Sie ihr gewünschtes Abflug- und Zielland aus.");
        this.country_dep_label = new JLabel("Abflugland");
        this.country_ariv_label = new JLabel("Zielland");
        // Dropdown for Country Selection
        this.select_dep_country = new JComboBox<>(this.countrys);
        this.select_ariv_country = new JComboBox<>(this.countrys);
        this.submit_country = new JButton("Submit");

        this.select_country.add(this.c1);
        this.select_country.add(this.country_label);
        this.select_country.add(this.c2);
        this.select_country.add(this.country_dep_label);
        this.select_country.add(this.country_ariv_label);
        this.select_country.add(this.c3);
        this.select_country.add(this.select_dep_country);
        this.select_country.add(this.select_ariv_country);
        this.select_country.add(this.submit_country);

        /**
         * JPanel for airport selection
         */
        this.select_airport = new JPanel();
        // GridLayout chosen for select_flight
        this.select_airport.setLayout( new GridLayout(3,3,10,0) );
        // Labels for Airport Selection
		this.airport_label = new JLabel("Bitte wählen Sie ihren gewünschten Abflug- und Zielflughafen aus.");
        this.airport_dep_label = new JLabel("Abflughafen");
        this.airport_ariv_label = new JLabel("Zielflughafen");
        // Dropdown for Airport Selection
        this.select_dep_airport = new JComboBox<>(this.airports);
        this.select_ariv_airport = new JComboBox<>(this.airports);
        this.submit_airport = new JButton("Submit");

        this.select_airport.add(this.c1);
        this.select_airport.add(this.airport_label);
        this.select_airport.add(this.c2);
        this.select_airport.add(this.airport_dep_label);
        this.select_airport.add(this.airport_ariv_label);
        this.select_airport.add(this.c3);
        this.select_airport.add(this.select_dep_airport);
        this.select_airport.add(this.select_ariv_airport);
        this.select_airport.add(this.submit_airport);

        /**
         * JPanel for flight selection
         */
        this.select_flight = new JPanel();
        // GridLayout chosen for select_flight
        this.select_flight.setLayout( new GridLayout(2,2,10,0) );
        // Labels for Flight Selection
		this.flight_label = new JLabel("Bitte wählen Sie ihren gewünschten Flug aus");
		// Dropdown for Flight Selection
        this.select_flightnr = new JComboBox<>(this.flight);
        this.submit_flight = new JButton("Submit");

        this.select_flight.add(this.flight_label);
        this.select_flight.add(this.c1);
        this.select_flight.add(this.select_flightnr);
        this.select_flight.add(this.submit_flight);
	}

    /**
     *
     */
	public void initialize_countrys(){
        this.countrys = this.m.getCountrys();
    }

    /**
     *
     * @param dep departure country
     * @param ariv arival country
     */
    public void initialize_airports(String dep, String ariv){
        this.airports = this.m.getAirports(dep,ariv);
    }

    /**
     *
     * @param dep departure airport
     * @param ariv arival airport
     */
    public void initialize_flights(String dep, String ariv){
        this.flights = this.m.getFlights(dep,ariv);
    }



}
