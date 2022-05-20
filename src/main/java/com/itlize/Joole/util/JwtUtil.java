package com.itlize.Joole.util;

import org.springframework.beans.factory.annotation.Value;


public class JwtUtil {
    @Value("${JwtSecret}")
    private String SECRET_KEY;
}
