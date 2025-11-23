import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SetupMasterUI setupUI = new SetupMasterUI();
        LoginUI loginUI = new LoginUI();
        DashboardUI dashboard = new DashboardUI();

        while (true) {
            System.out.println("\n=== PASSWORD VAULT ===");
            System.out.println("1. Setup Master Password");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    setupUI.setup();
                    break;
                case "2":
                    if (loginUI.login()) {
                        dashboard.showDashboard();
                    }
                    break;
                case "3":
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
