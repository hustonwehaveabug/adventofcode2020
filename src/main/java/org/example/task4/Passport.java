package org.example.task4;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class Passport {

    private final Map<String, String> fields = new HashMap<>();

    public void addField(String key, String value) {
        fields.put(key, value);
    }
}
