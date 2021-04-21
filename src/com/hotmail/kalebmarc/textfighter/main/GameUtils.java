package com.hotmail.kalebmarc.textfighter.main;

import java.util.List;

public class StringUtils {

  /*
  * This is a Utility Class for modifying String
  */
  public static void print(String input) {
    System.out.print(input);
  }

  public static void println(String input) {
    print(input + "\n");
  }

  public static void println(int input) {
    print(input + "\n");
  }

  public static void println(boolean input) {
    print(input + "\n");
  }

  public static void println(double input) {
    print(input + "\n");
  }

  public static void println() {
    print("\n");
  }

  public static void showPopup(String header, String subheader, List<String> message, List<String> inputs) {
    Ui.cls();
    println(center(Constants.DASH_DIVIDER));
    println(center(header));
    println(center(subheader));
    println(center(Constants.STAR_DIVIDER));
    println(center(Constants.EMPTY_SPACE_BOX));

    for (int i = 0; i < message.size(); i++) {
      println(center(message.get(i)));
    }

    println(center(Constants.EMPTY_SPACE_BOX));

    for (int i = 0; i < inputs.size(); i++) {
      int input_num = i+1;
      String input = input_num + "- " + inputs.get(i);
      println(leftAlign(input));
    }
    println(center(Constants.DASH_DIVIDER));
    println(center(Constants.BRAND_NAME));
    println(center(Constants.DASH_DIVIDER));
  }

  public static String center(String s, int size) {
    return center(s, size, ' ');
  }

  public static String center(String s) {
    return center(s, 45, ' ');
  }
  public static String leftAlign(String s) {
    return leftAlign(s, 45, ' ');
  }

  public static String center(String s, int size, char pad) {
    if (s == null || size <= s.length()) {
      return s;
    }

    StringBuilder sb = new StringBuilder(size);
    sb.append("|");
    sb.append(String.valueOf(pad).repeat((size - s.length()) / 2));
    sb.append(s);
    while (sb.length() < size) {
      sb.append(pad);
    }
    sb.append("|");
    return sb.toString();
  }

  public static String leftAlign(String s, int size, char pad) {
    if (s == null || size <= s.length()) {
      return s;
    }
    StringBuilder sb = new StringBuilder(size);
    sb.append("|");
    sb.append(String.valueOf(pad).repeat(10));
    sb.append(s);
    while (sb.length() < size) {
      sb.append(pad);
    }
    sb.append("|");
    return sb.toString();
  }
}
