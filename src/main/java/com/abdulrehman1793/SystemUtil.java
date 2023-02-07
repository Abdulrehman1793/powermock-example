package com.abdulrehman1793;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

public class SystemUtil {
    public static Long getLocalTime() {
        return LocalDateTime.now().getLong(ChronoField.DAY_OF_WEEK);
    }
}
