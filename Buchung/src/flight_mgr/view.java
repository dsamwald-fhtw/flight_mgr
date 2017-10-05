package flight_mgr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class view extends JFrame {
    /**
     * Declaration of model and controller objects
     */
    private model m;
    private controller c;
    /**
     * Declaration of used JPanels
     */
    private JPanel content_Panel;
    /**
     * Declaration of Placeholder-container
     */
    private Container c1 = new Container();
    private Container c2 = new Container();
    private Container c3 = new Container();

    /**
     * Declaration of used Dropdowns
     */
    private JComboBox select_dep_country;
    private JComboBox select_ariv_country;

    private JComboBox select_dep_airport;
    private JComboBox select_ariv_airport;

    private JComboBox select_flightnr;
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

        this.countrys();
        this.frame_config();
    }

    /**
     * Panel for Country selection
     */
    public void countrys() {
        /**
         * JPanel for country selection
         */
        this.content_Panel = new JPanel();
        // GridLayout chosen for select_flight
        this.content_Panel.setLayout(new GridLayout(3, 3, 10, 0));
        // Labels for country selection
        /*
        Declaration of used JLabels
        */
        JLabel country_label = new JLabel("Bitte wählen Sie ihr gewünschtes Abflug- und Zielland aus.");
        JLabel country_dep_label = new JLabel("Abflugland");
        JLabel country_ariv_label = new JLabel("Zielland");
        // Dropdown for country selection
        this.select_dep_country = new JComboBox(this.m.getCountrys());
        this.select_ariv_country = new JComboBox(this.m.getCountrys());
        this.submit_country = new JButton("Submit");
        // Components added to JPanel for country selection
        this.content_Panel.add(this.c1);
        this.content_Panel.add(country_label);
        this.content_Panel.add(this.c2);
        this.content_Panel.add(country_dep_label);
        this.content_Panel.add(country_ariv_label);
        this.content_Panel.add(this.c3);
        this.content_Panel.add(this.select_dep_country);
        this.content_Panel.add(this.select_ariv_country);
        this.content_Panel.add(this.submit_country);
        // ActionListener added to submit button
        this.submit_country.addActionListener(this.c);
        this.add(content_Panel);
        this.setVisible(true);
    }

    /**
     * Panel for Airport selection
     */
    public void airports() {
        /**
         * JPanel for airport selection
         */
        this.remove(this.content_Panel);
        this.content_Panel = new JPanel();
        // GridLayout chosen for select_flight
        this.content_Panel.setLayout(new GridLayout(3, 3, 10, 0));
        // Labels for airport selection
        JLabel airport_label = new JLabel("Bitte wählen Sie ihren gewünschten Abflug- und Zielflughafen aus.");
        JLabel airport_dep_label = new JLabel("Abflughafen");
        JLabel airport_ariv_label = new JLabel("Zielflughafen");
        // Dropdown for airport selection
        this.select_dep_airport = new JComboBox(this.m.get_dep_Airports());
        this.select_ariv_airport = new JComboBox(this.m.get_ariv_Airports());
        this.submit_airport = new JButton("Submit");
        // Components added to JPanel for airport selection
        this.content_Panel.add(this.c1);
        this.content_Panel.add(airport_label);
        this.content_Panel.add(this.c2);
        this.content_Panel.add(airport_dep_label);
        this.content_Panel.add(airport_ariv_label);
        this.content_Panel.add(this.c3);
        this.content_Panel.add(this.select_dep_airport);
        this.content_Panel.add(this.select_ariv_airport);
        this.content_Panel.add(this.submit_airport);
        // ActionLister added to submit button
        this.submit_airport.addActionListener(this.c);
        this.add(content_Panel);
        this.setVisible(true);
    }

    /**
     * Panel for flight selection
     */
    public void flights() {
        /**
         * JPanel for flight selection
         */
        this.remove(this.content_Panel);
        this.content_Panel = new JPanel();
        // GridLayout chosen for select_flight
        this.content_Panel.setLayout(new GridLayout(2, 2, 10, 0));
        // Labels for flight selection
        JLabel flight_label = new JLabel("Bitte wählen Sie ihren gewünschten Flug aus");
        // Dropdown for flight selection
        this.select_flightnr = new JComboBox(this.m.getFlights());
        this.submit_flight = new JButton("Submit");
        // Components added to JPanel for flight selection
        this.content_Panel.add(flight_label);
        this.content_Panel.add(this.c1);
        this.content_Panel.add(this.select_flightnr);
        this.content_Panel.add(this.submit_flight);
        // ActionLister added to submit button
        this.submit_flight.addActionListener(this.c);
        this.add(content_Panel);
        this.setVisible(true);
    }

    /**
     * Basic config for the Frame
     */
    public void frame_config() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(800,250);
        this.setResizable(false);
        this.setLocation(d.width/2-this.getSize().width/2, d.height/2-this.getSize().height/2);
        this.setTitle("Booking");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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

    public String get_dep_Country(){
        System.out.println((String) this.select_dep_country.getSelectedItem());
        return (String) this.select_dep_country.getSelectedItem();
    }

    public String get_ariv_Country(){
        System.out.println((String) this.select_ariv_country.getSelectedItem());
        return (String) this.select_ariv_country.getSelectedItem();
    }

    public String get_dep_Airport(){
        return (String) this.select_dep_airport.getSelectedItem();
    }

    public String get_ariv_Airport(){
        return (String) this.select_ariv_airport.getSelectedItem();
    }

    public String get_Flight(){
        return (String) this.select_flightnr.getSelectedItem();
    }
}