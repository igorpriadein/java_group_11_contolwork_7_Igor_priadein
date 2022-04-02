package com.attractor.controlwork7.util;

import lombok.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GenerateData {

    @Data
    @Builder
    public static class DishName {
        public String type;
        public String name;
    }

    @Data
    @Builder
    public static class PlaceName {
        public String description;
        public String name;
    }

    private static final Random r = new Random();
    private static List<String> domains;
    private static List<String> personNames;
    private static List<DishName> dishNames;
    private static List<PlaceName> placeNames;


    static {
        personNames = readStrings(Paths.get("data", "list-person"));
        domains = readStrings(Paths.get("data", "list-domains"));
        placeNames = readPlaces(Paths.get("data", "list-places"));
        dishNames = readDishes(Paths.get("data", "list-foods"));
    }

    public static String randomEmail() {
        return randomPersonName() + domains.get(r.nextInt(domains.size()));
    }

    public static String randomPersonName() {
        return personNames.get(r.nextInt(personNames.size()));
    }

    public static DishName randomDish() {
        return dishNames.get(r.nextInt(dishNames.size()));
    }

    public static PlaceName randomPlace() {
        return placeNames.get(r.nextInt(placeNames.size()));
    }

    public static String randomPassword(){int length = 16;
        Random r = new Random();
        String s = r.ints(48, 122)
                .filter(i -> (i < 57 || i > 65) && (i < 90 || i > 97))
                .mapToObj(i -> (char) i)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    return s;}

    private static List<String> readStrings(Path filePath) {
        try (var lines = Files.lines(filePath)) {
            return lines.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private static List<DishName> readDishes(Path filePath) {
        var lines = readStrings(filePath);
        return lines.stream()
                .map(GenerateData::toDish)
                .collect(Collectors.toList());
    }

    private static List<PlaceName> readPlaces(Path filePath) {
        var lines = readStrings(filePath);
        return lines.stream()
                .map(GenerateData::toPlace)
                .collect(Collectors.toList());
    }

    private static PlaceName toPlace(String fromString) {
        var parts = fromString.split(";");
        return PlaceName.builder()
                .name(parts[0])
                .description(parts[1])
                .build();
    }

    private static DishName toDish(String fromString) {
        var parts = fromString.split(";");
        return DishName.builder()
                .type(parts[0])
                .name(parts[1])
                .build();
    }
}
