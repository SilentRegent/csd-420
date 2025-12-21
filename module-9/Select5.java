import java.sql.*;

public class Select5 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/databasedb?useSSL=false"; // Your database
        String user = "student1";
        String password = "pass";

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Load MySQL 5.x driver
            Class.forName("com.mysql.jdbc.Driver");

            // Connect to database
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established - now executing a select");

            // Create statement and execute query
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM addressdb"); // Use your actual table name

            System.out.println("Received Results:");
            int columnCount = rs.getMetaData().getColumnCount();

            boolean hasRows = false;
            while (rs.next()) {
                hasRows = true;
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }

            if (!hasRows) {
                System.out.println("No data found in table.");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found. Add the Connector/J JAR to your project libraries.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL Exception occurred.");
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
                System.out.println("Database connections closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
