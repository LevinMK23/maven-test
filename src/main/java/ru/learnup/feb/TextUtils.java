package ru.learnup.feb;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextUtils {

    private static final Logger LOG = LoggerFactory.getLogger(TextUtils.class);

    public static void main(String[] args) throws FileNotFoundException {
        // print all -p
        // most popular -m
        // count of char -c
//        URL resource = TextUtils.class.getResource("input.txt");
//        String pathToFile = resource.getFile();
        LOG.debug("Application started...");
        Scanner in = new Scanner(new File("input.txt"));

        Map<String, Integer> wordsMap = new HashMap<>();
        List<String> content = new ArrayList<>();
        while (in.hasNext()) {
            String word = in.next();
            content.add(word);
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }

        String option = args[0];
        switch (option) {
            case "-p" -> content.forEach(word -> System.out.print(word + " "));
            case "-m" -> wordsMap.entrySet()
                    .stream()
                    .max(Map.Entry.comparingByValue())
                    .ifPresent(entry -> System.out.print(entry.getKey()));
            case "-c" -> {
                String sym = args[1];
                System.out.print(sym + " - " + wordsMap.get(sym) + " times in text");
            }
        }
        System.out.println();
        LOG.debug("Application finished...");
    }
}
