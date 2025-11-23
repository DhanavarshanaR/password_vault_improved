import java.util.Scanner;

public class SetupMasterUI {

    private MasterPasswordService masterService = new MasterPasswordService();
    private Scanner sc = new Scanner(System.in);

    public void setup() {

        System.out.println("=== SETUP MASTER PASSWORD ===");

        if (masterService.isMasterPasswordSet()) {
            System.out.println("Master password is already set. Please login.");
            return;
        }

        System.out.print("Enter new master password: ");
        String password1 = sc.nextLine();

        System.out.print("Confirm master password: ");
        String password2 = sc.nextLine();

        if (!password1.equals(password2)) {
            System.out.println("Passwords do not match! Please try again.");
            return;
        }

        boolean saved = masterService.saveMasterPassword(password1);
        if (saved) {
            System.out.println("Master password setup successful!");
        } else {
            System.out.println("Failed to save master password. Try again.");
        }
    }
}
