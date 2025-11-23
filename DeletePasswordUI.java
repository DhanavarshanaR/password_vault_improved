import java.util.Scanner;

public class DeletePasswordUI {

    private PasswordVaultService vaultService = new PasswordVaultService();
    private Scanner sc = new Scanner(System.in);

    public void deletePassword() {

        System.out.println("=== DELETE PASSWORD ===");

        System.out.print("Enter the ID of the password to delete: ");
        int id = Integer.parseInt(sc.nextLine());

        boolean deleted = vaultService.deletePassword(id);
        if (deleted) {
            System.out.println("Password deleted successfully!");
        } else {
            System.out.println("Failed to delete password. Check if ID exists.");
        }
    }
}
