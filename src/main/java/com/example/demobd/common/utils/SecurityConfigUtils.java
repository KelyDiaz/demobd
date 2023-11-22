package com.example.demobd.common.utils;

import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;

public class SecurityConfigUtils {
    private SecurityConfigUtils() {
    }

    public static String blindStrSec(String value) {
        PolicyFactory policy = Sanitizers.FORMATTING.and(Sanitizers.LINKS);
        return policy.sanitize(value)
                .replace("&#43;", "+")
                .replace("&#39;", "'")
                .replace("&#61;", "=")
                .replace("&amp;", " & ");
    }
}
