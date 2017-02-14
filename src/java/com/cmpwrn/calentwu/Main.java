package com.cmpwrn.calentwu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        String config = config(args);
//        the config is the CSV that goes into the scheduler
        String calendarCsv = new CalendarGenerator(config).generate();

//        the calendarCsv is the CSV that gets loaded into google (similar but different, and ideally interchangeable)
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
