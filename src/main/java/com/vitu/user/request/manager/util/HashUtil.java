package com.vitu.user.request.manager.util;

import org.apache.commons.codec.digest.DigestUtils;

public class HashUtil {

    public static String getSecureHash(String text) {
        return DigestUtils.sha256Hex(text);
    }
}
