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

		this.initialize_countrys();

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
		// Labels for country selection
		this.country_label = new JLabel("Bitte wählen Sie ihr gewünschtes Abflug- und Zielland aus.");
        this.country_dep_label = new JLabel("Abflugland");
        this.country_ariv_label = new JLabel("Zielland");
        // Dropdown for country selection
        this.select_dep_country = new JComboBox<>(this.countrys);
        this.select_ariv_country = new JComboBox<>(this.countrys);
        this.submit_country = new JButton("Submit");
        // Components added to JPanel for country selection
        this.select_country.add(this.c1);
        this.select_country.add(this.country_label);
        this.select_country.add(this.c2);
        this.select_country.add(this.country_dep_label);
        this.select_country.add(this.country_ariv_label);
        this.select_country.add(this.c3);
        this.select_country.add(this.select_dep_country);
        this.select_country.add(this.select_ariv_country);
        this.select_country.add(this.submit_country);
        // ActionListener added to submit button
        this.submit_country.addActionListener(this.c);

        /**
         * JPanel for airport selection
         */
        this.select_airport = new JPanel();
        // GridLayout chosen for select_flight
        this.select_airport.setLayout( new GridLayout(3,3,10,0) );
        // Labels for airport selection
		this.airport_label = new JLabel("Bitte wählen Sie ihren gewünschten Abflug- und Zielflughafen aus.");
        this.airport_dep_label = new JLabel("Abflughafen");
        this.airport_ariv_label = new JLabel("Zielflughafen");
        // Dropdown for airport selection
        this.select_dep_airport = new JComboBox<>(this.airports);
        this.select_ariv_airport = new JComboBox<>(this.airports);
        this.submit_airport = new JButton("Submit");
        // Components added to JPanel for airport selection
        this.select_airport.add(this.c1);
        this.select_airport.add(this.airport_label);
        this.select_airport.add(this.c2);
        this.select_airport.add(this.airport_dep_label);
        this.select_airport.add(this.airport_ariv_label);
        this.select_airport.add(this.c3);
        this.select_airport.add(this.select_dep_airport);
        this.select_airport.add(this.select_ariv_airport);
        this.select_airport.add(this.submit_airport);
        // ActionLister added to submit button
        this.submit_airport.addActionListener(this.c);

        /**
         * JPanel for flight selection
         */
        this.select_flight = new JPanel();
        // GridLayout chosen for select_flight
        this.select_flight.setLayout( new GridLayout(2,2,10,0) );
        // Labels for flight selection
		this.flight_label = new JLabel("Bitte wählen Sie ihren gewünschten Flug aus");
		// Dropdown for flight selection
        this.select_flightnr = new JComboBox<>(this.flights);
        this.submit_flight = new JButton("Submit");
        // Components added to JPanel for flight selection
        this.select_flight.add(this.flight_label);
        this.select_flight.add(this.c1);
        this.select_flight.add(this.select_flightnr);
        this.select_flight.add(this.submit_flight);
        // ActionLister added to submit button
        this.submit_flight.addActionListener(this.c);
	}


    /**
     * Check if button submit from country is pressed
     *
     * @param e
     * @return
     */
    public boolean isButtonSubmitCountry(ActionEvent e) {
        if (e.getSource() == this.submit_country) return true;
        return false;
    }

    /**
     * Check if button submit from airport is pressed
     *
     * @param e
     * @return
     */
    public boolean isButtonSubmitAirport(ActionEvent e) {
        if (e.getSource() == this.submit_airport) return true;
        return false;
    }

    /**
     * Check if button submit from flight is pressed
     *
     * @param e
     * @return
     */
    public boolean isButtonSubmitFlight(ActionEvent e) {
        if (e.getSource() == this.submit_flight) return true;
        return false;
    }


    /**
     * Initialization of countrys
     */
	public void initialize_countrys() {
        this.countrys = this.m.getCountrys();
    }

    /**
     *Initialization of airports
     */
    public void initialize_airports() {
        this.airports = this.m.getAirports();
    }

    /**
     *Initialization of flights
     */
    public void initialize_flights() {
        this.flights = this.m.getFlights();
    }

    /**
     * Getter Method
     *
     * @return
     */
    public String get_dep_country() {
        return (String) this.select_dep_country.getSelectedItem();
    }

    /**
     * Getter Method
     *
     * @return
     */
    public String get_ariv_country() {
        return (String) this.select_ariv_country.getSelectedItem();
    }

    /**
     * Getter Method
     *
     * @return
     */
    public String get_dep_airport() {
        return (String) this.select_dep_airport.getSelectedItem();
    }

    /**
     * Getter Method
     *
     * @return
     */
    public String get_ariv_airport() {
        return (String) this.select_ariv_airport.getSelectedItem();
    }

    /**
     * Getter Method
     *
     * @return
     */
    public String getFlight() {
        return (String) this.select_flightnr.getSelectedItem();
    }


}
