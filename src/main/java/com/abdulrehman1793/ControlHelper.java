package com.abdulrehman1793;

import org.springframework.util.MultiValueMap;

public class ControlHelper {

    boolean hasData(MultiValueMap<String, String> filters) {
        return filters.containsKey("secret data");
    }
}
