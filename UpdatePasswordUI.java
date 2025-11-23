import java.util.Scanner;

public class UpdatePasswordUI {

    private PasswordVaultService vaultService = new PasswordVaultService();
    private Scanner sc = new Scanner(System.in);

    public void updatePassword() {

        System.out.println("=== UPDATE PASSWORD ===");

        System.out.print("Enter the ID of the password to update: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Enter the new password: ");
        String newPassword = sc.nextLine();

        boolean updated = vaultService.updatePassword(id, newPassword);
        if (updated) {
            System.out.println("Password updated successfully!");
        } else {
            System.out.println("Failed to update password. Check if ID exists.");
        }
    }
}
