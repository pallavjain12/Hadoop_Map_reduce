package org.example;

import org.apache.hadoop.util.hash.Hash;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
//    public static void main( String[] args ) {
//        System.out.println(todaysEpochTIme());
//        System.out.println(tomorrowsEpochTime());
//    }
//
//    static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//
//    public static String todaysEpochTIme() {
//        String today = null;
//            today = LocalDate.now().toString();
//        try {
//            return  toEpochTime(df.parse(today));
//        }
//        catch (Exception e) {
//            return "";
//        }
//    }
//
//    public static String tomorrowsEpochTime() {
//        String tomorrow = "";
//            tomorrow = LocalDate.now().plusDays(1).toString();
//        try {
//            return toEpochTime(df.parse(tomorrow));
//        }
//        catch (Exception e) {
//            return "";
//        }
//    }
//
//    public static String toEpochTime(Date date) {
//        return String.valueOf(date.getTime());
//    }
}
