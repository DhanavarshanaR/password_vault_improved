import java.util.Scanner;

public class AddPasswordUI {

    private PasswordVaultService vaultService = new PasswordVaultService();
    private Scanner sc = new Scanner(System.in);

    public void addPassword() {

        System.out.println("=== ADD NEW PASSWORD ===");

        System.out.print("Enter site/application name: ");
        String site = sc.nextLine();

        System.out.print("Enter username/email: ");
        String username = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        boolean added = vaultService.addPassword(site, username, password);
        if (added) {
            System.out.println("Password added successfully!");
        } else {
            System.out.println("Failed to add password.");
        }
    }
}
