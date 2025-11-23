import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PasswordVaultService {

    // Add a new password
    public boolean addPassword(String site, String username, String password) {
        String encryptedPassword = AESUtil.encrypt(password);

        try (Connection con = DBConnection.getConnection()) {

            String sql = "INSERT INTO vault(site, username, password_enc) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, site);
            ps.setString(2, username);
            ps.setString(3, encryptedPassword);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error adding password: " + e.getMessage());
        }

        return false;
    }

    // View all passwords
    public List<String> viewPasswords() {
        List<String> passwords = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {

            String sql = "SELECT id, site, username, password_enc FROM vault";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String site = rs.getString("site");
                String username = rs.getString("username");
                String decryptedPassword = AESUtil.decrypt(rs.getString("password_enc"));

                passwords.add(id + ". Site: " + site + ", Username: " + username + ", Password: " + decryptedPassword);
            }

        } catch (Exception e) {
            System.out.println("Error viewing passwords: " + e.getMessage());
        }

        return passwords;
    }

    // Update password by ID
    public boolean updatePassword(int id, String newPassword) {
        String encryptedPassword = AESUtil.encrypt(newPassword);

        try (Connection con = DBConnection.getConnection()) {

            String sql = "UPDATE vault SET password_enc = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, encryptedPassword);
            ps.setInt(2, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error updating password: " + e.getMessage());
        }

        return false;
    }

    // Delete password by ID
    public boolean deletePassword(int id) {

        try (Connection con = DBConnection.getConnection()) {

            String sql = "DELETE FROM vault WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error deleting password: " + e.getMessage());
        }

        return false;
    }
}
