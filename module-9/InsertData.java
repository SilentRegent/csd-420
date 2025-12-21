import java.sql.*;
public class InsertData {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/databasedb?useSSL=false";
        String user = "student1";
        String password = "pass";
        
        Connection con = null;
        Statement stmt = null;
        
        try {
            // MySQL 5.x driver
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            
            System.out.println("Connection established - now executing inserts");
            
            // Correct: INSERT INTO addressdb (your TABLE name - with two 's')
            stmt.executeUpdate("INSERT INTO addressdb VALUES(55,'Larry','Rich','1111 Redwing Circle888','Bellevue','NE','68123')");
            stmt.executeUpdate("INSERT INTO addressdb VALUES(1,'Fine','Ruth','1111 Redwing Circle','Bellevue','NE','68123')");
            stmt.executeUpdate("INSERT INTO addressdb VALUES(2,'Howard','Curly','1000 Galvin Road South','Bellevue','NE','68005')");
            stmt.executeUpdate("INSERT INTO addressdb VALUES(3,'Howard','Will','2919 Redwing Circle','Bellevue','NE','68123')");
            stmt.executeUpdate("INSERT INTO addressdb VALUES(4,'Wilson','Larry','1121 Redwing Circle','Bellevue','NE','68124')");
            stmt.executeUpdate("INSERT INTO addressdb VALUES(5,'Johnson','George','1300 Galvin Road South','Bellevue','NE','68006')");
            stmt.executeUpdate("INSERT INTO addressdb VALUES(6,'Long','Matthew','2419 Redwing Circle','Bellevue','NE','68127')");
            stmt.executeUpdate("INSERT INTO addressdb VALUES(44,'Tom','Matthew','1999 Redwing Circle','Bellevue','NE','68123')");
            
            System.out.println("Data Inserted Successfully.");
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Insert Data Failed.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("MySQL Driver not found.");
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
                System.out.println("Database connections closed.");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Connection close failed.");
            }
        }
    }
}