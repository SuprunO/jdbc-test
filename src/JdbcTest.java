import java.sql.*;

/**
 * Created by alex on 29.03.2017.
 */
public class JdbcTest {

    public static void main(String[] args) throws SQLException {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        String dbURL = "jdbc:mysql://localhost:3306/?useSSL=false";
        String user = "student";
        String pass = "student";

        try {
            // 1. Get Connection to DB
            myConn = DriverManager.getConnection(dbURL, user, pass);
            System.out.println("Database connection successful");

            // 2. Create a statement
            myStmt = myConn.createStatement();

            //3. Insert a new city
         System.out.println("Inserting a new employee to DB\n");
//            int rowsAffected = myStmt.executeUpdate("insert into world.city " + "(Name,CountryCode,District,Population)" + "values " + "('Kiev','KUI','Troeshina',3000000)");


            // 4. Execute SQL Query
            myRs = myStmt.executeQuery("select*from world.city order by Name");

            // 5. Process the result set
            while (myRs.next()) {
                System.out.println( myRs.getString("Name") + ", " + myRs.getString("CountryCode") + ", " + myRs.getString("District") + "," + myRs.getString("Population"));
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myRs != null) {
                myRs.close();
            }
        }
    }

}

