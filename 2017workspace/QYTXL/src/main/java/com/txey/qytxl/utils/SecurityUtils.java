package com.txey.qytxl.utils;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class SecurityUtils {
    private static final String SITE_WIDE_SECRET = "beibei";
    private static final PasswordEncoder encoder = new StandardPasswordEncoder(SITE_WIDE_SECRET);

    public static String encrypt(String rawPassword) {
        return encoder.encode(rawPassword);
    }

    public static boolean match(String rawPassword, String password) {
        return encoder.matches(rawPassword, password);
    }

    public static void main(String[] args) {
        System.out.println(SecurityUtils.encrypt(""));
        System.out.println(SecurityUtils.encrypt("root"));
        System.out.println(SecurityUtils.encrypt("zxj1219120029"));
        System.out.println(SecurityUtils.match("zxj1219120029", SecurityUtils.encrypt("zxj1219120029")));
    }
}
