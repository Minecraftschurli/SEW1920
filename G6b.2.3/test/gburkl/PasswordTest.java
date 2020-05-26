package gburkl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Georg Burkl
 * @version 2020-05-25
 */
class PasswordTest {
    @Test
    void checkPasswordLength() {
        assertEquals(0, UserBurkl.checkPasswordStrength("TestP"),            "Strength is not 0 for password 'TestP'");
        assertEquals(0, UserBurkl.checkPasswordStrength("tttttt"),           "Strength is not 0 for password 'tttttt'");
        assertEquals(1, UserBurkl.checkPasswordStrength("testpass"),         "Strength is not 1 for password 'testpass'");
        assertEquals(2, UserBurkl.checkPasswordStrength("testpasstestpass"), "Strength is not 2 for password 'testpasstestpass'");
    }

    @Test
    void checkPasswordStrengthOneGroup() {
        assertEquals(0, UserBurkl.checkPasswordStrength("tttttttt"), "Strength is not 0 for password 'tttttttt'");
        assertEquals(1, UserBurkl.checkPasswordStrength("tetetete"), "Strength is not 1 for password 'tetetete'");
    }

    @Test
    void checkPasswordStrengthTwoGroups() {
        assertEquals(0, UserBurkl.checkPasswordStrength("Tttttttt"), "Strength is not 0 for password 'Tttttttt'");
        assertEquals(0, UserBurkl.checkPasswordStrength("Tetetete"), "Strength is not 0 for password 'Tetetete'");
        assertEquals(1, UserBurkl.checkPasswordStrength("TEtetete"), "Strength is not 1 for password 'TEtetete'");
    }

    @Test
    void checkPasswordStrengthThreeGroups() {
        assertEquals(1, UserBurkl.checkPasswordStrength("TestPas!"), "Strength is not 1 for password 'TestPas!'");
        assertEquals(2, UserBurkl.checkPasswordStrength("=TestPa!"), "Strength is not 2 for password '=TestPa!'");
    }

    @Test
    void checkPasswordStrengthFourGroups() {
        assertEquals(2, UserBurkl.checkPasswordStrength("=TstPäs!"), "Strength is not 2 for password '=TstPäs!'");
        assertEquals(3, UserBurkl.checkPasswordStrength("=TötPäs!"), "Strength is not 3 for password '=TötPäs!'");
    }

    @Test
    void checkPasswordStrengthFiveGroups() {
        assertEquals(3, UserBurkl.checkPasswordStrength("=Tö5tPäs!"),  "Strength is not 3 for password '=Tö5tPäs!'");
        assertEquals(4, UserBurkl.checkPasswordStrength("=Tö5tPäs!0"), "Strength is not 4 for password '=Tö5tPäs!0'");
    }

    @Test
    void checkPasswordStrengthMax() {
        assertEquals(3, UserBurkl.checkPasswordStrength("MeenNeuesPässwört"), "Strength is not 3 for password 'MeenNeuesPässwört'");
        assertEquals(4, UserBurkl.checkPasswordStrength("MeenPässwört!-00"),  "Strength is not 4 for password 'MeenPässwört!_00'");
        assertEquals(5, UserBurkl.checkPasswordStrength("MeenPässwört!-007"), "Strength is not 5 for password 'MeenPässwört!_007'");
    }
}
