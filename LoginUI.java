import java.util.Scanner;

public class LoginUI {

    private MasterPasswordService masterService = new MasterPasswordService();
    private Scanner sc = new Scanner(System.in);

    public boolean login() {

        System.out.println("=== LOGIN ===");

        if (!masterService.isMasterPasswordSet()) {
            System.out.println("Master password not set. Please setup first.");
            return false;
        }

        System.out.print("Enter master password: ");
        String inputPassword = sc.nextLine();

        boolean verified = masterService.verifyMasterPassword(inputPassword);
        if (verified) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Incorrect master password!");
            return false;
        }
    }
}
