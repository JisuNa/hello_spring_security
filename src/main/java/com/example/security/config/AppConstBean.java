package com.example.security.config;

import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SuppressWarnings("deprecation")
public class AppConstBean {



    /** **************************************************************************
     * Security Config
     ************************************************************************** */
    public static final String SECURITY_ROLE_PREFIX = "";
    public static final String SECURITY_ROLE_AUTH_USER = SECURITY_ROLE_PREFIX+"USER";
    public static final String SECURITY_ROLE_AUTH_ADMIN = SECURITY_ROLE_PREFIX+"ADMIN";

    public static final String SECURITY_LOGIN_PAGE = "/session/login";
    public static final String SECURITY_LOGIN_PROCESSING_URL = "/session/login-proc";
    public static final String SECURITY_FAILURE_URL = "/session/login?c=fail";
    public static final String SECURITY_OTP_FAILURE_URL = "/session/login?c=otpfail";
    public static final String SECURITY_LOGOUT_URL = "/session/logout-proc";
    public static final String SECURITY_LOGOUT_SUCCESS_URL = "/session/login?c=out";
    public static final String SECURITY_LOGOUT_MOBILE_SUCCESS_URL = "";
    public static final String SECURITY_USERNAME_PARAMETER = "un";
    public static final String SECURITY_PASSWORD_PARAMETER = "up";

    public static final String SECURITY_USERS_BY_USERNAME_QUERY =
            "SELECT account_id, replace(password, '$2y', '$2a'), is_deleted FROM accounts WHERE account_id=?";
    public static final String SECURITY_AUTHORITIES_BY_USERNAME_QUERY =
            "select name, role from accounts where name = ?";


}
