import java.sql.*;

/**
 * Created by alex on 24.04.2017.
 */
public class DeleteField {

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


                System.out.println("Delete field by ID");
                int rowsAffected1 = myStmt.executeUpdate(
                        "delete from world.tablefirst where id ='3'");


                // 4. Get the list of employees
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

