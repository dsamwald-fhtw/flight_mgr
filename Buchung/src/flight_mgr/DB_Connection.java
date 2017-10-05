package flight_mgr;
//STEP 1. Import required packages
import java.sql.*;
import java.util.ArrayList;

public class DB_Connection {
    // JDBC driver name and database URL
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/flightdata";

    //  Database credentials
    private static final String USER = "root";
    private static final String PASS = "1q2w3e4r";
    //  Connection Attribute
    private Connection conn = null;
    private Statement stmt1 = null;
    private Statement stmt2 = null;

    private PreparedStatement pstmt1 = null;
    private PreparedStatement pstmt2 = null;

    private String[] countrys;
    private String[] airports;
    private String[] airlines;
    private String[] flightnrs;

    /**
     * Constructor
     */
    public DB_Connection() {

        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            this.conn = DriverManager.getConnection(this.DB_URL, this.USER, this.PASS);

        } catch (SQLException e) {
            e.getStackTrace();
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("Cannot connect to Database");
        }
        this.setCountrys();
    }



    /**
     * Reads country data from database
     * @return
     */
    public void setCountrys(){
        try {
            this.stmt1 = conn.createStatement();
            this.stmt2 = conn.createStatement();
            String sql1;
            String sql2;
            sql1 = "SELECT name FROM countries ORDER BY name";
            sql2 = "SELECT COUNT(name) AS arraysize FROM countries";
            ResultSet rs1 = this.stmt1.executeQuery(sql1);
            ResultSet rs2 = this.stmt2.executeQuery(sql2);
            rs2.first();
            int arraysize = rs2.getInt("arraysize");
            this.countrys = new String[arraysize];
            int i = 0;

            while(rs1.next()){
                this.countrys[i] = rs1.getString("name");
                i++;
            }

            rs1.close();
            rs2.close();
            this.stmt1.close();
            this.stmt2.close();
        }catch (Exception e){
            e.printStackTrace(System.out);
        }
    }

    /**
     * Reads airport data from database
     * @return
     */
    public void setAirports(String country) {
        try {
            String sql1 = "SELECT a.name AS name FROM airports a INNER JOIN countries c ON a.country = c.code WHERE c.name = ? ORDER BY a.name";
            this.pstmt1 = conn.prepareStatement(sql1);
            this.pstmt1.setString(1,country);

            String sql2 = "SELECT COUNT(a.name) AS arraysize FROM airports a INNER JOIN countries c ON a.country = c.code WHERE c.name = ?";
            this.pstmt2 = conn.prepareStatement(sql2);
            this.pstmt2.setString(1,country);

            ResultSet rs1 = this.pstmt1.executeQuery();
            ResultSet rs2 = this.pstmt2.executeQuery();

            rs2.first();
            int arraysize = rs2.getInt("arraysize");
            this.airports = new String[arraysize];
            int i = 0;

            while(rs1.next()){
                this.airports[i] = rs1.getString("name");
                i++;
            }

            rs1.close();
            rs2.close();
            this.pstmt1.close();
            this.pstmt2.close();
        }catch (Exception e){
            e.printStackTrace(System.out);
        }
    }

    /**
     * Reads flight data from database
     * @return
     */
    public void setFlights(String dep, String ariv) {
        try {
            String sql1 = "select f.airline AS airline, f.flightnr AS flightnr from flights f INNER JOIN airports a1 ON f.departure_airport = a1.airportcode INNER JOIN airports a2 ON f.destination_airport = a2.airportcode WHERE a1.name = ? AND a2.name = ?";
            this.pstmt1 = conn.prepareStatement(sql1);
            this.pstmt1.setString(1,dep);
            this.pstmt1.setString(2,ariv);

            String sql2 = "select COUNT(f.airline) AS arraysize from flights f INNER JOIN airports a1 ON f.departure_airport = a1.airportcode INNER JOIN airports a2 ON f.destination_airport = a2.airportcode WHERE a1.name = ? AND a2.name = ?";
            this.pstmt2 = conn.prepareStatement(sql2);
            this.pstmt2.setString(1,dep);
            this.pstmt2.setString(2,ariv);

            ResultSet rs1 = this.pstmt1.executeQuery();
            ResultSet rs2 = this.pstmt2.executeQuery();

            rs2.first();
            int arraysize = rs2.getInt("arraysize");
            this.airlines = new String[arraysize];
            this.flightnrs = new String[arraysize];

            int i = 0;
            while (rs1.next()){
                this.airlines[i] = rs1.getString("airline");
                System.out.println(this.airlines[i]);
                this.flightnrs[i] = rs1.getString("flightnr");
                System.out.println(this.flightnrs[i]);
                i++;
            }

            rs1.close();
            rs2.close();
            this.pstmt1.close();
            this.pstmt2.close();
        }catch (Exception e){
            e.printStackTrace(System.out);
        }
    }

    /**
     * Creates a new passenger in DB
     * @param firstname
     * @param lastname
     * @param flightindex
     * @param rownr
     * @param seatposition
     */
    public void addPassenger(String firstname, String lastname, int flightindex, int rownr, String seatposition){
        try {
            String sql = "INSERT INTO passengers(firstname, lastname, airline, flightnr, rownr, seatposition) VALUES (?, ?, ?, ?, ?, ?)";
            this.pstmt1 = conn.prepareStatement(sql);
            this.pstmt1.setString(1,firstname);
            this.pstmt1.setString(2,lastname);
            this.pstmt1.setString(3,this.airlines[flightindex]);
            this.pstmt1.setString(4,this.flightnrs[flightindex]);
            this.pstmt1.setInt(5,rownr);
            this.pstmt1.setString(6,seatposition);

            pstmt1.executeUpdate();

            pstmt1.close();
        }catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    /**
     * Reads Countries form DB
     *
     * @return
     */
    public String[] getCountrys(){
        return this.countrys;
    }

    /**
     * Reads Airports from DB
     *
     * @param country
     * @return
     */
    public String[] getAirports(String country){
        this.setAirports(country);
        return this.airports;
    }

    /**
     * Reads Flights from DB
     *
     * @param dep
     * @param ariv
     * @return
     */
    public String[] get_Flights(String dep, String ariv){
        this.setFlights(dep, ariv);
        String[] airflight = new String[this.airlines.length];

        for(int i = 0; i < this.airlines.length; i++){
            airflight[i] = (""+this.airlines[i]+this.flightnrs[i]);
            System.out.println(airflight[i]);
        }
        return airflight;
    }

}