import java.sql.*;

/**
 * Created by alex on 25.04.2017.
 */
public class UpdateFields {

    public static void main(String[] args) throws SQLException {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        String dbURL = "jdbc:mysql://localhost:3306/?useSSL=false";
        String user = "root";
        String pass = "Qwerty!1";

        try {
            // 1. Get Connection to DB
            myConn = DriverManager.getConnection(dbURL, user, pass);
            System.out.println("Database connection successful");

            // 2. Create a statement
            myStmt = myConn.createStatement();


            //3. Update a field
            System.out.println("Inserting a new city to DB\n");
            int rowsAffected = myStmt.executeUpdate(
                    "insert into world.tablefirst" +"(id,username,abra)"+
                            "values"  + "('4','Ponya','2013-12-30')");


            // 4. Get the list of emloyees
            myRs = myStmt.executeQuery("select*from world.tablefirst order by id");

            // 5. Process the result set
            while (myRs.next()) {
                System.out.println(myRs.getString("id") + " | " + myRs.getString("username") + " | " + myRs.getString("abra"));
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
