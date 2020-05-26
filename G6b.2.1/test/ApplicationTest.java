import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tgm.list.Role;
import tgm.list.User;
import tgm.list.exception.NotEnoughPrivilegesException;
import tgm.list.exception.PasswordTooWeakException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Georg Burkl
 * @version 2020-04-04
 */
public class ApplicationTest {
    private User user;

    @BeforeEach
    void setUp() {
        user = new User("test", "TesT1234!", Role.MANAGER, null);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Is User correct")
    void userCorrect() {
        assertEquals("test", user.getUsername());
        assertEquals(Role.MANAGER, user.getRole());
        assertEquals(user.getUsername(), user.getAuthorativeUsername());
    }

    @Test
    @DisplayName("User password can be verified")
    void passwordVerify() {
        assertTrue(user.verifyPassword("TesT1234!"));
        assertFalse(user.verifyPassword("Bla1234!"));
    }

    @Test
    @DisplayName("User password can be changed")
    void passwordChange() {
        user.changePassword("ZHabc89X12345%", "TesT1234!");
        assertTrue(user.verifyPassword("ZHabc89X12345%"));
    }

    @Test
    @DisplayName("User password can be reset")
    void passwordReset() {
        User admin = new User("admin", "Admin1234!", Role.ADMIN, null);
        User user = new User("test", "TesT1234!", Role.MANAGER, admin);
        user.resetPassword("ZHabc89X12345%", "admin", "Admin1234!");
        assertTrue(user.verifyPassword("ZHabc89X12345%"));
    }

    @Test
    @DisplayName("User password is checked for strength")
    void passwordStrength() {
        assertThrows(PasswordTooWeakException.class, () -> new User("test", "abc", Role.MANAGER, null));
    }

    @Test
    @DisplayName("User with role WORKER can not be an autorativeUser")
    void workerNonAuthorative() {
        User worker = new User("worker", "Worker1234!", Role.WORKER, null);
        assertThrows(NotEnoughPrivilegesException.class, () -> new User("test", "TesT1234!", Role.VISITOR, worker));
    }
}
