package ept.volunteer.ws.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Provide methods that are common to the whole project
 */
public class CommonUtils {

    //private constructor to hide the implicit public one
    private CommonUtils() {
        throw new IllegalStateException(CommonUtils.class.getName() + Constant.SPACE + Constant.NOT_EXIST);
    }

    /**
     * @param s input String
     * @return: return true if String s is blank or null
     */
    public static boolean isEmpty(String s) {
        return null == s || Constant.BLANK.equals(s);
    }

    /**
     * @param a
     * @return return true if length of Array a is 0 or an equals null
     */
    public static boolean isEmpty(String[] a) {
        return null == a || a.length == 0;
    }

    public static boolean isListObjectEmpty(List<Object> objs) {
        return null == objs || objs.isEmpty();
    }

    public static Long generateRandomId() {
        UUID uuid = UUID.randomUUID();
        long mostSignificantBits = uuid.getMostSignificantBits();
        return Math.abs(mostSignificantBits);
    }
}
