package com.cyber.licensekey;

import android.util.Log;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CheckLicense {

    public static boolean checkLicense(String license) {

        String license_hash = toHexString(getSHA(license));
        if (license_hash.contains("ff5bb17dfe26eba3c6ac9641a70a96d92b1e7f219899ec58141b643c67d8d6fc21dd5f731d095d0f07eefd771be1bab459a4e7e8bb95d9768e6498b106c9f923")){
            return true;
        }
        return false;
    }

    public static byte[] getSHA(String input)
    {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            return md.digest(input.getBytes(StandardCharsets.UTF_8));
        }catch (NoSuchAlgorithmException e){
            return null;
        }

    }

    public static String toHexString(byte[] hash)
    {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 32)
        {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }
}
