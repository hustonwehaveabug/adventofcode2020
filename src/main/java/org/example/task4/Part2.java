package org.example.task4;

import org.example.utils.FileReader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Part2 {

    private static final Map<String, String> REQUIRED_FIELDS = Map.of(
            "byr", "^(19[2-9][0-9]|200[0-2])$",
            "iyr", "^(201[0-9]|2020)$",
            "eyr", "^(202[0-9]|2030)$",
            "hgt", "^((1[5-8][0-9]|19[0-3])cm)|((59|6[0-9]|7[0-6])in)$",
            "hcl", "^#[0-9a-f]{6}$",
            "ecl", "^(amb|blu|brn|gry|grn|hzl|oth)$",
            "pid", "^[0-9]{9}$"
    );

    public static void main(String[] args) {
        List<String> input = FileReader.readFileAsStrings("task4-input.txt");
        List<String> passports = map(input);
        List<Passport> validPassports = checkPassports(passports);
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

    private static List<Passport> checkPassports(List<String> passports) {
        List<Passport> result = new ArrayList<>(300);
        for (String line : passports) {
            Passport passport = new Passport();

            String[] fields = line.split(" ");
            for (String field : fields) {
                String[] keyValuePair = field.split(":");
                passport.addField(keyValuePair[0], keyValuePair[1]);
            }

            if (checkPassport(passport)) {
                result.add(passport);
            }

        }
        return result;
    }

    private static boolean checkPassport(Passport passport) {
        Map<String, String> fields = passport.getFields();
        long validFields = REQUIRED_FIELDS.entrySet().stream()
                .filter(rf -> fields.get(rf.getKey()) != null && fields.get(rf.getKey()).matches(rf.getValue()))
                .count();
        return validFields == REQUIRED_FIELDS.size();
    }
}
