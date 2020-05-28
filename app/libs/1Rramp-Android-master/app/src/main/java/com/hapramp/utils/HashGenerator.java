package com.hapramp.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Ankit on 2/17/2018.
 */

public class HashGenerator {

  public static String getMD5Hash(String s) {
    try {
      MessageDigest digest = MessageDigest.getInstance("MD5");
      byte[] hash = digest.digest(s.getBytes("UTF-8"));
      return convertByteToHex(hash);
    }
    catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return "";
  }

  private static String convertByteToHex(byte[] byteData) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < byteData.length; i++) {
      sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
    }
    return sb.toString();
  }
}
