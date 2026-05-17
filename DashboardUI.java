import java.util.Scanner;

public class DashboardUI {

    private Scanner sc = new Scanner(System.in);
    private AddPasswordUI addUI = new AddPasswordUI();
    private ViewPasswordUI viewUI = new ViewPasswordUI();
    private UpdatePasswordUI updateUI = new UpdatePasswordUI();
    private DeletePasswordUI deleteUI = new DeletePasswordUI();

    public void showDashboard() {

        while (true) {
            System.out.println("\n=== PASSWORD VAULT DASHBOARD ===");
            System.out.println("1. Add New Password");
            System.out.println("2. View Passwords");
            System.out.println("3. Update Password");
            System.out.println("4. Delete Password");
            System.out.println("5. Logout / Exit");

            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    addUI.addPassword();
                    break;
                case "2":
                    viewUI.viewPasswords();
                    break;
                case "3":
                    updateUI.updatePassword();
                    break;
                case "4":
                    deleteUI.deletePassword();
                    break;
                case "5":
                    System.out.println("Logging out... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
