package org.example.task4;

import org.example.utils.FileReader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Part1 {

    private static final List<String> REQUIRED_FIELDS = new ArrayList<>();

    public static void main(String[] args) {
        REQUIRED_FIELDS.add("byr");
        REQUIRED_FIELDS.add("iyr");
        REQUIRED_FIELDS.add("eyr");
        REQUIRED_FIELDS.add("hgt");
        REQUIRED_FIELDS.add("hcl");
        REQUIRED_FIELDS.add("ecl");
        REQUIRED_FIELDS.add("pid");
        List<String> input = FileReader.readFileAsStrings("task4-input.txt");
        List<String> passports = map(input);
        List<Passport> validPassports = checkPassport(passports);
        System.out.println("valid passports: " + validPassports.size());
    }

    private static List<String> map(List<String> input) {
        Iterator<String> itr = input.iterator();
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while (itr.hasNext()) {
            String line = itr.next();
            sb.append(" ").append(line);
            if (line.isEmpty() || !itr.hasNext()) {
                result.add(sb.toString().trim());
                sb = new StringBuilder();
            }
        }
        return result;
    }

    private static List<Passport> checkPassport(List<String> passports) {
        List<Passport> result = new ArrayList<>(300);
        for (String line : passports) {
            Passport passport = new Passport();

            String[] fields = line.split(" ");
            for (String field : fields) {
                String[] keyValuePair = field.split(":");
                passport.addField(keyValuePair[0], keyValuePair[1]);
            }

            long validFields = passport.getFields().keySet().stream().filter(REQUIRED_FIELDS::contains).count();
            if (validFields == REQUIRED_FIELDS.size()) {
                result.add(passport);
            }

        }
        return result;
    }
}
