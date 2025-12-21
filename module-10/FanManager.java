import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class FanManager extends JFrame {
    private JTextField txtID, txtFirstName, txtLastName, txtFavoriteTeam;
    private JButton btnDisplay, btnUpdate;

    private final String DB_URL = "jdbc:mysql://localhost:3306/databasedb";
    private final String DB_USER = "student1";
    private final String DB_PASS = "pass";

    public FanManager() {
        setTitle("Fan Manager");
        setSize(400, 250);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel lblID = new JLabel("ID:");
        lblID.setBounds(20, 20, 80, 25);
        add(lblID);

        txtID = new JTextField();
        txtID.setBounds(120, 20, 150, 25);
        add(txtID);

        JLabel lblFirstName = new JLabel("First Name:");
        lblFirstName.setBounds(20, 50, 80, 25);
        add(lblFirstName);

        txtFirstName = new JTextField();
        txtFirstName.setBounds(120, 50, 150, 25);
        add(txtFirstName);

        JLabel lblLastName = new JLabel("Last Name:");
        lblLastName.setBounds(20, 80, 80, 25);
        add(lblLastName);

        txtLastName = new JTextField();
        txtLastName.setBounds(120, 80, 150, 25);
        add(txtLastName);

        JLabel lblFavoriteTeam = new JLabel("Favorite Team:");
        lblFavoriteTeam.setBounds(20, 110, 100, 25);
        add(lblFavoriteTeam);

        txtFavoriteTeam = new JTextField();
        txtFavoriteTeam.setBounds(120, 110, 150, 25);
        add(txtFavoriteTeam);

        btnDisplay = new JButton("Display");
        btnDisplay.setBounds(50, 160, 100, 30);
        add(btnDisplay);

        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(200, 160, 100, 30);
        add(btnUpdate);

        // Button action listeners
        btnDisplay.addActionListener(e -> displayRecord());
        btnUpdate.addActionListener(e -> updateRecord());
    }

    // Method to display a record
    private void displayRecord() {
        String idText = txtID.getText();
        if (idText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter an ID.");
            return;
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM fans WHERE ID = ?")) {

            ps.setInt(1, Integer.parseInt(idText));
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                txtFirstName.setText(rs.getString("firstname"));
                txtLastName.setText(rs.getString("lastname"));
                txtFavoriteTeam.setText(rs.getString("favoriteteam"));
            } else {
                JOptionPane.showMessageDialog(this, "Record not found.");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
        }
    }

    // Method to update a record
    private void updateRecord() {
        String idText = txtID.getText();
        if (idText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter an ID.");
            return;
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement ps = conn.prepareStatement(
                     "UPDATE fans SET firstname=?, lastname=?, favoriteteam=? WHERE ID=?")) {

            ps.setString(1, txtFirstName.getText());
            ps.setString(2, txtLastName.getText());
            ps.setString(3, txtFavoriteTeam.getText());
            ps.setInt(4, Integer.parseInt(idText));

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Record updated successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Record not found or no changes made.");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
        }
    }

    // Main method to run GUI and perform test
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FanManager app = new FanManager();
            app.setVisible(true);

            // --- Test code (manual verification) ---
            // You can enter an existing ID and click Display to check if it works
            // Modify values and click Update to test updating
            System.out.println("FanManager GUI launched. Use Display and Update buttons to test functionality.");
        });
    }
}
