import java.util.List;

public class ViewPasswordUI {

    private PasswordVaultService vaultService = new PasswordVaultService();

    public void viewPasswords() {

        System.out.println("=== VIEW PASSWORDS ===");

        List<String> passwords = vaultService.viewPasswords();
        if (passwords.isEmpty()) {
            System.out.println("No passwords found.");
        } else {
            for (String entry : passwords) {
                System.out.println(entry);
            }
        }
    }
}
