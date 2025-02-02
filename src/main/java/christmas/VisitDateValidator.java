package christmas;

import static christmas.ErrorMessage.ERROR_INVALID_DATE;

public class VisitDateValidator {
    public static void validate(Object day) {
        if (!(day instanceof Integer)) {
            throw new IllegalArgumentException(ERROR_INVALID_DATE);
        }
        int dayInt = (Integer) day;
        if (dayInt < 1 || dayInt > 31) {
            throw new IllegalArgumentException(ERROR_INVALID_DATE);
        }
    }
}
