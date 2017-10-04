package flight_mgr;
//STEP 1. Import required packages
import java.sql.*;

public class DB_Connection {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.jdbc2.optional.MysqlDataSource";
    private static final String DB_URL = "jdbc:mysql://localhost/flightdata";

    //  Database credentials
    private static final String USER = "root";
    private static final String PASS = "1q2w3e4r";
    //  Connection Attribute
    private Connection conn;

    /**
     * Constructor
     */
    public DB_Connection() {

        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            e.getStackTrace();
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("Cannot connect to Database");
        }
    }

    /**
     * Reads country data from database
     * @return
     */
    public String[] getCountrys(){
        try {
            Statement stmt = this.conn.createStatement();
            String sql;
            sql = "SELECT name FROM countries";
            ResultSet rs = stmt.executeQuery(sql);
            int i = 0;
            String[] countrys = {""};
            while (rs.next()) {
                countrys[i] = rs.getString("name");
                System.out.println("Name: " +countrys);
                i++;
            }
            return countrys;
        }catch (Exception e){
            e.getStackTrace();
        }
        return null;

    }

    /**
     * Reads airport data from database
     * @return
     */
    public String[] getAirports(String country) {
        try {
            Statement stmt = this.conn.createStatement();
            String sql;
            sql = "SELECT a.name FROM airports a INNER JOIN countries c ON a.country = c.code where c.name = ?";
            PreparedStatement stmt_airport = conn.prepareStatement(sql);
            stmt_airport.setString(1,country);
            ResultSet rs = stmt.executeQuery(sql);
            int i = 0;
            String[] airports = {""};
            while (rs.next()) {
                airports[i] = rs.getString("name");
                System.out.println("Airport: " +airports);
                i++;
            }
            return airports;
        }catch (Exception e){
            e.getStackTrace();
        }
        return null;
    }

    /**
     * Reads flight data from database
     * @return
     */
    public String[] getFlights(String dep, String ariv) {

        return null;
    }
}