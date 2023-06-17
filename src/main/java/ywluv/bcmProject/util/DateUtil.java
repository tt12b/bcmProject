package ywluv.bcmProject.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static LocalDate getCurrentDate() {
        return LocalDate.now();
    }

    /**
     * 현재 일자를 반환
     * @return LocalDateTime
     */
    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }

    /**
     * 첫번째 파라미터로 넘어온 날짜를 해당 월의 1일로 변경하고, 두 번째 파라미터 만큼 추가로 변경한다.
     */
    public static String manipulateDate(String dateString, int daysToAddOrSubtract) {
        LocalDate date = LocalDate.parse(dateString);
        LocalDate manipulatedDate = date.withDayOfMonth(1).plusDays(daysToAddOrSubtract);
        manipulatedDate.format(DateTimeFormatter.ISO_DATE);
        return manipulatedDate.format(DateTimeFormatter.ISO_DATE);
    }

    /**
     *
     * @param dateString(yyyy/mm/dd)Or(yyyy-mm-dd)
     * @return LocalDateTime
     */
    public static LocalDateTime StringToLocalDateTime(String dateString) {
       ;
        String defaultValue ="T00:00:00.000000000";

        return LocalDateTime.parse((dateString+defaultValue).replace('/','-'));
    }

    /**
     *
     * @param dateString(yyyy/mm/dd)Or(yyyy-mm-dd)
     * @return LocalDateTime
     */
    public static LocalDateTime StringTOLastMomentOfDay(String dateString) {
        ;
        String defaultValue ="T23:59:59.999";

        return LocalDateTime.parse((dateString+defaultValue).replace('/','-'));
    }
}


