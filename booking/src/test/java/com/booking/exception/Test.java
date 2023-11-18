package com.booking.exception;

import com.booking.booking.domain.model.commands.CreateBookingCommand;

import java.time.LocalDateTime;
import java.util.List;

public class Test {


    public static void main(String[] args) {
        double d = 0.1;


        int d1 = (int) d;
        System.out.println("d1 = " + d1);


        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextDay = now.plusDays(1);


        String nowString = now.toString();
        String nextDayString = nextDay.toString();


        CreateBookingCommand command = CreateBookingCommand.builder().build();

        if (command == null) {
            System.out.println("null = " + command);
        } else {
            System.out.println("not null = " + command);
        }

        List<String> stringList = List.of("A");
        String[] strings = stringList.toArray(String[]::new);
        if (strings == null) {
            System.out.println("null!!!");
        } else {
            for (String string : strings) {
                System.out.println("string = " + string);
            }
        }
        System.out.println("stringList = " + stringList);
    }
}
