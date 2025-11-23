import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MasterPasswordService {

    // Save master password (encrypted)
    public boolean saveMasterPassword(String masterPassword) {
        String encrypted = AESUtil.encrypt(masterPassword);

        try (Connection con = DBConnection.getConnection()) {

            String sql = "INSERT INTO master_password(password_hash) VALUES (?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, encrypted);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error saving master password: " + e.getMessage());
        }

        return false;
    }

    // Check if master password is already set
    public boolean isMasterPasswordSet() {

        try (Connection con = DBConnection.getConnection()) {

            String sql = "SELECT COUNT(*) FROM master_password";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (Exception e) {
            System.out.println("Error checking master password: " + e.getMessage());
        }

        return false;
    }

    // Verify master password during login
    public boolean verifyMasterPassword(String inputPassword) {

        try (Connection con = DBConnection.getConnection()) {

            String sql = "SELECT password_hash FROM master_password LIMIT 1";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String storedEncrypted = rs.getString("password_hash");
                String decryptedStored = AESUtil.decrypt(storedEncrypted);

                return decryptedStored.equals(inputPassword);
            }

        } catch (Exception e) {
            System.out.println("Error verifying password: " + e.getMessage());
        }

        return false;
    }
}
