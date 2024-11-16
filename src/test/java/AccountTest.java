import org.example.Acount;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void testInitialBalance() {
        Acount.Account account = new Acount.Account(100.0);
        assertEquals(100.0, account.checkBalance(), "Le solde initial devrait être de 100.0");
    }

    @Test
    void testDeposit() {
        Acount.Account account = new Acount.Account(100.0);
        account.deposit(50.0);
        assertEquals(150.0, account.checkBalance(), "Le solde après le dépôt devrait être de 150.0");
    }

    @Test
    void testWithdrawValidAmount() {
        Acount.Account account = new Acount.Account(100.0);
        boolean success = account.withdraw(30.0);
        assertTrue(success, "Le retrait de 30.0 aurait dû être autorisé");
        assertEquals(70.0, account.checkBalance(), "Le solde après le retrait devrait être de 70.0");
        // Ajoutez ces lignes pour déboguer
        System.out.println("Success: " + success);  // Affiche true si le retrait est autorisé
        System.out.println("Balance: " + account.checkBalance());  // Affiche le solde après le retrait
    }
    @Test
    void testWithdrawInvalidAmount() {
        Acount.Account account = new Acount.Account(100.0);
        boolean success = account.withdraw(200.0);
        assertFalse(success, "Le retrait de 200.0 n'aurait pas dû être autorisé");
        assertEquals(100.0, account.checkBalance(), "Le solde ne devrait pas changer après un retrait invalide");
    }

    @Test
    void testInvalidDeposit() {
        Acount.Account account = new Acount.Account(100.0);
        account.deposit(-50.0);
        assertEquals(100.0, account.checkBalance(), "Le solde ne devrait pas changer après un dépôt invalide");
    }
}