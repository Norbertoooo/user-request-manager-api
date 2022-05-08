package com.vitu.user.request.manager.util;

import org.junit.jupiter.api.Test;

import static com.vitu.user.request.manager.AbstractTest.PASSWORD;
import static org.junit.jupiter.api.Assertions.*;

class HashUtilTest {

    @Test
    void getSecureHash() {
        String secureHash = HashUtil.getSecureHash(PASSWORD);
        assertEquals(64, secureHash.length());
    }
}