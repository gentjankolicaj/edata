package io.edata.commons.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeUtils {

  private DateTimeUtils() {
  }

  public static Date parse(String format, String date) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
    try {
      return simpleDateFormat.parse(date);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static LocalDate parseToLocalDate(String text, String datePattern) {
    try {
      return LocalDate.parse(text, DateTimeFormatter.ofPattern(datePattern));
    } catch (DateTimeException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static String format(LocalDate now, String datePattern) {
    try {
      return now.format(DateTimeFormatter.ofPattern(datePattern));
    } catch (DateTimeException e) {
      e.printStackTrace();
    }
    return null;
  }
}
