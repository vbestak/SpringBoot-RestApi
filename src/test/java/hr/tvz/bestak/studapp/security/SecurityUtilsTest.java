package hr.tvz.bestak.studapp.security;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecurityUtilsTest {

    SecurityUtils securityUtils = new SecurityUtils();

    @Test
    void getCurrentUserUsername() {
        assertNotNull(securityUtils.getCurrentUserUsername());
    }

    @Test
    void getCurrentUserJWT() {
        assertNotNull(securityUtils.getCurrentUserJWT());
    }

    @Test
    void isCurrentUserInRole() {
        assertNotNull(securityUtils.isCurrentUserInRole("ROLE_ADMIN"));
    }
}
