import java.sql.*;

/**
 * Created by alex on 29.03.2017.
 */
public class JdbcTest {

    public static void main(String[] args) throws SQLException {
        String dbURL = "jdbc:mysql://localhost:3306/";
        String user = "student";
        String pass = "student";

        try {
            //1. Get Connection to DB
            Connection myConn = DriverManager.getConnection(dbURL, user, pass);
            System.out.println("Database connection successful");

            //2. Create a statement
            Statement myStmt = myConn.createStatement();

            //3. Execute SQL Query
            ResultSet myRs = myStmt.executeQuery("select*from world.city");

            while (myRs.next()) {
                System.out.println(myRs.getString("ID") + ", " + myRs.getString("Name") + ", " + myRs.getString("CountryCode") + ", " + myRs.getString("District") + "," + myRs.getString("Population"));
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }
}
