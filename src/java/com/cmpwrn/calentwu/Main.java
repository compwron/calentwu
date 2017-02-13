package com.cmpwrn.calentwu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("hi!");
        String config = config(args);
        String calendarCsv = new CalendarGenerator().generate(config);
        System.out.println(calendarCsv);
    }

    private static String config(String[] args) throws IOException {
        return Files.lines(Paths.get(configFile(args)))
                .collect(Collectors.toList()).toString();
    }

    private static String configFile(String[] args) {
        if (args.length > 0) {
            return args[0];
        }
        return "default.config";
    }
}
