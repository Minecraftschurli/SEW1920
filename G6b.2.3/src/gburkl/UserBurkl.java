package gburkl;

import tgm.list.Role;
import tgm.list.User;
import tgm.list.exception.NotEnoughPrivilegesException;
import tgm.list.exception.PasswordTooWeakException;

import java.util.regex.Pattern;

/**
 * @author Georg Burkl
 * @version 2020-05-25
 */
public class UserBurkl extends User {
    private static final String REGEX = ".*%s.*";
    private static final String REGEX_2 = "^.*(%s).*(?!\\1|$)%s.*$";
    private static final String LOWER_CHARS = "[a-z]";
    private static final String UPPER_CHARS = "[A-Z]";
    private static final String DIGITS = "[0-9]";
    private static final String SPECIAL = "[$%\\-.,;:!?@+#*=()]";
    private static final String UMLAUTS = "[äöüÄÖÜß]";
    private static final String[] GROUPS = {LOWER_CHARS, UPPER_CHARS, DIGITS, SPECIAL, UMLAUTS};

    public UserBurkl(String username, String password, Role role, User authorativeUser) throws NotEnoughPrivilegesException, PasswordTooWeakException {
        super(username, password, role, authorativeUser);
    }

    public static int checkPasswordStrength(String password) {
        if (password.length() < 8) return 0;
        int strength = Math.min(password.length()/8, 2);
        int groups = 0;
        boolean flag = false;
        for (String group : UserBurkl.GROUPS) {
            if (Pattern.matches(String.format(REGEX, group), password)) {
                groups++;
                if (!Pattern.matches(String.format(REGEX_2, group, group), password)) {
                    flag = true;
                }
            }
        }
        if (groups > 2) {
            strength++;
            if (groups > 3) {
                strength++;
                if (groups > 4) {
                    strength++;
                }
            }
        }
        if (flag) {
            strength--;
        }
        return strength;
    }
}
