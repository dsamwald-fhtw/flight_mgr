package flight_mgr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
     * Declaration of JRadiobuttons
     */
    private JRadioButton MySQL;
    private JRadioButton Postgres;
    /**
     * Declaration of Buttongroups
     */
    private ButtonGroup DBMS_buttons;
    /**
     * Declaration of Textfields
     */
    private JTextField text_vname;
    private JTextField text_nname;

    private JTextField text_username;
    private JPasswordField text_password;
    private JTextField text_address;
    /**
     * Declaration of JSpinner
     */
    private JSpinner rownr;

    /**
     * Declaration of used Dropdowns
     */
    private JComboBox select_dep_country;
    private JComboBox select_ariv_country;

    private JComboBox select_dep_airport;
    private JComboBox select_ariv_airport;

    private JComboBox select_flightnr;

    private JComboBox select_seatpos;
    /**
     * Declaration of used Submit Buttons
     */
    private JButton submit_country;
    private JButton submit_airport;
    private JButton submit_flight;
    private JButton submit_db_credentials;
    private JButton save_passenger;
    private JButton add_passenger;
    private JButton exit_passenger;

    /**
     * Constructor of view
     *
     * @param m model
     * @param c controller
     */
    public view(model m, controller c) {
        this.m = m;
        this.c = c;

        this.db_credentials();
        this.frame_config();
    }

    public void db_credentials(){
        this.content_Panel = new JPanel();
        this.content_Panel.setLayout(new FlowLayout());
        JLabel DBMS = new JLabel("DBMS:");
        JLabel username = new JLabel("Username:");
        JLabel password = new JLabel("Password:");
        JLabel address = new JLabel("Server Address:");
        this.DBMS_buttons = new ButtonGroup();
        this.MySQL = new JRadioButton("MySQL");
        this.DBMS_buttons.add(this.MySQL);
        this.Postgres = new JRadioButton("Postgres");
        this.DBMS_buttons.add(this.Postgres);
        this.text_username = new JTextField(20);
        this.text_password = new JPasswordField(20);
        this.text_address = new JTextField(20);
        this.submit_db_credentials = new JButton("Login");

        this.content_Panel.add(DBMS);
        this.content_Panel.add(this.MySQL);
        this.content_Panel.add(this.Postgres);
        this.content_Panel.add(username);
        this.content_Panel.add(this.text_username);
        this.content_Panel.add(password);
        this.content_Panel.add(this.text_password);
        this.content_Panel.add(address);
        this.content_Panel.add(this.text_address);
        this.content_Panel.add(this.submit_db_credentials);
        this.submit_db_credentials.addActionListener(this.c);
        this.add(this.content_Panel);
        this.setVisible(true);
    }

    /**
     * Panel for Country selection
     */
    public void countrys() {
        /**
         * JPanel for country selection
         */
        this.remove(content_Panel);
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

    public void passenger(){
        this.remove(this.content_Panel);
        this.content_Panel = new JPanel();
        this.content_Panel.setLayout( new FlowLayout() );
        JLabel vname_label = new JLabel("Vorname:");
        JLabel nname_label = new JLabel("Nachname:");
        JLabel rownr_label = new JLabel("Reihe:");
        JLabel seatpos_label = new JLabel("Sitzplatz:");
        this.text_vname = new JTextField(20);
        this.text_nname = new JTextField(20);
        this.rownr = new JSpinner();
        this.select_seatpos = new JComboBox(this.m.getseatpositions());
        this.save_passenger = new JButton("Save");
        this.add_passenger = new JButton("Add");
        this.exit_passenger = new JButton("Exit");
        this.content_Panel.add(vname_label);
        this.content_Panel.add(text_vname);
        this.content_Panel.add(nname_label);
        this.content_Panel.add(text_nname);
        this.content_Panel.add(rownr_label);
        this.content_Panel.add(rownr);
        this.content_Panel.add(seatpos_label);
        this.content_Panel.add(select_seatpos);
        this.content_Panel.add(save_passenger);
        this.content_Panel.add(add_passenger);
        this.content_Panel.add(exit_passenger);
        this.save_passenger.addActionListener(this.c);
        this.add_passenger.addActionListener(this.c);
        this.exit_passenger.addActionListener(this.c);
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

    /**
     * Check if button add from passenger is pressed
     *
     * @param e
     * @return
     */
    public boolean isButtonSavePassenger(ActionEvent e) {
        if (e.getSource() == this.save_passenger) return true;
        return false;
    }

    /**
     * Check if button add from passenger is pressed
     *
     * @param e
     * @return
     */
    public boolean isButtonAddPassenger(ActionEvent e) {
        if (e.getSource() == this.add_passenger) return true;
        return false;
    }

    /**
     * Check if button add from passenger is pressed
     *
     * @param e
     * @return
     */
    public boolean isButtonExitPassenger(ActionEvent e) {
        if (e.getSource() == this.exit_passenger) return true;
        return false;
    }

    public boolean isButtonDBMSLogin(ActionEvent e) {
        if (e.getSource() == this.submit_db_credentials) return true;
        return false;
    }

    /**
     * Returns departure Country
     * @return
     */
    public String get_dep_Country(){
        System.out.println((String) this.select_dep_country.getSelectedItem());
        return (String) this.select_dep_country.getSelectedItem();
    }
    /**
     * Returns arival Country
     * @return
     */
    public String get_ariv_Country(){
        System.out.println((String) this.select_ariv_country.getSelectedItem());
        return (String) this.select_ariv_country.getSelectedItem();
    }
    /**
     * Returns departure Airport
     * @return
     */
    public String get_dep_Airport(){
        System.out.println((String) this.select_dep_airport.getSelectedItem());
        return (String) this.select_dep_airport.getSelectedItem();
    }
    /**
     * Returns arival Airport
     * @return
     */
    public String get_ariv_Airport(){
        System.out.println((String) this.select_ariv_airport.getSelectedItem());
        return (String) this.select_ariv_airport.getSelectedItem();
    }

    /**
     * Returns Vorname
     * @return
     */
    public String get_vname() {
        return this.text_vname.getText();
    }

    /**
     * Returns Nachname
     * @return
     */
    public String get_nname() {
        return text_nname.getText();
    }

    /**
     * Returns row number
     * @return
     */
    public int get_rownr() {
        return (int) rownr.getValue();
    }

    /**
     * returns seatposition
     * @return
     */
    public String get_seatpos() {
        return (String) select_seatpos.getSelectedItem();
    }

    /**
     * Returns "Flightnumber"
     * @return
     */
    public int get_Flight(){
        return this.select_flightnr.getSelectedIndex();
    }

    public String get_DBMS(){
        if(this.MySQL.isSelected()){
            return "com.mysql.jdbc.Driver";
        }else{
            if(this.Postgres.isSelected()) {
                return "org.postgresql.ds.PGSimpleDataSource";
            }else{
                System.out.println("Connection Failed!");
                return null;
            }
        }
    }

    public String get_User(){
        return this.text_username.getText();
    }

    public String get_Pass(){
        return this.text_password.getText();
    }

    public String get_Address(){
        return this.text_address.getText();
    }
}
