package com.codepracticing.uyghurit;

import java.time.LocalDate;
import java.time.Period;

public class weAreWaitingForYOUEveryday {
    public static void main(String[] args) {


        LocalDate separatedDay = LocalDate.of(2017,07,16);
        System.out.println(separatedDay);
        LocalDate curDate = LocalDate.now();
        Period period = Period.between(separatedDay, curDate);
        System.out.printf("My children have been separated from their father for %d years %d months and %d days.",
                period.getYears(), period.getMonths(), period.getDays());

        System.out.println();

        String messageForHim="we are waiting for you everyday, we miss you so much.";

        System.out.println(messageForHim);



    }
}
